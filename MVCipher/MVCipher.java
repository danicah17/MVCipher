// imports go here

/**
 *	MVCipher - Add your description here
 *	Requires Prompt and FileUtils classes.
 *	
 *	@author Danica Huang	
 *	@since	September 
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
		
		while (!done) {
			word = Prompt.getString("Please input a word to use as key (letters only)");
			wordLength = word.length();
			if (word.length > 2) {
				word = word.toUpperCase();
				int input = Prompt.getInt("Encrypt or decrypt?", 1, 2);
				if (input == 1) {
					encrypt();
					done = true;
					encryptFileName = Prompt.getString("Name of file to encrypt");
				}
				else (input == 2) {
					decrypt();
					done = true;
				}
			else {
				System.out.println("ERROR: Key must be all letters and at least 3 characters long");
			}
				
		
		
		/* Prompt for a key and change to uppercase
		   Do not let the key contain anything but alpha
		   Use the Prompt class to get user input */
		
		
		/* Prompt for encrypt or decrypt */
			
			
		/* Prompt for an input file name */
		
		
		/* Prompt for an output file name */
		
		
		/* Read input file, encrypt or decrypt, and print to output file */
		
		
		/* Don't forget to close your output file */
	}
	
	// other methods go here
	public void encrypt() {
	...
	}
	
	public void decrypt() {
		...
	}

	
}
