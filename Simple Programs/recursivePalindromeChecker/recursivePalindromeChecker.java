import java.util.Scanner;

public class recursivePalindromeChecker {
    
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
        
        int middleOfString = inputString.length()/2;
        System.out.println("stringLength is " + inputString.length() + " and the mid point is " + middleOfString);
        
            
            if(!(inputString.charAt(stringIndex)==(inputString.charAt((inputString.length()-1)-stringIndex)))){
                return false;
            }
            
                
            
        return true;
    }
}
