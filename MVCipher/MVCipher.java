// imports go here
import java.util.Scanner;
import java.io.PrintWriter;

/**
 *	MVCipher - Encrypts or decrypts a file based on the user's choice
 *	Requires Prompt and FileUtils classes.
 *	
 *	@author Danica Huang	
 *	@since	September 20th, 2024
 */
public class MVCipher {
	
	// fields go here
		
	/** Constructor */
	public MVCipher() { }
	
	public static void main(String[] args) {
		MVCipher mvc = new MVCipher();
		mvc.run();
	}
	
	/**
	 *	Runs the actual code and the methods
	 */
	public void run() {
		System.out.println("\n Welcome to the MV Cipher machine!\n");
		boolean done = false;
		String word = "";
		
		while (!done) {
			/* Prompt for a key and change to uppercase
		    Using the Prompt class to get user input */
			word = Prompt.getString("Please input a word to use as key "+
			"(letters only) ");
			word = word.toUpperCase();
			done = true;
			if (word.length() < 3) {
				done = false;
			}
			for (int i = 0; i < word.length(); i++) {
				char current = word.charAt(i);
				if (!('A' <= current && current <='Z')) {
					done = false;
				}
			}
			if (!done) {
				System.out.println("ERROR: Key must be all letters"+
				" and at least 3 characters long");
			}
		}
		
		
		/* Prompt for encrypt or decrypt */
			System.out.println("");
			int input = Prompt.getInt("Encrypt or decrypt?", 1, 2);
			System.out.println("");
			String inputFileName = "";
			String outputFileName = "";
			Scanner scanner = null;
			PrintWriter writer = null;
			if (input == 1) {
				/* Prompt for an input file name */
				inputFileName = Prompt.getString("Name of file to encrypt ");
				scanner = FileUtils.openToRead(inputFileName);
				/* Prompt for an output file name */
				outputFileName = Prompt.getString("Name of output file ");
				writer = FileUtils.openToWrite(outputFileName);
				System.out.println("");
				System.out.println("The encrypted file " + outputFileName + 
								" has been created " + 
								"using the keyword -> " + word);
				System.out.println("");
			}
			else if (input == 2) {
				inputFileName = Prompt.getString("Name of file to decrypt ");
				scanner = FileUtils.openToRead(inputFileName);
				/* Prompt for an output file name */
				outputFileName = Prompt.getString("Name of output file ");
				writer = FileUtils.openToWrite(outputFileName);
				System.out.println("");
				System.out.println("The decrypted file " + outputFileName + 
								" has been created " + 
								"using the keyword -> " + word);
				System.out.println("");				
			}	
	
		/* Read input file, encrypt or decrypt, and print to output file */
		if (input == 1) {
			encrypt(scanner, writer, word);
		}
		else if (input == 2) {
			decrypt(scanner, writer, word);
		}	
	}
	
	
	/**
	 *	Encrypts the entire input file and prints it to the output file
	 * @param scanner, writer, word
	 */
	public void encrypt(Scanner scanner, PrintWriter writer, String word) {
		int keyCounter = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			for (int c = 0; c < line.length(); c++) {
				char inputChar = line.charAt(c);
				char keyChar = word.charAt(keyCounter);
				int shift = keyChar - 'A' + 1;
				char offset = '?';
				if ('a' <= inputChar && inputChar <='z') {
					offset = 'a';
				}
				else if ('A' <= inputChar && inputChar <='Z') {
					offset = 'A';
				}
				else {
					writer.print(inputChar);
				}
				if (offset != '?') {
					int origIndex = inputChar - offset;
					int finalIndex = (origIndex + shift) % 26;
					char finalChar = (char)(finalIndex + offset);
					writer.print(finalChar);
					keyCounter = (keyCounter + 1) % word.length();
				}
			}
			writer.println();
		}
	}
	/**
	 *	Decrypts the entire input file and prints it to the output file
	 * @param scanner, writer, word
	 */
	public void decrypt(Scanner scanner, PrintWriter writer, String word) {
		int keyCounter = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			for (int c = 0; c < line.length(); c++) {
				char inputChar = line.charAt(c);
				char keyChar = word.charAt(keyCounter);
				int shift = keyChar - 'A' + 1;
				char offset = '?';
				if ('a' <= inputChar && inputChar <='z') {
					offset = 'a';
				}
				else if ('A' <= inputChar && inputChar <='Z') {
					offset = 'A';
				}
				else {
					writer.print(inputChar);
				}
				if (offset != '?') {
					int origIndex = inputChar - offset;
					int finalIndex = (origIndex - shift + 26) % 26;
					char finalChar = (char)(finalIndex + offset);
					writer.print(finalChar);
					keyCounter = (keyCounter + 1) % word.length();
				}
			}
			writer.println();
		}
	}
}
