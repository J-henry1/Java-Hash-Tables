import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * COP 3530: Project 5 – Hash Tables
 * 
 *  This class reads a file path in from a user, parses the values, inserts each row of CSV file into a country object, the country object then is  inserted in
 *  a binary search tree based on country names
 *  menu options in main method allow user to print the hash table
 *  menu options in main method allow user to remove a country from the hash table in the last position of the array of double ended linked list
 *  menu option in main method allow user to insert a country into the hash table by taking in string name, double population, and double number of cases
 *  menu option in main method allow a user to find a country index in hash Array and GDPPC
 *  menu option in main method allow a user to see total collided and empty cells in the hash table
 *  
 * @author Jared Henry
 * @version 12/6/2022
 *
 */
public class Project {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Data Structures\nProject 5\nN01484167 Jared Henry");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file or path to file you wish to load:");
		String fileName = sc.next();
		System.out.println(fileName);
		Scanner inFile = null;
		int size = 293;
		HashTable theHashTable = new HashTable(size);
		
		
		
		try
		{
			 inFile = new Scanner(new File(fileName));
			 System.out.println("File Read");
			 
		}//end of try for file scanner
		
		catch (FileNotFoundException e)
		{
			
			System.out.println("\nCould not open the file!");
			System.exit(1);
		}//end catch for file error
		
		
		inFile.useDelimiter(",|\n");
		inFile.nextLine();
		while(inFile.hasNext())
		{
			String name = inFile.next();
			String capital = inFile.next();
			double population = Double.parseDouble(inFile.next());
			double gDP = Double.parseDouble(inFile.next());
			double cOVIDCases = Double.parseDouble(inFile.next());
			double cOVIDDeaths = Double.parseDouble(inFile.next());
			double area = Double.parseDouble(inFile.next());
			
			double GDPPC = gDP/population;
			double CFR = cOVIDDeaths/cOVIDCases;
			double CaseRate = (cOVIDCases/population)*100000;
			double DeathRate = cOVIDDeaths/(population/100000);
			double PopDensity = population/area;
			
//			Node c = new Node(name, population, cOVIDCases);
			
		
			theHashTable.insert(name, population, cOVIDCases); 
			//Testing input - C:\Users\henry\OneDrive\Documents\Countries5.csv

		}// end of while loop
		
		
		int menuOption = 1;
		do {
			if(menuOption >  6|| menuOption < 1) {
				System.out.println("Invalid entry! Please enter number from the menu.");
			}
			
			try {
				System.out.println("\n1) Print hash table."
						+ "\n2) Delete a country of a given name."
						+ "\n3) Insert a country of its name, population, and COVID Cases."
						+ "\n4) Search and print a country and its case rate for a given name."
						+ "\n5) Print numbers of empty cells and collided cells."
						+ "\n6) Exit");

					menuOption = sc.nextInt();
						//menuOption = Integer.valueOf(sc.next());
			}//end try 
			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.print("Try again! Please enter an integer value for menu option.\n");		
				menuOption = sc.nextInt();
			}//end of catch for string input
		
	
		
		if(menuOption == 1 ) {

			theHashTable.displayTable();
			
		}//end menuOption 1
		
		if(menuOption == 2) {
			System.out.println("Enter the country name you wish to delete: ");
			String countryKey = sc.next();

			theHashTable.delete(countryKey);
			
			
		}//end menuOption 2
		
		if(menuOption == 3) {

			
			System.out.println("Enter a country Name: ");
			String insertName = sc.next();
			insertName += sc.nextLine();
			System.out.println("Enter country population: ");
			Double insertPop = sc.nextDouble();
			System.out.println("Enter country COVID Cases: ");
			Double insertCases = sc.nextDouble();
			theHashTable.insert(insertName, insertPop, insertCases);
			
			System.out.println(insertName + " is inserted into Hash Table.");
			
			
		}//end menuOption 3
		
		if(menuOption == 4) {

			System.out.println("Enter a country name:");
			String countrySearch = sc.next();
			countrySearch += sc.nextLine();
			theHashTable.find(countrySearch);
			
		}//end menuOption 4
		
		if(menuOption == 5) {
			
			theHashTable.collisionCount();
			
		}//end menuOption 5
		
		}
		while(menuOption != 6);
		
		
	}//end main method

}//end project class
