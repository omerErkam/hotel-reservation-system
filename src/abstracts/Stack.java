package abstracts;

public interface Stack<T> {
	    void push(T item);
	    T pop();
	    public T peek();
	    public boolean isEmpty();
	    public void clear();    
}