/*
 * Author: William Seaford
 */
package flashcardprogram;

import static flashcardprogram.FlashCardProgram.countCards;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
public class addCard extends JFrame {
    
    File selectedFile;
    
    
    public addCard(File f){
        selectedFile = f;
        this.setSize(300, 400);
        this.setTitle("Add Card class window");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        
        JLabel questionLabel = new JLabel("Please input your question");
        questionLabel.setBounds(15, 15, 250 , 40);
        panel.add(questionLabel);


        final JTextField inputQuestion = new JTextField();
        inputQuestion.setBounds(15, 60,250,40);
        panel.add(inputQuestion);
        
        JLabel answerLabel = new JLabel("Please input your answer");
        answerLabel.setBounds(15, 150, 250 , 20);
        panel.add(answerLabel);


        final JTextField inputAnswer = new JTextField();
        inputAnswer.setBounds(15, 180,250,40);
        panel.add(inputAnswer);
        
        JButton createCard = new JButton("Create Card");
        createCard.setBounds(130,230,130,25 );
        createCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                String question = inputQuestion.getText();
                String answer = inputAnswer.getText();
                try{
                    
                    createCardMethod(question, answer);
                }
                catch (IOException IOe){
                    System.err.println("error in writing");
                }
                
            }

            
        });
        panel.add(createCard);
        
        this.revalidate();
        
    }
    
    public void createCardMethod(String question, String answer) throws IOException {
    
    int cardCount = countCards(selectedFile);
            String newLocation = (cardCount+1) + ".txt";
            
            BufferedWriter write = new BufferedWriter(new FileWriter(selectedFile + "/" + newLocation));
            write.write(question);
            write.newLine();
            write.write(answer);
            write.close(); 
            
            this.dispose();
    }
    
    public static int countCards(File deck){
        return deck.listFiles().length;   
    }
}



