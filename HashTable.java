/** 
 * The hashTable class creates an array of type "SortedList" which is a double ended linked list
 * The hasTable class offers a constructor for the hashArray, a hash function which calculates the ascii value of each country name
 * then modulos by 293 to insert the country in array index based on its hash value
 * The hash Table class provides direct access to Sorted List class for insertion, deletion, and finding countries
 * Inserting is added to the array and then added to the end of the sorted list 
 * Print method traverses through the array and prints each array and its associated lists
 * The collided cells function calculates empty and collided cells in the array
 * 
 * @author Jared Henry
 * @version 12/6/2022
 */ 
class HashTable {
	
	
	private SortedList[] hashArray; // array is the hash table
	private int arraySize;
	
	
	// ------------------------------------------------------------
	/** 
	* @hashtable constructor creates the hash table of arrays with array type of linked list
	* 
	*/ 
	public HashTable(int size) // constructor
	{
	arraySize = size;
	hashArray = new SortedList[arraySize]; // create array
	for(int j=0; j<arraySize; j++) // fill array
	hashArray[j] = new SortedList(); // with lists
	}//HashTable constructor
	
	// -------------------------------------------------------------
	/** 
	* @displayTable prints out the index number of the hashtable and the nodes belonging to the hashArray index accessed by user
	* 
	*/ 
	
	public void displayTable()
	{
	for(int j=0; j<arraySize; j++) // for each cell,
	{
	
	System.out.println(j + "."); // display cell number
	hashArray[j].displayList();
	if(hashArray[j].first == null)
	System.out.println("Empty");// display list
	
	}//for loop
	
}//displayTable
	
	// ------------------------------------------------------------
	/** 
	* @hashValue calculates a hashvalue for the linked list to be inserted
	* 
	*/ 
	public int HashValue(String keyName) {

		int keyValue = 0;
	    for(char i:keyName.toCharArray()){
	       keyValue += i;
	    }//end for loop
	    return keyValue % 293;
		
	}//end hash value method
	
	// ------------------------------------------------------------
	/** 
	* @insert method takes in keyName, population, and cases and inserts into a node in a linked list,
	* the node is then inserted into the hashArray
	* 
	* 
	*/ 
	public void insert(String keyName, double population, double cases) // insert a link
	{
	
	Node newNode = new Node(keyName, population, cases);
	
	String key = keyName;
	int hashVal = HashValue(key); // hash the key
	if(newNode.nameKey != null)
	hashArray[hashVal].insertIt(newNode); // insert at hashVal
	
	
	} // end insert()
	// -------------------------------------------------------------
	
	/** 
	* @delete method takes in a string value from the user input and calculates the hashvalue so that it can be compared in the 
	* SortedList classes Delete method 
	* 
	*/ 	

	public void delete(String key) // delete a link
	{

	
	int hashVal = HashValue(key);// hash the key
	try {
	if(hashArray[hashVal].first.nameKey != null)
	hashArray[hashVal].delete(key); // delete link
	}//end try
	catch(NullPointerException e) {
		System.out.println("There is no country to be deleted.");
	}//end catch
	
	} // end delete()
	

	// ------------------------------------------------------------
	/** 
	* @find method locates the index value that the string key is calculated at. 
	* It compares the String key with the Node in the hashArray and returns the index and case rate if the values match
	* if the key doesnt match the Nodes nameKey, then "No results is found" prints to the user
	* @find method takes in a String value and returns "theLink" in the SortedList class if the key is found
	* if the key is not found, the method returns null; 
	* 
	*/ 
	public Node find(String key) // find link
	{
	try {
	int hashVal = HashValue(key); // hash the key
	Node theLink = hashArray[hashVal].findIt(key); // get link
	if(theLink.nameKey.compareTo(key) == 0) {
	System.out.println(theLink.nameKey + " is found at index " + hashVal + " with a case rate of ");
	System.out.printf( "%.3f",theLink.cases/theLink.population*100000);
	return theLink; // return link
	}//end if statement
	else //if key doesnt match node string value at hashvalue index
		System.out.println("No Results Found.");
	return null;
	}//end try
		catch(NullPointerException e) {
		System.out.println("No Results Found.");
		return null;
	}
	}//end find method
//	// ------------------------------------------------------------
	/** 
	* @collisionCount method counts the collided cells and the empty cells of the hashArray
	* 
	*/ 

	public void collisionCount() {
		int collisionCount = 0;
		int emptyCount = 0;
		int nullPointer = 0;
		for(int j = 0; j <= hashArray.length-1; j++) {
			
			try {//if cells have collided
				if(hashArray[j].first.nextNode.nameKey != null && hashArray[j].first.nameKey != null) {
					collisionCount++;
				}//end if statement
				
				}//end try
				catch(NullPointerException e){//if cells are empty
					
					if(hashArray[j].first == null) {
						emptyCount++;
					}
				 nullPointer++;
				}
	}//end for loop
		System.out.println("There are " + emptyCount + " empty cells and " + collisionCount + " collided cells in the hash table.");
}//end collision counter method
	
	
}//end hash table class
/** 
 * Node class creates Nodes for the SortedList class
 * each node is constructed of a string nameKey, double population, and double case number
 * Node nextNode provides access to the nextNode in a double ended linked list
 * 
 * print node method prints the country name and their case rate
 * 
 * @author Jared Henry
 * @version 12/6/2022
 */ 

 class Node {

	String nameKey; 
	double population; 
	double cases; 
	Node nextNode; 
	 
	public Node(String nameKey, double population, double cases) { 
	this.nameKey = nameKey; 
	this.population = population; 
	this.cases = cases; 
	   }//end Node constructor 
	
	   public void printNode() {
		   
	      System.out.printf("%-30s %-20.3f\n", nameKey, 
	(double)cases/population*100000); 
	      
	   }//end print Node method
	   
	 
}//end Node Class