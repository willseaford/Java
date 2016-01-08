import java.util.Scanner;

public class palindromeChecker {
    
    public static void main(String args[]){
        Scanner inputScanner = new Scanner(System.in);
        String inputString = "";
        
        System.out.println("please enter a string");
        inputString = inputScanner.nextLine();
        
        if(!checkForPalindrome(inputString)){
            System.out.println("The string you entered is not a palindrome");
        }
        else{
            System.out.println("The string "+ inputString + " is a palindrome");
        }
    }
    
    public static boolean checkForPalindrome(String inputString){
        int stringIndex =0;
        int middleOfString = inputString.length()/2;
        System.out.println("stringLength is " + inputString.length() + " and the mid point is " + middleOfString);
        while(!(stringIndex==middleOfString)){
            System.out.println("checking index" + stringIndex + "(" + inputString.charAt(stringIndex) + ") against " + inputString.charAt((inputString.length()-1)-stringIndex));
            if(!(inputString.charAt(stringIndex)==(inputString.charAt((inputString.length()-1)-stringIndex)))){
                return false;
            }
                stringIndex++;
            }
        return true;
    }
}
