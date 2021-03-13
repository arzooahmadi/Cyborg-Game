package com.mycompany.a2;

public class Base extends Fixed {

	private int size = 10;
	private int sequenceNumber;
	private String parentDesc;
	private String base;
	private String myDesc;

	public Base() {
		//Set the color of the base to blue
		setColor(0, 0, 255);
	}
	
	public int setSize(int i) {
		//Set the size of the base to i
		size = i;
		//Return the size of the base
		return size;
	}
	
	public int setSequenceNumber(int i) {
		//Set the sequence number of the base to i
		sequenceNumber = i;
		//Return the sequence number of the base
		return sequenceNumber;
	}
	
	public String toString() {
		parentDesc = super.toString();
		base = "Base: ";
		myDesc =  " size = " + size + " seqNum = " + sequenceNumber;
		//Return a combination of the different strings
		return base + parentDesc + myDesc ;
	}
	
}
