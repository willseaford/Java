/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcardprogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author seaford
 */
public class reviewDeck {
    
    public reviewDeck(){
        System.out.println("Success");
    }
    
    public static void reviewDeck(String d) throws FileNotFoundException, IOException{
        
        
        File deck = new File("decks/" + d);
        if(deck.exists()){
            int deckLimit = deck.listFiles().length;
            int cardNumber = 1;
            
            
            BufferedReader read;
            String question;
            String answer;
            
            while(cardNumber <= deckLimit){
                read = new BufferedReader(new FileReader("decks/" + deck + "/" + cardNumber + ".txt"));
                question = read.readLine();
                answer = read.readLine();
                System.out.println(question);
                System.in.read();
                System.out.println(answer);
                System.in.read();
                cardNumber++;
            }
            
        }
        else{
            System.out.println("Deck does not exist");
        }
    }
    
    
}
