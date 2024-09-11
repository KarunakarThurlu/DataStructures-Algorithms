package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StringHandling {
	/*
	  ==================================
	   String Handling Problems
	  ==================================
	  1. Reverse given string. 
	  2. Reverse string by frequency. 
	  3. Find given String is palindrome or not. 
	  4. Find permutations of string. 
	  5. Count vowels and consonants in given string. 
	  6. Check given strings are anagram strings or not
      7. Count each character repeated how many times in given string. 
      8. Reverse the order of words in a given string. 
      9. Find the first non-repeated character in a string 
	 10. Remove duplicate characters from a string.
	  
	 */
	private static final Logger logger = Logger.getLogger(StringHandling.class.getName());

	public static void main(String[] args) {
		//logger.log(Level.INFO, "Reversed String : {0}", reversingString("KarunakarThurlu"));                  		//Output : ulruhTrakanuraK
		//logger.log(Level.INFO, "Reversed String By String : {0}", reversingStringByFrequency("Karunakar",3)); 		//Output : raKanurak
		//logger.log(Level.INFO, "Is Palindrome : {0}", checkPalindromeString("MALAYALAM"));                    		//Output : true
		//logger.log(Level.INFO, "Permutations of string : {0}", permutationsOfString("ABC"));                  		//Output : [CBA, BCA, CAB, ACB, BAC, ABC]
		//logger.log(Level.INFO, "Vowels & Consonants Count : {0}", countVowelsAndConsonants("Linux"));         		//Output : {Consonants=3, Vowels=2}
		//logger.log(Level.INFO, "anagramChecker : {0}", anagramChecker("listen","silent"));         					//Output : true
		//logger.log(Level.INFO, "CharCount in given String : {0}", charCount("kalam"));         				    	//Output : {a=2, k=1, l=1, m=1}
		//logger.log(Level.INFO, "ReverseWords in given String : {0}", reverseWords("Welcome to java world"));      	//Output : world java to Welcome
		//logger.log(Level.INFO, "FirstUniqueCharacter in given String : {0}", firstUniqueCharacter("racecar"));    	//Output : e
		logger.log(Level.INFO, "RemoveDuplicateChars in given String : {0}", removeDuplicateChars("programming"));	//Output : progamin
	}
	
	/**
	 * 10. Remove duplicate characters from a string.
	 * @param str
	 * @return unique characters string
	 */
	public static String removeDuplicateChars(String str) {
		StringBuilder sb =new StringBuilder();
		Map<Character, Character> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			if(!map.containsKey(str.charAt(i))) {
				sb.append(str.charAt(i));
				map.put(str.charAt(i),str.charAt(i));
			}		
		}
		return new String(sb);
	}
	/**
	 * 9. Find the first non-repeated character in a string 
	 * @param str
	 * @return first unique character of given string
	 */
	public static char firstUniqueCharacter(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i))){
				return str.charAt(i);
			}
		}
		
		return '0';
	}
	
	/**
	 * 8. Reverse the order of words in a given string. 
	 * @param str
	 * @return Reversed string in the form of words
	 */
	public static String reverseWords(String str) {
		
		String finalString="";
		String temp="";
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)==' ') {
				finalString=finalString+" "+temp;
				temp="";
			}else{
				temp= str.charAt(i)+temp;
			}
		}
		finalString=finalString+" "+temp;
		
		return finalString;
	}
	
	/**
	 * 7. Count each character repeated how many times in given string. 
	 * @param string
	 * @return map contains each character count
	 */
	public static Map<Character, Integer> charCount(String str) {
		
		//Using streams
		Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
										  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		
		//Using HashMap
		Map<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (charCount.containsKey(str.charAt(i)))
				charCount.put(str.charAt(i), charCount.get(str.charAt(i)) + 1);
			else
				charCount.put(str.charAt(i), 1);
		}

		return charCount;
	}
	
	/**
	 *  6. Check given strings are anagram strings or not
	 * @param first String
	 * @param second String
	 * @return true if first & second strings are anagrams else false
	 */
	public static boolean anagramChecker(String first,String second) {
		//Remove white spaces from given strings if they have
		first  = first.replaceAll("\\s", "");
		second = second.replaceAll("\\s", "");
		
		//if given string lengths are not equal they not anagram strings
		if(first.length()!=second.length())
			return false;
		
		char[] firstArray  =  first.toCharArray();
		char[] secondArray =  second.toCharArray();
		
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		
		for(int i=0;i<firstArray.length;i++) {
			if(firstArray[i]!=secondArray[i])
				return false;
		}
		return true;
	}
	
	/**
	 * 5. Count vowels and consonants in given string.
	 * @param str
	 * @return map contains vowels count & consonants count
	 */
	public static Map<String, Integer> countVowelsAndConsonants(String str){
		Map<String, Integer> count=new HashMap<>();
		
		count.put("Vowels",0);
		count.put("Consonants",0);
		
		String vowels= "aeiouAEIOU";
		
		for(int i=0;i<str.length();i++) {
			if(vowels.indexOf(str.charAt(i))>=0) {
				count.put("Vowels", count.get("Vowels")+1);
			}else {
				count.put("Consonants", count.get("Consonants")+1);
			}
		}
		return count;
	}
	
	/**
	 * 4. Find permutations of string. 
	 * @param string
	 * @return list of permutations string's of given string
	 */
	private static List<String> permutationsOfString(String str) {
		return getPermutationsOfString(str,"",new ArrayList<>());
	}
	private static List<String> getPermutationsOfString(String src, String permutationString,List<String> list) {
		if(src.isEmpty())
			list.add(permutationString);
		for(int i=0;i<src.length();i++) {
			char currentChar=src.charAt(i);
			String nextString = src.substring(0, i)+src.substring(i+1, src.length());
			getPermutationsOfString(nextString,currentChar+permutationString,list);
		}
		return	list;
	}

	/**
	 * 3. Find given String is palindrome or not. 
	 * @param str
	 * @return true if palindrome else false
	 */
	private static boolean checkPalindromeString(String str) {
		int length = str.length();
		char[] charArray = str.toCharArray();
		for (int i = 0; i < str.length() / 2; i++) {
			Character temp = charArray[i];
			charArray[i] = charArray[length - (i + 1)];
			charArray[length - (i + 1)] = temp;
		}
		return new String(charArray).equals(str);
	}


	/**
	 * 2. Reverse string by frequency. 
	 * @param str
	 * @param frequencey
	 * @return reversed string by frequency
	 */
	private static Object reversingStringByFrequency(String str,int frequencey) {
		int length = str.length();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i=i+frequencey) {
			int start=i;
			int end=Math.min(i+frequencey-1, length);
			String reversedSubString = reversingString(str.substring(start, end+1));
			sb.append(reversedSubString);
		}
		return new String(sb);
	}

	/**
	 * 1. Reverse given string.
	 * @param str
	 * @return reversed string
	 */
	private static String reversingString(String str) {
		int length = str.length();
		char[] charArray = str.toCharArray();
		for (int i = 0; i < str.length() / 2; i++) {
			Character temp = charArray[i];
			charArray[i] = charArray[length - (i + 1)];
			charArray[length - (i + 1)] = temp;
		}
		return new String(charArray);
	}
	
}
