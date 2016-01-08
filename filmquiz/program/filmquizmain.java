import javax.swing.*;
import java.util.*;
import java.io.*;

//Author: Will Seaford
//Purpose: A film quiz which three players can play and select question difficulty, ultimately putting the results in a table 
//which is wrote to an external file that can be view later at any point until the next game overwrites it

class filmquizmain
{
	public static void main (String[] param) throws IOException
	//The main method which calls each other method seperatly to execute the program
	{
		int[] score = {0,0,0};//creates and integer array called score for three plays
		
		introduction();//calls method "induction"
		
		String playeronename = ""; String playertwoname = ""; String playerthreename = "";//declares three players whos names can be inputted at a later date. 
		playeronename = askplayername(); playertwoname = askplayername(); playerthreename = askplayername();//asks each player their name
	
		for(int counter=1; counter<=5; counter++)// calls the method "question" 5 times. passing the variables score and counter into it. 
		{
			score = question(score, counter);
		}		
		
		sortscore(score, playeronename, playertwoname, playerthreename);//calls the method "sortscore"
		
		System.exit(0);//exits the program
	}

	public static void introduction()
	//introduces the players to the game. this is a procedure as it does not return any value
	{
		JOptionPane.showMessageDialog(null, "Hello and welcome to this film quiz");
		JOptionPane.showMessageDialog(null, "This quiz is a three player quiz that will answer 5 questions each");
		JOptionPane.showMessageDialog(null, "The rules are simple. answer the questions correctly to get the points and who ever does so will win the game");
	}

	public static String askplayername()
	//this method asks the player to input their name and so their scores can be distinguished from one another. this is a function as it returns a value
	{
		String input = JOptionPane.showInputDialog("please enter your name:");
		return input;
	}
	
	public static int[] question(int[] score, int counter) throws IOException
	//this is the major part of the method in which the player is asked to select the difficulty they wish for their question to be at which loads the questions from an external file
	//the question is the selected from the array using a random number generator 
	//if the player correctly answers the question. their score is incremented by 1 and the question moves to the next player
	//each player will have three trys to input an answer to allow errors on the first time
	{
		String[] questionarray = new String[10];//creates a string array of size ten
		String[] answersarray = new String[10];//creates a string array of size ten
		
		String[] easyquestionarray = new String[10];//creates a string array of size ten
		String[] easyanswersarray = new String[10];//creates a string array of size ten 
			BufferedReader questionreader = new BufferedReader(new FileReader("C:/filmquiz/read/questions/easy/easyquestions.txt"));//loads the easy questions
				for(int questionarrayinput=0;questionarrayinput<=9;questionarrayinput++)
				{
					easyquestionarray[questionarrayinput] = questionreader.readLine();//reads each line to fit into the array
				}
				
			BufferedReader answersreader = new BufferedReader(new FileReader("C:/filmquiz/read/answers/easy/easyanswers.txt"));//loads the easy answers
				for(int answersarrayinput=0; answersarrayinput<=9;answersarrayinput++)
				{
					easyanswersarray[answersarrayinput] = answersreader.readLine();
				}
		
		String[] mediumquestionarray = new String[10];//creates a string array of size ten
		String[] mediumanswersarray = new String[10];//creates a string array of size ten
				questionreader = new BufferedReader(new FileReader("C:/filmquiz/read/questions/medium/mediumquestions.txt"));//loads the easy questions
				for(int questionarrayinput=0;questionarrayinput<=9;questionarrayinput++)
				{
					mediumquestionarray[questionarrayinput] = questionreader.readLine();//reads each line to fit into the array
				}
				
				 answersreader = new BufferedReader(new FileReader("C:/filmquiz/read/answers/medium/mediumanswers.txt"));//loads the easy answers
				for(int answersarrayinput=0; answersarrayinput<=9;answersarrayinput++)
				{
					mediumanswersarray[answersarrayinput] = answersreader.readLine();
				}
		
		String[] hardquestionarray = new String[10];//creates a string array of size ten
		String[] hardanswersarray = new String[10];//creates a string array of size ten
				questionreader = new BufferedReader(new FileReader("C:/filmquiz/read/questions/hard/hardquestions.txt"));//loads the easy questions
				for(int questionarrayinput=0;questionarrayinput<=9;questionarrayinput++)
				{
					hardquestionarray[questionarrayinput] = questionreader.readLine();//reads each line to fit into the array
				}
				
				answersreader = new BufferedReader(new FileReader("C:/filmquiz/read/answers/hard/hardanswers.txt"));//loads the easy answers
				for(int answersarrayinput=0; answersarrayinput<=9;answersarrayinput++)
				{
					hardanswersarray[answersarrayinput] = answersreader.readLine();
				}
		String input = "";//input for the player
		int scorecounter = 0;
		
		JOptionPane.showMessageDialog(null, "Question " + counter);//output displaying message
		
		for(int  playercounter = 0; playercounter<=2; playercounter++)//start of for loop
		{
			int pnumber = playercounter+1;//player number 
			
			JOptionPane.showMessageDialog(null, "Player " + pnumber + ". It is now your turn");//saying which players turn it is
			
			String DifficultyStringInput = JOptionPane.showInputDialog("Please input the difficulty. 1,2 or 3");//asks for a difficulty input
			int DifficultyInput = Integer.parseInt(DifficultyStringInput);//converts from string to integer
			
			if(DifficultyInput == 1)
			{
					questionarray = easyquestionarray;
					easyanswersarray = easyanswersarray;
					scorecounter = 1;
			}
			else if (DifficultyInput == 2)
			{
				questionarray = mediumquestionarray;
				answersarray = mediumanswersarray;
				scorecounter = 2;
				

			}
			else if (DifficultyInput == 3)
			{
				
				questionarray = hardquestionarray;
				answersarray = hardanswersarray;
				scorecounter = 3;
			}
				
				Random rand = new Random();//random number generator
    			int num = rand.nextInt(10);
			
			for(int questioncounter = 1; questioncounter <= 2; questioncounter++)//player loop
			{
				input = JOptionPane.showInputDialog(questionarray[num]);
				if(input.equalsIgnoreCase(answersarray[num]))//amount of times allowed to answer loop
				{
					score[playercounter] = score[playercounter] + scorecounter;//if correctly answered the score increments by 1
					break;//breaks so no bug allowing player to answer for multiple points
				}// end if statement
			}//end questioncounter loop
		}//end playercounter loop
		return score;//returns the scores of each player back to main to be added. 
	}//end method (question)

