package other;
import java.util.Scanner;

import abstracts.Queue;
import concretes.Reservation;

import java.io.File;
import java.io.FileNotFoundException;

public class FileIO {
	public static void readReservationsFromFile(Queue<Reservation> reservations) {
        try {
            Scanner scanner = new Scanner(new File("reservationsFile.txt"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(",");


                int reservationID = Integer.parseInt(parts[0]);
                String customerName = parts[1];
                String roomType = parts[2];


                Reservation reservation = new Reservation(reservationID, customerName, roomType);
                reservations.enqueue(reservation);
            }

            scanner.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}

