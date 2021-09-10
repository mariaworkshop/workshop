import java.util.*;

public class MariaHeresWeek3Homework {
        public static void main(String[] args) {
            String stringOne = "testtset";
            String stringTwo = "test";
            areStringsEqual(stringOne, stringTwo);

            System.out.println(concatenateByExplicitStringBuilder(stringOne, stringTwo));
            printResultOfPalindrome(stringOne);

            String emptyString = "";
            //should have done this like the list and map, but I'm not changing it anymore
            //not sure if I did what was requested now, but I'm not changing that now
            String[] emptyStringArray = createEmptyStringArray(6);
            var randomLetterElements = new ArrayList<String>();

            populateListOfStrings(randomLetterElements,8);
            System.out.println("List before : " + randomLetterElements);
            emptyString = processStringListIntoOthers(randomLetterElements, emptyStringArray);
            System.out.println("List after : " + randomLetterElements);
            System.out.println("The string is now: " + emptyString);
            System.out.println("The array is now:" );
            displayStringArray(emptyStringArray);

            var emptyMap = new HashMap<String ,String>();
            populateMap(emptyMap, 7);
            System.out.println("\nThe map is: " + emptyMap);
            System.out.println("Size of the map is: " + emptyMap.size()); //Get the size of the map
            findName(emptyMap, createRandomString(6));
            testRemovalOfName(emptyMap,"Maria Heres", "maria@test.com");
            sortByKey(emptyMap);
        }

        //Given two strings, check if the strings are equal. After that, [concatenate them into one single string]
        public static String concatenateByExplicitStringBuilder (String textOne, String textTwo) {
            return new StringBuilder().append(textOne).append(textTwo).toString();
        }

        //[Given two strings, check if the strings are equal.] After that, concatenate them into one single string
        public static void areStringsEqual (String textOne, String textTwo) {
            if (textOne.equals(textTwo)) {
                System.out.println(textOne + " is equal to " + textTwo);
            } else {
                System.out.println(textOne + " is NOT equal to " + textTwo);
            }
        }

        //Given a one word string, return true if the string is a palindrome
        // (word that reads the same forwards or backwards - e.g. madam, mom, abba )
        public static boolean isStringPalindrome (String aString) {
            StringBuilder aStringBuilder = new StringBuilder(aString);
            aStringBuilder.reverse();
            return aString.equals(aStringBuilder.toString());
        }

        // Create an empty string, [an empty array of strings], and a list of strings with random upper and lowercase
        // letters
        public static String[] createEmptyStringArray(int length) {
            String[] aStringArray = new String[length];
            for (int i = 0; i<length; i++) {
                aStringArray[i]="";
            }
            return aStringArray;
        }

        //Create an empty string, an empty array of strings,
        // and a list of [strings with random upper and lowercase letters]
        public static String createRandomString(int size) {
            Random aRandom = new Random();
            int lengthOfString = aRandom.nextInt(size)+1;
            String upperAndLowerLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprstuvwxyz";
            StringBuilder aStringBuilder = new StringBuilder(lengthOfString);
            int noOfChars = upperAndLowerLetters.length();
            for (int i=0; i<lengthOfString; i++) {
                aStringBuilder.append(upperAndLowerLetters.charAt(aRandom.nextInt(noOfChars)));
            }
            return aStringBuilder.toString();
        }

        // Create an empty string, an empty array of strings,
        // [and a list of strings with random upper and lowercase letters]
        public static void populateListOfStrings(ArrayList<String> anArrayList, int numberOfElements) {
            for (int i=0; i<numberOfElements; i++) {
                anArrayList.add(createRandomString(15));
            }
        }

        //See processStringListIntoOthers
        public static boolean startsWithVowel(String aString) {
            return "AEIOUaeiou".indexOf(aString.charAt(0)) > 0;
        }

        //See processStringListIntoOthers
        public static boolean respectsRuleForXAnd3(String aString) {
            return (aString.length()<4 || aString.indexOf('x') > 0 || aString.indexOf('X') > 0);
        }

        // Add a couple of K-V entries
        public static void populateMap(HashMap<String, String> aMap, int numberOfElements){
            for (int i=0; i<numberOfElements; i++) {
                String name = createRandomString(6);
                String email = name + "@email.com";
                aMap.put(name, email);
            }
        }

        //Check that map contains a specific name
        public static void findName(HashMap<String, String> aMap, String name) {
            int foundIt=0;
            for (Map.Entry entry:aMap.entrySet()) {
                if (entry.getKey().equals(name)) {
                    //Get the email that contains a specific name
                    System.out.println("The name exists and its email is: " + entry.getValue());
                    foundIt++;
                }
            }
            if (foundIt == 0) { System.out.println("The name doesn't exist"); }
        }

        // Helps print results of isStringPalindrome, since that one had to return true/false
        public static void printResultOfPalindrome (String potentialPalindrome) {
            if (isStringPalindrome(potentialPalindrome)) {
                System.out.println("The " + potentialPalindrome + " string is a palindrome.");
            } else {
                System.out.println("The " + potentialPalindrome + " string is not a palindrome.");
            }
        }

        //Iterate the list.
        public static String processStringListIntoOthers (ArrayList<String> stringArrayListToProcess, String[] arraytoModify) {
            int stringArrayIndex = 0;
            StringBuilder aStrBuilder = new StringBuilder();
            ListIterator<String> anIterator = stringArrayListToProcess.listIterator();
            while (anIterator.hasNext()) {
                String element = anIterator.next();
                //If the word starts with a vowel, make it all lowercase and append it to the empty string
                if (startsWithVowel(element)) {
                    aStrBuilder.append(element.toLowerCase());
                // If the word starts with a consonant, make it all uppercase and add it to the empty array
                } else if (!startsWithVowel(element) && stringArrayIndex < arraytoModify.length) {
                    arraytoModify[stringArrayIndex]=element.toUpperCase();
                    stringArrayIndex++;
                }
                //[If the word contains letter x or X or has less than 3 letters,
                // replace the word with "skipped"] and print into the console the current word and the replaced word
                if (respectsRuleForXAnd3(element)) {
                    anIterator.set("skipped");
                }
            }
            return aStrBuilder.toString();
        }

        // Just printing any array
        public static void displayStringArray (String[] arrayToDisplay) {
            for (String s : arrayToDisplay) {
                System.out.print(s + " ");
            }
        }

        // Remove an entry
        public static void testRemovalOfName (HashMap<String, String> map, String name, String email){
            map.put(name, email);
            System.out.println("The map with a new element is: " + map);
            map.remove("Maria Heres");
            System.out.println("The map with the element removed is: " + map);
        }

        // Sort the map by key
        public static void sortByKey(HashMap<String, String> map)
        {
            TreeMap<String, String> sortedMap = new TreeMap<>(map);
            System.out.println("The sorted TreeMap version is: " + sortedMap);
        }
    }

