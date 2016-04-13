/******************************
 * Fileworker Class For Assignment
 * Author: Eoin Gorman
 * Finised Date: 12/04/16 
 ******************************/

package com.test.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Filework 
{
	private String fileName1;
	private String fileName2;
	protected static  String s1;
	protected static  String s2;
	protected static  String s3;
	protected static  String s4;
	
	public List<String> Stopwords = new ArrayList<String>();
	public static ArrayList<String> DOC1 = new ArrayList<String>();
	public static ArrayList<String> DOC2 = new ArrayList<String>();

//constructor 
	Filework(String fileName1,String fileName2)
	
	{
	this.fileName1 = fileName1;
	this.fileName2 = fileName2;
	File file1 = new File(Gui.fileName3); //creates new file object 
	try 
	/*every time a new filework object is created the file that 
	 * has been given as a stop word is read word by word into an
	 * array list called stopwords 
	 */
	{
		Scanner input = new Scanner(file1);
		while (input.hasNext())
		{
			String word = input.next();
			Stopwords.add(word);
		}
		input.close();
	}
	catch (FileNotFoundException e)
	{
		System.err.format("File not found\n");
	}
	
	
	
	}
//Methods 
	void removeStopWords() //function to remove stopwords from both documents 
	{
	
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);  //creates a new file object to work with 
		try
		/*loop used to read contents from each file into an array list and while 
		doing so removes all non letter characters and also making them lower string
		for comparison purposes with the stop words file  */
		{
			Scanner input = new Scanner(file1); //creates a new scanner object to read the file
			while (input.hasNext()) //while loop to read next word
			{
				String word = input.next();
				word = word.replaceAll("[^a-zA-Z]", ""); 
				//LEARNED HOW TO DO THE ABOVE LINE OF CODE FROM THIS LINK 
				//http://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
				word = word.toLowerCase();
				if (Stopwords.contains(word))
				{
					//If word found in stop words arraylist do nothing 
				}
				else
				{
					
					DOC1.add(word); //if word not found in stop word adds word to array list called DOC1
					
				}
			}
			input.close();
			
		
		
		}
		catch (FileNotFoundException e)
		{
			System.err.format("File not found\n");
		}
		
		try //operates same as above loop but with the file path in the second document 
		{
			Scanner input = new Scanner(file2); //creates a new scanner object to read the file
			while (input.hasNext()) //while loop to read next word
			{
				String word = input.next();
				word = word.replaceAll("[^a-zA-Z]", "");
				word = word.toLowerCase();
				if (Stopwords.contains(word))
				{
					//System.out.println(num + " is a stop word");
				}
				else
				{
					
					DOC2.add(word);
					
				}
			}
			input.close();
		
		
		}
		catch (FileNotFoundException e)
		{
			System.err.format("File not found\n");
		}
		
		
	}
	
	void comdoc() //Function to compare two array lists 
	{
		//creates a new array list called commonWords and fills it with the contents of Doc1
		ArrayList<String> commonWords = new ArrayList<String>(DOC1);
		//Filters through the contents of commonWords and take out anything thats not in DOC2
		commonWords.retainAll(DOC2);
		float doc1Words = DOC1.size();//gets number of words in doc1
		float doc2Words = DOC2.size();//gets number of words in doc2
		float simWords = commonWords.size();//gets number of words in commonWords
		
		//gets the % similarity by dividing the number of words in Doc2 by the similar words and multiplying it by 100
		float simWordsPersent1 = Math.round((simWords/doc2Words)*100);
		
		s1 = "The number of words in the first document is "+doc1Words+"\n";
		s2 = "The number of words in the Second document is "+doc2Words+"\n";
		s3 ="The number of words in common with the two documents is "+ simWords+"\n";
		s4 ="Document 2 is " + simWordsPersent1 +"% simaler to document 1"+"\n";
	}
	
	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	public static String getS1() {
		return s1;
	}

	public static void setS1(String s1) {
		Filework.s1 = s1;
	}

	public static String getS2() {
		return s2;
	}

	public static void setS2(String s2) {
		Filework.s2 = s2;
	}

	public static String getS3() {
		return s3;
	}

	public static void setS3(String s3) {
		Filework.s3 = s3;
	}

	public static String getS4() {
		return s4;
	}

	public static void setS4(String s4) {
		Filework.s4 = s4;
	}

	public List<String> getStopwords() {
		return Stopwords;
	}

	public void setStopwords(List<String> stopwords) {
		Stopwords = stopwords;
	}

	public static Collection<String> getDOC1() {
		return DOC1;
	}

	public static void setDOC1(ArrayList<String> dOC1) {
		DOC1 = dOC1;
	}

	public static Collection<String> getDOC2() {
		return DOC2;
	}

	public static void setDOC2(ArrayList<String> dOC2) {
		DOC2 = dOC2;
	}
	
}
