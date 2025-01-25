package abstracts;

import business.RoomManager;
import concretes.Reservation;
import concretes.Room;

public class WaitLine {
	private Queue<Reservation> line;
	private int numberOfArrivals;
	private int numberServed;
	private int totalTimeWaited;
	
	public WaitLine() {
		line = new ArrayQueue<>();
		
	}
	public void add(Reservation reservation) {
	    line.enqueue(reservation);
	}
	
	public void simulate(RoomManager roomManager) {
		// For checking available reservations
		if (line.isEmpty())
			return;
		
		// For checking available rooms
		ArrayStack<Room> roomPile = roomManager.getPile(line.getFront().getRoomType());
		if (roomPile.isEmpty()) 
			return;
		
		// Execution of reservations
		while (!roomPile.isEmpty() && !line.isEmpty()) {
			Reservation reservation = line.getFront();
			if (roomManager.bookRoom(reservation))
				line.dequeue();
			else
				return;
		}
	}
	
	public void displayResult() {
		Queue<Reservation> tempQueue = new ArrayQueue<>();
		while(!line.isEmpty()) {
			Reservation reservation = line.dequeue();
			System.out.println(reservation.toString());
			tempQueue.enqueue(reservation);
		}
		System.out.println();
		
		while(!tempQueue.isEmpty())
			line.enqueue(tempQueue.dequeue());
	}
	
	public boolean isEmpty() {
		return line.isEmpty();
	}
}
