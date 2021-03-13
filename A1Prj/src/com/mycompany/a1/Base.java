package com.mycompany.a1;

public class Base extends Fixed {
	
	private int size;
	private int sequenceNumber;
	private String parentDesc;
	private String base;
	private String myDesc;

	// blue
	public Base() {
		setColor(0, 0, 255);
	}
	
	public int setSize(int i) {
		size = i;
		return size;
	}
	
	public int setSequenceNumber(int i) {
		sequenceNumber = i;
		return sequenceNumber;
	}
	
	public String toString() {
		parentDesc = super.toString();
		base = "Base: ";
		myDesc =  " size = " + size + " seqNum = " + sequenceNumber;
		return base + parentDesc + myDesc ;
	}
}
