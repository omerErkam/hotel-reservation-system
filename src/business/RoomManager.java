package business;

import abstracts.ArrayStack;
import abstracts.Stack;
import concretes.DeluxeRoom;
import concretes.DoubleRoom;
import concretes.Reservation;
import concretes.Room;
import concretes.SingleRoom;
import concretes.SuiteRoom;

public class RoomManager {
	private ArrayStack<Room> singlePile;
	private ArrayStack<Room> doublePile;
	private ArrayStack<Room> suitePile;
	private ArrayStack<Room> deluxePile;
	private ArrayStack<Room> bookedRooms;
	
	// All room managements are handled here.
	
	// The rooms are prepared in the constructor according to given amounts.
	public RoomManager(int singleAmount, int doubleAmount, int suiteAmount, int deluxeAmount) {
		singlePile = new ArrayStack<>();
		doublePile = new ArrayStack<>();
		suitePile = new ArrayStack<>();
		deluxePile = new ArrayStack<>();
		bookedRooms = new ArrayStack<>();

		int totalAmount = singleAmount + doubleAmount + suiteAmount + deluxeAmount;
		
		for (int i=deluxeAmount; i>0; i--){
		    deluxePile.push(new DeluxeRoom(totalAmount));
		    totalAmount--;
		}
		
		for (int i=suiteAmount; i>0;i--) {
			suitePile.push(new SuiteRoom(totalAmount));
			totalAmount--;
		}
		
		for (int i=doubleAmount; i>0;i--) {
			doublePile.push(new DoubleRoom(totalAmount));
			totalAmount--;
		}
		
		for (int i=singleAmount; i>0;i--) {
			singlePile.push(new SingleRoom(totalAmount));
			totalAmount--;
		}	
	}
	
	public boolean bookRoom(Reservation reservation) {
		ArrayStack<Room> pile = getPile(reservation.getRoomType());
		if (pile.isEmpty())
			return false; // No available room
		else { // Booking a room
			Room room = pile.pop();
			room.setAvailability(false); // booked
			bookedRooms.push(room);
			return true;
		}
	}
	
	public ArrayStack<Room> getPile(String roomType){
		if (roomType.equals("Single"))
			return singlePile;
		else if (roomType.equals("Double"))
			return doublePile;
		else if (roomType.equals("Suite"))
			return suitePile;
		else if (roomType.equals("Deluxe"))
			return deluxePile;
		else
			throw new IllegalStateException("Undefined room type: "+roomType);
	}
	
	public void makeOddRoomsAvailable() {
		Stack<Room> tempStack = new ArrayStack<>();
		while(!bookedRooms.isEmpty()) {
			Room room = bookedRooms.pop();
			if (room.getRoomNumber() % 2 == 1) {
				room.setAvailability(true);
				ArrayStack<Room> pile = getPile(room.getRoomType());
				pile.push(room);
			} else
				tempStack.push(room);
		}
		while (!tempStack.isEmpty())
			bookedRooms.push(tempStack.pop());
	}

	public void showDetails() {
		if (!singlePile.isEmpty()) {
			System.out.println("Single pile of rooms");
			showPileDetails(singlePile);			
		}
		if (!doublePile.isEmpty()) {			
			System.out.println("Double pile of rooms");
			showPileDetails(doublePile);
		}
		if (!suitePile.isEmpty()) {			
			System.out.println("Suite pile of rooms");
			showPileDetails(suitePile);			
		}
		if (!deluxePile.isEmpty()) {			
			System.out.println("Deluxe pile of rooms");
			showPileDetails(deluxePile);
		}
	}
	
	private void showPileDetails(Stack<Room> pile) {
		Stack<Room> tempStack = new ArrayStack<>();
		while(!pile.isEmpty()) {
			Room room = pile.pop();
			System.out.println(room);
			tempStack.push(room);
		}
		System.out.println();
		
		while(!tempStack.isEmpty())
			pile.push(tempStack.pop());
	}
	
	public void showBookedRooms() {
		showPileDetails(bookedRooms);
	}
}
