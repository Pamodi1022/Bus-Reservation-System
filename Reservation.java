public class Reservation {
    private Customer customer;
    private Bus bus;
    private int seatNumber;

    public Reservation(Customer customer, Bus bus, int seatNumber) {
        this.customer = customer;
        this.bus = bus;
        this.seatNumber = seatNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bus getBus() {
        return bus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void printReservation() {
        System.out.println("Reservation Details:");
        System.out.println("Bus Number: " + bus.getBusNumber());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Customer Info:");
        customer.printInfo();
    }
}
