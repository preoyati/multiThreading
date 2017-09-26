package multiThreading;

public class BusReservation implements Runnable {
	private int totalSeatsAvailable = 2;

	public void run() {
		PassengerThread pt = (PassengerThread) Thread.currentThread();
		boolean ticketsBooked = this.bookTickets(pt.getSeatsNeeded(), pt.getName());
		if(ticketsBooked == true) {
			System.out.println("congratulation " + pt.getSeatsNeeded() +" seats are booked");
		}else {
			System.out.println("Sorry " + pt.getSeatsNeeded() + " seats are not available.");
		}
	}

	public synchronized boolean bookTickets(int seats, String name) {
		System.out.println("Welcome" + Thread.currentThread().getName());
		System.out.println(", available tickets:" + this.getTotalSeatsAvailable());
		
		if(seats>this.getTotalSeatsAvailable()) {
			return false;			
		}else {
			totalSeatsAvailable = totalSeatsAvailable - seats;
			return true;
		}
	}

	private int getTotalSeatsAvailable() {
		return totalSeatsAvailable;
	}

}
