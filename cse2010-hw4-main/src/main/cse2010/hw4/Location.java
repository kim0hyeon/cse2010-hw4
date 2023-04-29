package cse2010.hw4;
/*
 * CSE2010 Homework #4: Location.java
 * 
 * DO NOT MODIFY THIS FILE!
 */

public class Location {
	public int row;
	public int col;

	/**
	 * Constructs a location with given row and column coordinates.
	 * @param row  	row index
	 * @param col	column index
	 */
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public String toString() {
		return "[" + row + "," + col + "]";
	}
}