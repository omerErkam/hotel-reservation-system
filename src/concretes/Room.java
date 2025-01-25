package concretes;

public class Room {
	private int roomNumber;
    private String roomType;
    private boolean availability;
    
    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = true; // Rooms are available initially
    }
    
    public String toString() {
    	return "Room_" + roomNumber + ": " + roomType + " " + (availability ? "Available" : "Booked");
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
