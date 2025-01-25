package abstracts;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public final class ArrayQueue<T> implements Queue<T>{
	private T[] queue;
	
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int initialCapacity) {
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
	}
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("ArrayBag object is not initialized " + "properly.");
		
	}
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}
	public T getFront() {
		checkInitialization();
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		else 
			return queue[frontIndex];
	}
	
	public T dequeue() {
		checkInitialization();
		if(isEmpty())
			throw new NoSuchElementException("Queue is empty");
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
			
		}
	}
	private void ensureCapacity() {
		if (frontIndex ==((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int i = 0; i<oldSize -1; i++) {
				queue[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1)%queue.length);
	}
	public T peek() {
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else {
			return queue[frontIndex];
		}
	}
	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}
	}
}