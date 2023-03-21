
/**
* 
* the sorted list class is used for constructing, printing, finding, deleting, and inserting nodes of a country into a linked list
* the sorted list class is accessed by the hashtable which allows the linked list to be inserted into a hasharray or hashtable. 
* 
* 
* @author Jared Henry
* @version 12/6/2022
*/ 

public class SortedList {

	
	
	public Node first; // ref to first list item
	// -------------------------------------------------------------
	/** 
	* @SortedList is the constructor for the linked list
	* 
	*/ 
	public void SortedList() // constructor
	{ 
		first = null; 
	}//end constructor
	
	// -------------------------------------------------------------
	/** 
	* @insert method inserts Nodes into the linked list. Last node inserted equals the last node in the lists
	* 
	*/ 
	
	public void insertIt(Node theLink) // insert link, in order
	{
	String key = theLink.nameKey;
	Node previous = null; // start at first
	Node current = first;
	// until end of list,
	while(current != null)
	//while( current != null && key.compareTo(current.nameKey) > 0 )
	{ // or current > key,
	previous = current;
	current = current.nextNode; // go to next item
	}
	if(previous==null) // if beginning of list,
	first = theLink; // first --> new link
	else // not at beginning,
	previous.nextNode = theLink; // prev --> new link
	theLink.nextNode = current; // new link --> current
	} // end insert()
	// -------------------------------------------------------------
	
	/** 
	* @delete method deletes nodes from the linked list when their name equals a string value input by user for menu option 2
	* 
	* A string value must be passed in to compare key to the nodes of the linked lists
	* 
	*/ 
	
	public void delete(String key) // delete link
	{ // (assumes non-empty list)
	Node previous = null; // start at first
	Node current = first;
	// until end of list,
	while( current != null && key.compareTo(current.nameKey) != 0 )
	{ // or key == current,
	previous = current;
	current = current.nextNode; // go to next link
	}
	// disconnect link
	if(previous==null) // if beginning of list
	first = first.nextNode; // delete first link
	else // not at beginning
		previous.nextNode = current.nextNode; // delete current link
	} // end delete()
	// -------------------------------------------------------------
	/** 
	* @findIt method takes in a string and compares with the nodes of the linked list and returns current if the values match
	* if values dont match then null is returned.
	* 
	*/ 
	
	public Node findIt(String key) // find link
	{
	Node current = first; // start at first
	
	// until end of list,
	while(current != null && current.nameKey.compareTo(key) <= 0)
	{ // or key too small,
	
	if(current.nameKey.compareTo(key) == 0 ) // is this the link?
	return current;// found it, return link
	else
	current = current.nextNode;
	return current = current.nextNode; // go to next item
	}
	return null; // didn’t find it
	} // end find()
	// -------------------------------------------------------------
	/** 
	* @displayList method takes in no parameters nor does it have a return statement. 
	* This method accesses the displayNode method to print out country name and case rate for the linked list
	* 
	*/ 
	public void displayList()
	{
	
	Node current = first; // start at beginning of list
	while(current != null) // until end of list,
	{
	current.printNode(); // print data
	current = current.nextNode;// move to next link
	
	}//end while loop
}//displayList

} // end class SortedList

