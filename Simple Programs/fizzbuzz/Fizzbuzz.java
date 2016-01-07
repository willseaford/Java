/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fizzbuzz;


public class Fizzbuzz {

    
    public static void main(String[] args) {
       
        int a = 0;
        String message = "";
        
        while (a<=150){
            if(a%3 == 0){
                message = message + "fizz";
            }
            if(a%5 == 0){
                message = message + "buzz";
            }
            if(message.equals("")){
                System.out.println(a);
            }
            else{
                System.out.println(message);
            }
            message = "";
            a++;
        }
    }
    
}
