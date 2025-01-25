package abstracts;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements Stack<T>{
	
	private T[] stackArray;
    private int topIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    // Yığını oluşturan constructor
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
    	@SuppressWarnings("unchecked")
    	T[] tempStack = (T[])new Object[initialCapacity];
    	stackArray = tempStack;
    	topIndex = -1;
    	initialized = true;
		// TODO Auto-generated constructor stub
	}
    private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("ArrayBag object is not initialized " + "properly.");
		
	}

    public void push(T newEntry) {
		checkInitialization();
		ensureCapacity();
		stackArray[topIndex + 1] = newEntry;
        topIndex++;
    }

	private void ensureCapacity() {
		if (topIndex == stackArray.length - 1) {
			int newLength = 2 * stackArray.length;
			stackArray = Arrays.copyOf(stackArray, newLength);
		}
	}
	
	public T peek() {
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else {
			return stackArray[topIndex];
		}
	}

    public T pop() {
    	checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else {
        	T top = stackArray[topIndex];
        	stackArray[topIndex] = null;
        	topIndex--;
        	return top;		
        }
    }
    
	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	public void clear() {
		while (topIndex >= 0) {
            stackArray[topIndex] = null;
            topIndex--;
        }
	}
}
