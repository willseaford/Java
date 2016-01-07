package flashcardprogram;

/*
Author: William Seaford
This program is a flash card program centered around the idea of file creation, information extration, display 
and possible delection.

It will work by creating a folder for a "deck" of cards and make text files for each individual card a user
creates. The text file will contain two lines with the question and the answer. The program when selecting that card
will then extract the lines, bringing up the question first and then having the user click to reveal the second line
answer.

Finally the program may contain functionalities to edit and/or delete decks or individual flash cards.
*/


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FlashCardProgram {
 
   
    public static void main(String[] args) throws IOException {
        
        
       JFrame window = new JFrame();
       JPanel panel = new JPanel();
       JList list = new JList();
       JButton addCard = new JButton("Add Card");
       JButton createDeck = new JButton("Create Deck");
       JButton reviewDeck = new JButton("Review Deck");
       
       window = addWindow(window);
       panel = makePanel(panel);
       list = makeList(list);
       JScrollPane listScroller = new JScrollPane(list);
       listScroller = makeScroller(listScroller);
       addCard = makeAddCard(addCard, list);
       reviewDeck = makeReviewDeck(reviewDeck, list);
       createDeck = makeCreateDeck(createDeck);
       
       panel.add(listScroller);
       panel.add(addCard);
       panel.add(reviewDeck);
       panel.add(createDeck);
       list.getSelectedValue();
       window.add(panel);
       window.revalidate();
       
     
            
       
       System.out.println("Thank you for using this application");
       
    }
    
    
       
    
   
    public static void checkMakeDeck(){
       
            System.out.println("New deck name: ");  
            Scanner scanIn = new Scanner (System.in);
            String newDeckName = scanIn.nextLine();
            File newFile = new File("decks/"+ newDeckName);
        
            if(!newFile.exists()){
                newFile.mkdir();
                System.out.println("New deck (" + newDeckName + ") created");  
            }
            else{
                System.out.println("This deck already exists");
                checkMakeDeck();
            }
        
    }
    
    public static void editDeck() throws IOException{
        
        System.out.println("select deck: ");
        Scanner scanIn = new Scanner(System.in);
        String searchForDeck = scanIn.nextLine();
        File searchFile = new File("decks/" + searchForDeck);
        if(searchFile.exists()){   
            String question = getQuestion();
            String answer = getAnswer();

            int cardCount = countCards(searchFile);
            String newLocation = (cardCount+ 1) + ".txt";
            
            BufferedWriter write = new BufferedWriter(new FileWriter(searchFile + "\\" + newLocation));
            write.write(question);
            write.newLine();
            write.write(answer);
            write.close();  
        }
        else{
            System.out.println("'" + searchForDeck + "'" + " does not exist");
        }
        System.out.println("exiting editDeck()");
        
    }
    
    public static String getQuestion(){
        System.out.println("please input the question: ");
        Scanner scanIn = new Scanner(System.in);
        String question = scanIn.nextLine();
        return question;
    }
    
    public static String getAnswer(){
        System.out.println("please input the answer:");
        Scanner scanIn = new Scanner(System.in);
        String answer = scanIn.nextLine();
        return answer;
    }
    
    public static int countCards(File deck){
        return deck.listFiles().length;   
    }
    
    public static void reviewDeck() throws FileNotFoundException, IOException{
        System.out.println("Select deck: ");
        Scanner scanIn = new Scanner(System.in);
        String searchForDeck = scanIn.nextLine();
        
        File deck = new File("decks/" + searchForDeck);
        if(deck.exists()){
            int deckLimit = deck.listFiles().length;
            int cardNumber = 1;
            
            
            BufferedReader read;
            String question;
            String answer;
            
            while(cardNumber <= deckLimit){
                read = new BufferedReader(new FileReader("decks\\" + searchForDeck + "\\" + cardNumber + ".txt"));
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

   
    public static JFrame addWindow(JFrame window){
       window = new JFrame("Flash Card Program (Alpha 0.0.4)");
       window.setResizable(true);
       window.pack();
       window.setSize(420, 580);
       window.setVisible(true);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setLocationRelativeTo(null);
        return window;
    }
    
    public static JPanel makePanel(JPanel panel){
        panel.setLayout(null);
        return panel;
       
    }
    
    public static JList makeList(JList list){
        File overviewOfDecks = new File("decks/");  
        
        if(overviewOfDecks.listFiles().length == 0){
            String listDecks[]= {"(no decks availible)"};
            
            list = new JList(listDecks);
            list.setVisibleRowCount(4);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setBounds(100,75,150,200);
            
       
        }
        else{
            File[] deckList = overviewOfDecks.listFiles();
            String[] listDecks = new String[deckList.length];
            int deckIndex = 0;
            while(deckIndex <= deckList.length-1){
                System.out.println(deckList[deckIndex].getName());
                listDecks[deckIndex] = deckList[deckIndex].getName();
                deckIndex++;
            } 
            list = new JList(listDecks);
            list.setVisibleRowCount(4);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setBounds(100,75,150,200);
        }
        
       
        
            
        return list; 
    }

    private static JScrollPane makeScroller(JScrollPane listScroller) {
        
        listScroller.setBounds(75,75,150, 150);
       
        return listScroller;
    }
    
    public static JButton makeAddCard(JButton addCard, final JList list) throws IOException {
        
        addCard.setVisible(true);
        addCard.setBounds(230,75,150,30);
        addCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                File searchFile = new File("decks/" + list.getSelectedValue());
                if(searchFile.exists()){   
                    addCard addCardWindow = new addCard(searchFile);    
                }
            
                System.out.println("exiting editDeck()");
            }

            
        });
       
        
        return addCard;
    }
    
    public static JButton makeReviewDeck(JButton reviewDeck, final JList list) throws IOException {
        
        reviewDeck.setVisible(true);
        reviewDeck.setBounds(230,165,150,30);
        reviewDeck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                File searchFile = new File("decks/" + list.getSelectedValue());
                if(searchFile.exists()){   
                    addCard addCardWindow = new addCard(searchFile);    
                }
            
                System.out.println("exiting makeReviewDeck()");
            }

            
        });
       
        
        return reviewDeck;
    }
    private static JFrame makeAddCardWindow (JFrame window){
        System.out.println("made it to the settings part of the in house method");
       window = new JFrame("Add Card");
       window.setResizable(true);
       window.pack();
       window.setSize(420, 580);
       window.setVisible(true);
       window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       
       
       return window;
    }
    
    private static JButton makeCreateDeck(JButton createD){
    
        createD.setVisible(true);
        createD.setBounds(230,120,150,30);
        createD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                createDeck c = new createDeck();
            }
            
        });
       
        
        return createD;
    }
    
    
}


