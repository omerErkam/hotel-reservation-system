package abstracts;

public interface Queue<T> {
	void enqueue(T item);
    T dequeue();
    T getFront();
    boolean isEmpty();
    public void clear();
}
