package concretes;

public class Reservation {
	private int reservationID;
    private String customerName;
    private String roomType;
    
    public Reservation(int reservationID, String customerName, String roomType) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.roomType = roomType;
    }
    
    public String toString() {
        return "Reservation ID: " + reservationID + ", Customer Name: " + customerName + ", Room Type: " + roomType;
    }
    
    public int getReservationID() {
        return reservationID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }
}
