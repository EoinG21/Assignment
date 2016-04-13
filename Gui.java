/******************************
 * GUI Class For Assignment
 * Author: Eoin Gorman
 * Finised Date: 12/04/16 
 ******************************/

package com.test.work;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea; 

public class Gui extends JFrame implements ActionListener 
//this class extends JFrame to use Jframe elements and implements ActionListener to use the buttons 
{	
	//Attributes for the class 
	JLabel label1,label2,label3,label4;
	JTextField doc1Box, doc2Box,stopWordsBox;
	JTextArea resultsArea;
	JButton Analyzebutton,chooseFile1button,chooseFile2button,chooseFile3button;
	
	private String file1;
	private String file2;
	private String path1;
	private String path2;
	private String path3;
	protected static String fileName3;
	
	//constructor
	public Gui(String title)
	{
		super (title); //calls the attributes from the super class
		setLayout(new FlowLayout()); //sets layout to flow layout
		
		
		//sets up the different sections of the GUI
		label1 = new JLabel("Enter path to First document");
		add(label1);
		chooseFile1button = new JButton("Chose File");
		add(chooseFile1button);
		chooseFile1button.addActionListener(this);
		doc1Box = new JTextField(42);
		add(doc1Box);
		
		
		label2 = new JLabel("Enter path to Second document");
		add(label2);
		chooseFile2button = new JButton("Chose File");
		add(chooseFile2button);
		chooseFile2button.addActionListener(this);
		doc2Box = new JTextField(42);
		add(doc2Box);
		
		
		label3 = new JLabel("Enter path to a stop words file");
		add(label3);
		chooseFile3button = new JButton("Chose File");
		add(chooseFile3button);
		chooseFile3button.addActionListener(this);
		stopWordsBox = new JTextField(42);
		add(stopWordsBox);
		
		
		label4 = new JLabel("Results");
		add(label4);
		resultsArea = new JTextArea(8,42);
		add(resultsArea);
		
		Analyzebutton = new JButton("Analyze");
		add(Analyzebutton);
		Analyzebutton.addActionListener(this);
		
		
		
		
		setVisible(true); //makes the GUI visible 
		setLocation(300, 200); //sets starting location of GUI window 
		setSize(500, 500); //Sets starting size of GUI window 
		setDefaultCloseOperation(EXIT_ON_CLOSE); //closes the GUI when you press the close window button 
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0)  //operation taken in from the ActionListener 
	{
		if (arg0.getSource() == Analyzebutton) //If the Analyze is pressed 
		{
			file1 = doc1Box.getText(); //The string file1 is set to be the contents of the First text box 
			file2 = doc2Box.getText(); //The string file2 is set to be the contents of the Second text box
			fileName3 = stopWordsBox.getText(); //The string fileName3 is set to be the contents of the third text box
			Filework file = new Filework(file1,file2); //Creates a new file work object with the two paths as the input
			file.removeStopWords();
			file.comdoc();
			resultsArea.setText(Filework.s1);//Prints the contents of the string s1 to the resultArea text box
			resultsArea.append(Filework.s2);//Prints the contents of the string s2 to the resultArea text box
			resultsArea.append(Filework.s3);//Prints the contents of the string s3 to the resultArea text box
			resultsArea.append(Filework.s4);//Prints the contents of the string s4 to the resultArea text box
		}
		if (arg0.getSource() == chooseFile1button) //If the chooseFile1 Button is pressed
		{
			JFileChooser Fc = new JFileChooser("C:\\Users\\Eoin\\Documents"); //creates a new file chooser object
			Fc.setDialogTitle("Chose your first text file");
			if(Fc.showOpenDialog(chooseFile1button)== JFileChooser.APPROVE_OPTION) //makes the file chooser appear 
			{
				//
			}
			path1 = Fc.getSelectedFile().getAbsolutePath(); //sets the string path 1 to be the file path selected in the file chooser 
			doc1Box.setText(path1);//puts the contents of string into the text box 
		}
		if (arg0.getSource() == chooseFile2button) //operates the same as above button
		{
			JFileChooser Fc = new JFileChooser("C:\\Users\\Eoin\\Documents");
			Fc.setDialogTitle("Chose your Second text file");
			if(Fc.showOpenDialog(chooseFile2button)== JFileChooser.APPROVE_OPTION)
			{
				//
			}
			path2 = Fc.getSelectedFile().getAbsolutePath();
			doc2Box.setText(path2);
		}
		
		if (arg0.getSource() == chooseFile3button)//operates the same as above button
		{
			JFileChooser Fc = new JFileChooser("C:\\Users\\Eoin\\Documents");
			Fc.setDialogTitle("Chose your stop words file");
			if(Fc.showOpenDialog(chooseFile3button)== JFileChooser.APPROVE_OPTION)
			{
				//
			}
			path3 = Fc.getSelectedFile().getAbsolutePath();
			stopWordsBox.setText(path3);
		}
	}
	
	//getters and setters for class 
	public String getFile1() {
		return file1;
	}




	public void setFile1(String file1) {
		this.file1 = file1;
	}




	public String getFile2() {
		return file2;
	}




	public void setFile2(String file2) {
		this.file2 = file2;
	}




	public String getPath1() {
		return path1;
	}




	public void setPath1(String path1) {
		this.path1 = path1;
	}




	public String getPath2() {
		return path2;
	}




	public void setPath2(String path2) {
		this.path2 = path2;
	}




	public String getPath3() {
		return path3;
	}




	public void setPath3(String path3) {
		this.path3 = path3;
	}




	public static String getFileName3() {
		return fileName3;
	}




	public static void setFileName3(String fileName3) {
		Gui.fileName3 = fileName3;
	}

}
	
	