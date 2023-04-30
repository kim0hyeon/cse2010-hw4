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

		// top 과 cpapcity 를 1 증가시키고 obj를 top 자리에 넣는다.
		top++;
		elements[top] = obj;
	}

	@Override
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Underflow");
		}
		// obj를 꺼내 저장하고 top과 capacity를 1 감소시킨다.
		T object = elements[top];
		top--;
		return object;
	}

	@Override
	public T top() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Underflow");
		}
		// top 위치에 있는 T를 출력한다.
		return elements[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1; // -1이라면 true가 출력될 것이고 아니라면 false가 출력될 것이다.
	}

	@Override
	public boolean isFull() {
		return top == capacity - 1;
	}
}