	public static void sortscore (int[] score, String playeronename, String playertwoname, String playerthreename) throws IOException
	//this method sorts the scores of the players using bubble sort and then writes the scores to an external file that can be view at a later date
	{
		String[] name ={playeronename,playertwoname,playerthreename};//creates array for players
		int tempscore = 0;//temp score slot for bubble array
		String tempname = "";//temp player name for sort array
		boolean sorted = false;
		
		JOptionPane.showMessageDialog(null, name[0] +" has " + score[0] + "\n" + name[1] + " has " + score[1] + "\n" + name[2] + " has " + score[2]);//displays players scores before sort	

		while(!sorted)
		{
			for(int position = 0;position<score.length-1;position++)
			{
				
				if(score[position]<score[position+1])
				{
					tempscore = score[position+1];//moves players scores if one is bigger than the other
					score[position+1] = score[position];//moves 2nd to 1st
					score[position] = tempscore;//puts the original first into second
					
					tempname = name[position+1];//does the same but with player names
					name[position+1] = name[position];
					name[position] = tempname;
					
					if(score[0]>=score[1] && score[0]>=score[2] && score[1]>=score[2])// exits the loops when correctly sorted using the values here
					{sorted = true;}//this will allow exiting of the loop
				}//end if
			}//end for
		}//end while
		
		JOptionPane.showMessageDialog(null, name[0] + " is first with " + score[0] + "\n" + name[1] + " is second with " + score[1] + "\n" + name[2] + " is third with " + score[2]); //displays the score after sort.
		
		BufferedWriter writescores = new BufferedWriter(new FileWriter("C:/filmquiz/write/scores/scores.txt"));//Writes to a file named scores.txt
		
		writescores.write(name[0] + " is in first place with a score of " + score[0]);//puts first place and their score in the first line
		writescores.newLine();//tells the writer to make a new line
		
		writescores.write(name[1] + " is in second place with a score of " + score[1]);//puts second place and the score in the second line
		writescores.newLine();//tells the writer to make a new line
		
		writescores.write(name[2] + " is in third place with a score of " + score[2] );
		writescores.newLine();
		
		writescores.close();//closes the file writing
		
		JOptionPane.showMessageDialog(null, "The scores have now been recorded to a file which can be used to view the previous scores");
		
		JOptionPane.showMessageDialog(null, "Thanks for playing");
	}//end method(sortscore)
}//end class
		
