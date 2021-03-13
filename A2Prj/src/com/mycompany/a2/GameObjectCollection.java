package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {

	//Creating Vector
	private Vector <GameObject> theCollection = new Vector<GameObject>();

	public GameObjectCollection() {
		//Creating theCollection
		theCollection = new Vector<GameObject>();
	}
	
	@Override
	public void add(GameObject newObject) {
		//Adding an element to theCollection
		theCollection.addElement(newObject); 		
	}
	
	@Override
	public IIterator getIterator() {
		//Returning an Iterator
		return new Iterator();
	}
	
	private class Iterator implements IIterator {
		
		private int currElementIndex;
		
		public Iterator() {
			//Setting the currElementIndex to -1
			currElementIndex = -1;
		}
		
		public boolean hasNext() {
			if (theCollection.size() <= 0) {
				//Returning false
				return false;
			}
			if (currElementIndex == theCollection.size() - 1) {
				//Returning false
				return false;
			}
			//Returning true
			return true;
		}
		
		public GameObject getNext() {
			//Incrementing the currElementIndex
			currElementIndex++;
			return(theCollection.elementAt(currElementIndex));
		}
	}

	public int size() {
		//Returning the size of theCollection
		return theCollection.size();
	}

	public GameObject get(int at) {
		//Returning the GameObject that is located at the index at
		return theCollection.get(at);
	}

	public void remove(GameObject at) {
		//Removing the GameObject that is located at the index at
		theCollection.remove(at);
	}
	
}
