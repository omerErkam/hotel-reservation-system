package app;


import business.HotelManager;

public class HotelReservationSystem {
	public static void main(String[] args) {
		HotelManager hotelManager = new HotelManager();
		
		hotelManager.showAvailableRooms();
		
		System.out.println("*******************");
		
		hotelManager.showReservations();
		
		System.out.println("*******************");
		
		System.out.println("Execution of reservations(waitlines) and situation of piles..........\n");
		hotelManager.simulateWaitlines();
		
		System.out.println("Remaining rooms..........");
		hotelManager.showAvailableRooms();
		
		System.out.println("Remaining reservations............");
		hotelManager.showReservations();
		
		System.out.println("*******************");
		
		System.out.println("Making odd rooms available...\n");
		hotelManager.makeOddRoomsAvailable();
		hotelManager.showAvailableRooms();
		
		System.out.println("Again execute reservations(waitlines)...\n");
		hotelManager.simulateWaitlines();
		
		System.out.println("Remaining reservations............");
		hotelManager.showReservations();

		System.out.println("*******************");
		System.out.println("Available Rooms");
		hotelManager.showAvailableRooms();
		
		System.out.println("Unavailable Rooms.......");
		hotelManager.showBookedRooms();
	}
}
