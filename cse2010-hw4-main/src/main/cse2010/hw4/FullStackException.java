package cse2010.hw4;
/*
 * CSE2010 Homework #4: Stack.java
 * 
 * DO NOT MODIFY THIS FILE!
 */

import java.io.Serial;

public class FullStackException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	public FullStackException() {
		super();
	}

	public FullStackException(String e) {
		super(e);
	}
}