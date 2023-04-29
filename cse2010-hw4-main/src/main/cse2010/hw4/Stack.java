package cse2010.hw4;
/*
 * CSE2010 Homework #4: Stack.java
 * 
 * DO NOT MODIFY THIS FILE!
 */

public interface Stack<T> {
	/**
	 * Pushes an item onto the top of this stack.
	 * @param item The item to be pushed onto this stack
	 */
	void push(T item);

	/**
	 * Removes the item at the top of this stack and returns that item as the value of this function.
	 * @return The object at the top of this stack
	 * @throws EmptyStackException if this stack is empty
	 */
	T pop() throws EmptyStackException;

	/**
	 * Returns the item at the top of this stack without removing it from the stack.
	 * @return The item at the top of this stack
	 * @throws EmptyStackException if this stack is empty
	 */
	T top() throws EmptyStackException;

	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items; false otherwise.
	 */
	boolean isEmpty();

	/**
	 * Tests if this stack is full.
	 * @return true if and only if this stack is full; false otherwise.
	 */
	boolean isFull();
}