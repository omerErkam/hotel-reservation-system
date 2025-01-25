package abstracts;

public interface List<T> {
	public void add(T newEntry);
	public void add(int newPoisition, T newEntry);
	public T remove(int givenPosition);
	public void clear();
	public T replace(int givenPosition, T newEntry);
	public T getEntry(int givenPoisition);
	public T[] toArray();
	public boolean contains(T anEntry);
	public int getLength();
	public boolean isEmpty();
	
	
}
