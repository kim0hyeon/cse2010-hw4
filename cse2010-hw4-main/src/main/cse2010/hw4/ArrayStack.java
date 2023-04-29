package cse2010.hw4;
/*
 * CSE2010 Homework #4: ArrayStack.java
 *
 * Complete your stack here
 */

public class ArrayStack<T> implements Stack<T> {
	public static final int MaxSize = 100;
	private final T[] elements;
	private int top = -1;
	private int capacity = 0;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		elements = (T[]) new Object[MaxSize];
		this.capacity = MaxSize;
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		elements = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	@Override
	public void push(T obj) {
		if (isFull())
			throw new FullStackException("Stack Overflow");

		// Your code here
	}

	@Override
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Underflow");
		}

		// Your code here

		return null;
	}

	@Override
	public T top() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Underflow");
		}

		// Your code here
		return null;
	}

	@Override
	public boolean isEmpty() {
		// Your code here
		return false;
	}

	@Override
	public boolean isFull() {
		return top == capacity - 1;
	}
}