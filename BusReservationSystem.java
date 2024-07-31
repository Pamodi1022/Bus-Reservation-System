import java.util.*;
import java.util.regex.Pattern;

public class BusReservationSystem {
    private static Scanner input = new Scanner(System.in);
    private static List<Customer> customers = new ArrayList<>();
    private static List<Bus> buses = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Bus Reservation System");
        while (true) {
            System.out.println("1. Register Customer");
            System.out.println("2. Register Bus");
            System.out.println("3. Search Buses");
            System.out.println("4. Reserve Seat");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Show All Reservations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    registerBus();
                    break;
                case 3:
                    searchBuses();
                    break;
                case 4:
                    reserveSeat();
                    break;
                case 5:
                    cancelReservation();
                    break;
                case 6:
                    showAllReservations();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerCustomer() {
        String name;
        while (true) {
            try {
                System.out.print("Enter Customer Name: ");
                name = input.nextLine();
                if (!isAlpha(name)) {
                    throw new IllegalArgumentException("Name must contain only letters.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String mobileNumber;
        while (true) {
            try {
                System.out.print("Enter Mobile Number: ");
                mobileNumber = input.nextLine();
                if (!isNumeric(mobileNumber)) {
                    throw new IllegalArgumentException("Mobile number must contain only digits.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String emailID;
        while (true) {
            try {
                System.out.print("Enter Email ID: ");
                emailID = input.nextLine();
                if (!isValidEmail(emailID)) {
                    throw new IllegalArgumentException("Invalid Email ID format.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String city;
        while (true) {
            try {
                System.out.print("Enter City: ");
                city = input.nextLine();
                if (!isAlpha(city)) {
                    throw new IllegalArgumentException("City must contain only letters.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int age;
        while (true) {
            try {
                System.out.print("Enter Age: ");
                if (!input.hasNextInt()) {
                    input.next(); 
                    throw new InputMismatchException("Age should be an integer.");
                }
                age = input.nextInt();
                input.nextLine();
                if (age < 0) {
                    throw new IllegalArgumentException("Age cannot be negative.");
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine(); 
            }
        }

        Customer customer = new Customer(name, mobileNumber, emailID, city, age);
        customers.add(customer);
        System.out.println("Customer registered successfully.");
    }

    private static void registerBus() {
        String busNumber;
        while (true) {
            try {
                System.out.print("Enter Bus Number: ");
                busNumber = input.nextLine();
                if (!isNumeric(busNumber)) {
                    throw new IllegalArgumentException("Bus Number must be an integer.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int totalSeats;
        while (true) {
            try {
                System.out.print("Enter Total Seats: ");
                totalSeats = input.nextInt();
                if (totalSeats <= 0) {
                    throw new IllegalArgumentException("Total Seats must be a positive integer.");
                }
                input.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Total Seats must be an integer.");
                input.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine(); 
            }
        }

        double fare;
        while (true) {
            try {
                System.out.print("Enter Fare: ");
                fare = input.nextDouble();
                if (fare < 0) {
                    throw new IllegalArgumentException("Fare cannot be negative.");
                }
                input.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Fare must be a number.");
                input.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine(); 
            }
        }

        String startingPoint;
        while (true) {
            try {
                System.out.print("Enter Starting Point: ");
                startingPoint = input.nextLine();
                if (!isAlpha(startingPoint)) {
                    throw new IllegalArgumentException("Starting Point must contain only letters.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String endingPoint;
        while (true) {
            try {
                System.out.print("Enter Ending Point: ");
                endingPoint = input.nextLine();
                if (!isAlpha(endingPoint)) {
                    throw new IllegalArgumentException("Ending Point must contain only letters.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String startingTime;
        while (true) {
            try {
                System.out.print("Enter Starting Time (e.g., 6 p.m): ");
                startingTime = input.nextLine();
                if (!isValidTimeFormat(startingTime)) {
                    throw new IllegalArgumentException("Starting Time must be in the format 'X a.m' or 'X p.m'.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Bus bus = new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
        buses.add(bus);
        System.out.println("Bus registered successfully.");
    }

    private static void searchBuses() {
        String startingPoint;
        while (true) {
            System.out.print("Enter Starting Point: ");
            startingPoint = input.nextLine();
            if (isAlpha(startingPoint)) {
                break;
            } else {
                System.out.println("Starting Point must contain only letters.");
            }
        }

        String endingPoint;
        while (true) {
            System.out.print("Enter Ending Point: ");
            endingPoint = input.nextLine();
            if (isAlpha(endingPoint)) {
                break;
            } else {
                System.out.println("Ending Point must contain only letters.");
            }
        }

        String startingTime;
        while (true) {
            System.out.print("Enter Starting Time (e.g., 6 p.m): ");
            startingTime = input.nextLine();
            if (isValidTimeFormat(startingTime)) {
                break;
            } else {
                System.out.println("Starting Time must be in the format 'X a.m' or 'X p.m'.");
            }
        }

        boolean busFound = false;
        for (Bus bus : buses) {
            if (bus.getStartingPoint().equalsIgnoreCase(startingPoint) &&
                    bus.getEndingPoint().equalsIgnoreCase(endingPoint) &&
                    bus.getStartingTime().equalsIgnoreCase(startingTime)) {
                System.out.println("Bus Number: " + bus.getBusNumber());
                bus.showSeatingPlan();
                busFound = true;
            }
        }

        if (!busFound) {
            System.out.println("No buses found for the given criteria.");
        }
    }

    private static boolean isAlpha(String str) {
        return str != null && str.matches("[a-zA-Z]+");
    }

    private static boolean isValidTimeFormat(String time) {
        String timeRegex = "^(0?[1-9]|1[0-2])\\s(a\\.m|p\\.m)$";
        return Pattern.matches(timeRegex, time);
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    private static void reserveSeat() {
        String mobileNumber;
        while (true) {
            try {
                System.out.print("Enter Customer Mobile Number: ");
                mobileNumber = input.nextLine();
                if (!isNumeric(mobileNumber)) {
                    throw new IllegalArgumentException("Mobile Number must be numeric.");
                }

                Customer customer = findCustomerByMobile(mobileNumber);
                if (customer == null) {
                    System.out.println("Customer not found.");
                    continue;
                }
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String busNumber;
        while (true) {
            try {
                System.out.print("Enter Bus Number: ");
                busNumber = input.nextLine();
                if (!isNumeric(busNumber)) {
                    throw new IllegalArgumentException("Bus Number must be numeric.");
                }
                
                Bus bus = findBusByNumber(busNumber);
                if (bus == null) {
                    System.out.println("Bus not found.");
                    continue; 
                }
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int seatNumber;
        while (true) {
            try {
                System.out.print("Enter Seat Number: ");
                seatNumber = Integer.parseInt(input.nextLine());
                if (seatNumber < 1) {
                    throw new IllegalArgumentException("Seat number must be a positive integer.");
                }
                
                Bus bus = findBusByNumber(busNumber);
                if (!bus.isSeatAvailable(seatNumber)) {
                    System.out.println("Seat is already booked.");
                    continue;
                }
                // Book seat
                bus.bookSeat(seatNumber);
                Reservation reservation = new Reservation(findCustomerByMobile(mobileNumber), bus, seatNumber);
                reservations.add(reservation);
                System.out.println("Seat reserved successfully.");
                break; // Seat reservation is successful
            } catch (NumberFormatException e) {
                System.out.println("Seat number must be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void cancelReservation() {
        String mobileNumber;
        while (true) {
            try {
                System.out.print("Enter Customer Mobile Number: ");
                mobileNumber = input.nextLine();
                if (!isNumeric(mobileNumber)) {
                    throw new IllegalArgumentException("Mobile Number must be numeric.");
                }
               
                Customer customer = findCustomerByMobile(mobileNumber);
                if (customer == null) {
                    System.out.println("Customer not found.");
                    continue; 
                }
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String busNumber;
        while (true) {
            try {
                System.out.print("Enter Bus Number: ");
                busNumber = input.nextLine();
                if (!isNumeric(busNumber)) {
                    throw new IllegalArgumentException("Bus Number must be numeric.");
                }
                // Check if bus exists
                Bus bus = findBusByNumber(busNumber);
                if (bus == null) {
                    System.out.println("Bus not found.");
                    continue; 
                }
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int seatNumber;
        while (true) {
            try {
                System.out.print("Enter Seat Number: ");
                seatNumber = Integer.parseInt(input.nextLine());
                if (seatNumber < 1) {
                    throw new IllegalArgumentException("Seat number must be a positive integer.");
                }
                
                Bus bus = findBusByNumber(busNumber);
                Reservation reservation = findReservation(findCustomerByMobile(mobileNumber), bus, seatNumber);
                if (reservation == null) {
                    System.out.println("Reservation not found.");
                    continue; 
                }
                // Cancel reservation
                bus.cancelSeat(seatNumber);
                reservations.remove(reservation);
                System.out.println("Reservation canceled successfully.");
                break; // Reservation canceled successfully
            } catch (NumberFormatException e) {
                System.out.println("Seat number must be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //Show all reservations
    private static void showAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                reservation.printReservation();
            }
        }
    }

    //Find customer
    private static Customer findCustomerByMobile(String mobileNumber) {
        for (Customer customer : customers) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                return customer;
            }
        }
        return null;
    }

    //Find Bus
    private static Bus findBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    //Find reservation
    private static Reservation findReservation(Customer customer, Bus bus, int seatNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer) &&
                    reservation.getBus().equals(bus) &&
                    reservation.getSeatNumber() == seatNumber) {
                return reservation;
            }
        }
        return null;
    }
}
