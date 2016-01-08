import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfMultiplication {

    public static void main(String[] args) {
        long inputNumber = getInputNumber();
        int powerOf = getInputPower();
        multiplicationToPowerOf(inputNumber, powerOf);
        
        
    }  
    
    public static long getInputNumber(){
        long retrievedInput = -1;
        Scanner inputScanner = new Scanner(System.in);
        try{
            System.out.println("Please give an integer");
            retrievedInput = inputScanner.nextInt();          
        }
        
        catch(InputMismatchException SME){
            System.out.println("An integer was not given");
             retrievedInput = getInputNumber();
        }
        return retrievedInput;
    }
    
    public static int getInputPower(){
        int retrievedPower = 1;
        Scanner inputPowerScanner = new Scanner(System.in);
        try{
            System.out.println("Please give an number to times the integer before to the power of");
            retrievedPower = inputPowerScanner.nextInt();   
            
            if(retrievedPower <=0){
                System.out.println("An acceptable integer was not given, please be above 0");
                retrievedPower = getInputPower();
            }
        }
        
        catch(InputMismatchException SME){
            System.out.println("An integer was not given");
             retrievedPower = getInputPower();
        }
        return retrievedPower;
    }

    private static void multiplicationToPowerOf(long inputNumber, int powerOf) {
        long sumDigit = inputNumber;
        System.out.println("the input sum is " + inputNumber + "^(" + powerOf + ")...");
        System.out.println(inputNumber);
        while (powerOf > 1){
           sumDigit = sumDigit * inputNumber;
           powerOf = powerOf - 1;
           System.out.println(sumDigit);
       }
    }
    
}
