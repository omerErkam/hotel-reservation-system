package business;

import abstracts.ArrayQueue;
import abstracts.Queue;
import abstracts.WaitLine;
import concretes.Reservation;
import other.FileIO;

public class ReservationManager {
	private WaitLine singleWaitLine;
	private WaitLine doubleWaitLine;
	private WaitLine suiteWaitLine;
	private WaitLine deluxeWaitLine;
	
	// All reservation managements are executed here.
	public ReservationManager() {
		singleWaitLine = new WaitLine();
		doubleWaitLine = new WaitLine();
		suiteWaitLine = new WaitLine();
		deluxeWaitLine = new WaitLine();
	}
	
	// To read the text file and save the data to waitLines.
	public void saveReservationData() {
		Queue<Reservation> reservations = new ArrayQueue<>();
        FileIO.readReservationsFromFile(reservations);
        
        while (!reservations.isEmpty())
            addReservationToWaitLine(reservations.dequeue());
	}
	
	public void addReservationToWaitLine(Reservation reservation) {
		String roomType = reservation.getRoomType();
        if (roomType.equals("Single")) {
        	singleWaitLine.add(reservation);
        } else if (roomType.equals("Double")) {
        	doubleWaitLine.add(reservation);
        } else if (roomType.equals("Suite")) {
        	suiteWaitLine.add(reservation);
        } else if (roomType.equals("Deluxe")) {
        	deluxeWaitLine.add(reservation);
        }
    }

	public void processReservations(RoomManager roomManager) {
		singleWaitLine.simulate(roomManager);
		doubleWaitLine.simulate(roomManager);
		suiteWaitLine.simulate(roomManager);
		deluxeWaitLine.simulate(roomManager);
    }
	
	public void showDetails() {
		if (!singleWaitLine.isEmpty()) {
			System.out.println("Single waiting line of reservations...");
			singleWaitLine.displayResult();			
		}
		if (!doubleWaitLine.isEmpty()) {
			System.out.println("Double waiting line of reservations...");
			doubleWaitLine.displayResult();			
		}
		if (!suiteWaitLine.isEmpty()) {
			System.out.println("Suite waiting line of reservations...");
			suiteWaitLine.displayResult();			
		}
		if (!deluxeWaitLine.isEmpty()) {
			System.out.println("Deluxe waiting line of reservations...");
			deluxeWaitLine.displayResult();			
		}
	}
}
