/*
 * Author: William Seaford
 */
package flashcardprogram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author william
 */
public class createDeck extends JFrame {
    
    public createDeck(){
        System.out.println("opening createDeck");
        this.setSize(300, 400);
        this.setTitle("Create Deck");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        
        JLabel deckLabel = new JLabel("Input deck name: ");
        deckLabel.setBounds(15, 15, 250 , 40);
        panel.add(deckLabel);


        final JTextField inputDeckName = new JTextField();
        inputDeckName.setBounds(15, 60,250,40);
        panel.add(inputDeckName);
        
        
        JButton createDeck = new JButton("Create");
        createDeck.setBounds(130,230,130,25 );
        createDeck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                String input = inputDeckName.getText();
                createDeckmethod(input);
            }

            
        });
        panel.add(createDeck);
                
    
    }
    
    public void createDeckmethod(String input){
    
        
            String newDeckName = input;
            File newFile = new File("decks/"+ newDeckName);
        
            if(!newFile.exists()){
                newFile.mkdir();
                System.out.println("New deck (" + newDeckName + ") created");  
            }
            else{
                System.out.println("This deck already exists");
                this.dispose();
                new createDeck();
            }
    
    }
}
