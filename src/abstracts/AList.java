package abstracts;
import java.util.Arrays;

public class AList<T> implements List<T>{
	private T[] list;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public AList() {
		this(DEFAULT_CAPACITY);
	}
	public AList(int initialCapacity) {
		if(initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}
	public void add(T newEntry) {
		checkInitialization();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	}
	public void add(int newPosition, T newEntry) {
		checkInitialization();
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			if(newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	}

	private void makeRoom (int newPosition) {
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1); 
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		for (int index = lastIndex; index >= newIndex; index--) 
			list[index + 1] = list[index];
	}
	

	public T remove (int givenPosition){
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			T result = list[givenPosition];

			if (givenPosition< numberOfEntries)
				removeGap(givenPosition);
		numberOfEntries--;
		return result;
		}
	else
		throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	private void removeGap(int givenPosition){
		assert (givenPosition >= 1) && (givenPosition< numberOfEntries); 
		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;
		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	}
	
	public void clear() {
	}
	public T getEntry(int givenPosition)
	{
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition < numberOfEntries))
		{
			assert isEmpty();
			return list [givenPosition];
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}
	public T[] toArray() {
		checkInitialization();
		
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int i=0; i < numberOfEntries; i++) {
			result[i] = list[i + 1];
		}
		return result;
	}

	public boolean contains (T anEntry)
	{
		checkInitialization(); 
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries))
		{
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		}
		return found;
	}
	public int getLength() {
		return numberOfEntries;
	}
	public boolean isEmpty() {
		return numberOfEntries ==0;
	}
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("List object is not initialized " + "properly.");
	}
	public T replace (int givenPosition, T newEntry){
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){		
			assert isEmpty();
			T originalEntry = list [givenPosition];
			list [givenPosition] = newEntry;
			return originalEntry;
		}
			else
				throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
