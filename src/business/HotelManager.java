package business;

public class HotelManager {
	private ReservationManager reservationManager;
	private RoomManager roomManager;
	
	public HotelManager() {
        roomManager = new RoomManager(5, 5, 5, 5);
        reservationManager = new ReservationManager();
        reservationManager.saveReservationData();
	}
	
	public void showAvailableRooms() {
		roomManager.showDetails();
	}
	public void showBookedRooms() {
		roomManager.showBookedRooms();
	}
	
	public void showReservations() {
		reservationManager.showDetails();
	}
	
	public void simulateWaitlines() {
		reservationManager.processReservations(roomManager);
	}
	
	public void makeOddRoomsAvailable() {
		roomManager.makeOddRoomsAvailable();
	}
}
