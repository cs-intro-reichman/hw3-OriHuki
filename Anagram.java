/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if (str1.length() != str2.length()) {
			return false;}
		
		if (str1.length() == str2.length()) {
	
			for (int i = 0; i < str1.length(); i++) {
				boolean match = false; 
				for (int j = 0 ; j < str2.length(); j++) {
					if (str1.charAt(i)==str2.charAt(j)) {
						match = true;
						str2 = str2.substring(0, j) + "*" + str2.substring(j + 1); // it takes the match letter and replace it by other letter like *
						break; // if there is a match chat it exit from the inside loop 							
					}
						
				}
					
			}
			if (!match) {return false;} //if there isnt a match between chars it return false which mean it isnt an anagram
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		for (int i = 0; i <str.length(); i++) {
			if (str.charAt(i)>=65 && str.charAt(i)<=90 || str.charAt(i) >=97 && str.charAt(i)<=122) {
				System.out.print(str.charAt(i));
			}
		}
		return "";
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomAnagram ="";
		while (str.length() > 0) {
			int randomIndex = (int) (Math.random() * str.length());
			char randomChar = str.charAt(randomIndex);
			randomAnagram = randomAnagram + randomChar;
			str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
		}
		return randomAnagram;
	}
}
