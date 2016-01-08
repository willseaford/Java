import java.util.Scanner;
public class stringIntake {
    
    public static void main(String args[]){
    
        String sentence = "    Hello my name is william     ";
        char characterW = 'w';
        
        compareString(sentence, characterW);
    }
    
    public static void compareString(String sentence, char characterW){
    
    System.out.println(sentence);
    sentence = sentence.trim();
    System.out.println(sentence);
    
    for(int i=0;i<=sentence.length();i++){
        if(sentence.charAt(i)==characterW){
        System.out.println("success found at position " + i);
        break;
        }
        System.out.println("position " + i + " (" + sentence.charAt(i) + ") does not match w");
    }
    
    }
}
