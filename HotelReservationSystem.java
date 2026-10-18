import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category; // Standard, Deluxe, Suite
    double price;
    boolean isBooked;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        ArrayList<Room> rooms = new ArrayList<>();

        // कमरे जोड़ रहे हैं
        rooms.add(new Room(101, "Standard", 2000.0));
        rooms.add(new Room(102, "Standard", 2000.0));
        rooms.add(new Room(201, "Deluxe", 4000.0));
        rooms.add(new Room(301, "Suite", 7500.0));

        while (true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n--- Room List ---");
                for (Room r : rooms) {
                    String status = r.isBooked ? "Booked" : "Available";
                    System.out.println("Room No: " + r.roomNumber + " | Category: " + r.category + " | Price: ₹" + r.price + " | Status: " + status);
                }
            } else if (choice == 2) {
                System.out.print("Enter room number to book: ");
                int rNo = scanner.nextInt();
                boolean found = false;
                for (Room r : rooms) {
                    if (r.roomNumber == rNo) {
                        found = true;
                        if (!r.isBooked) {
                            r.isBooked = true;
                            System.out.println("Room " + rNo + " successfully booked! Total price: ₹" + r.price);
                        } else {
                            System.out.println("This room is already booked.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Room not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter room number to cancel booking: ");
                int rNo = scanner.nextInt();
                boolean found = false;
                for (Room r : rooms) {
                    if (r.roomNumber == rNo) {
                        found = true;
                        if (r.isBooked) {
                            r.isBooked = false;
                            System.out.println("Booking for room " + rNo + " has been cancelled.");
                        } else {
                            System.out.println("This room is already available.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Room not found.");
                }
            } else if (choice == 4) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        }
    }
}