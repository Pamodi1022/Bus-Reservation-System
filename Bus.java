//Class class
public class Bus {
    private String busNumber;
    private int totalSeats;
    private String startingPoint;
    private String endingPoint;
    private String startingTime;
    private double fare;
    private boolean[] seats;

    public Bus(String busNumber, int totalSeats, String startingPoint, String endingPoint, String startingTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.seats = new boolean[totalSeats];
    }

    public String getBusNumber() {
        return busNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public double getFare() {
        return fare;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return !seats[seatNumber - 1];
    }

    public void bookSeat(int seatNumber) {
        seats[seatNumber - 1] = true;
    }

    public void cancelSeat(int seatNumber) {
        seats[seatNumber - 1] = false;
    }

    public void showSeatingPlan() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print((seats[i] ? "X" : "O") + " ");
        }
        System.out.println();
    }
}
