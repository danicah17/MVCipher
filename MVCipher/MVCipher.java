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
	 *	Method header goes here
	 */
	public void run() {
		System.out.println("\n Welcome to the MV Cipher machine!\n");
		boolean done = false;
		String word = "";
		
		while (!done) {
			word = Prompt.getString("Please input a word to use as key "+
			"(letters only)");
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
	
			/* Prompt for a key and change to uppercase
		   Do not let the key contain anything but alpha
		   Use the Prompt class to get user input */
		
		
		/* Prompt for encrypt or decrypt */
			int input = Prompt.getInt("Encrypt or decrypt?", 1, 2);
			String inputFileName = "";
			if (input == 1) {
				inputFileName = Prompt.getString("Name of file to encrypt");
			}
			else if (input == 2) {
				inputFileName = Prompt.getString("Name of file to decrypt");
			}
			String outputFileName = Prompt.getString("Name of output file");
			
		/* Prompt for an input file name */
		
		
		/* Prompt for an output file name */
		
		
		/* Read input file, encrypt or decrypt, and print to output file */
		Scanner scanner = FileUtils.openToRead(inputFileName);
		PrintWriter writer = FileUtils.openToWrite(outputFileName);
		if (input == 1) {
			encrypt(scanner, writer, word);
		}
		else if (input == 2) {
			decrypt(scanner, writer, word);
		}
		
		/* Don't forget to close your output file */
	}
	
	// other methods go here
	
	/**
	 *	Method header goes here
	 */
	public void encrypt(Scanner scanner, PrintWriter writer, String word) {
		int keyCounter = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			for (int c = 0; c < line.length(); c++) {
				char i = line.charAt(c);
				char k = word.charAt(keyCounter);
				int shift = k - 'A' + 1;
				char offset = '?';
				if ('a' <= i && i <='z') {
					offset = 'a';
				}
				else if ('A' <= i && i <='Z') {
					offset = 'A';
				}
				else {
					writer.print(i);
				}
				if (offset != '?') {
					int n = i - offset;
					int x = (n + shift) % 26;
					char e = (char)(x + offset);
					writer.print(e);
					keyCounter = (keyCounter + 1) % word.length();
				}
			}
			writer.println();
		}
	}
	
	public void decrypt(Scanner scanner, PrintWriter writer, String word) {
		int keyCounter = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			for (int c = 0; c < line.length(); c++) {
				char inputChar = line.charAt(c);
				char keyChar = word.charAt(keyCounter);
				int shift = k - 'A' + 1;
				char offset = '?';
				if ('a' <= i && i <='z') {
					offset = 'a';
				}
				else if ('A' <= i && i <='Z') {
					offset = 'A';
				}
				else {
					writer.print(i);
				}
				if (offset != '?') {
					int origIndex = i - offset;
					int finalIndez = (n - shift + 26) % 26;
					char finalChar = (char)(x + offset);
					writer.print(e);
					keyCounter = (keyCounter + 1) % word.length();
				}
			}
			writer.println();
		}
	}
}
