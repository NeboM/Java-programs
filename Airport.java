package Algorithms;
/* 
 * Example of LinkedList queue.
 * Representing airplanes waiting for landing instruction.
 * The plane that appeared first at the airport lands first and the plane that arrived last lands last.
 */
public class Airport {
	
	public static void main(String[] args) {
		Airport theLinkedList = new Airport();
		theLinkedList.enqueue("Boeing 747", 524);
		theLinkedList.enqueue("Airbus A300", 256);
		theLinkedList.enqueue("Airbus A380",555);
		theLinkedList.display();
		theLinkedList.dequeue();
		theLinkedList.dequeue();
		theLinkedList.display();
	}
	private class Airplane{	
		public String planeType;
		public int numberOfPassengers;
		
		public Airplane next;
		
		Airplane(String type, int passengers){
			planeType = type;
			numberOfPassengers = passengers;
			next = null;
		}
		public void display() {
			System.out.println("Airplane: " + this.planeType + "  -  Number of passengers: " + numberOfPassengers + ".");
		}
		public String toString() {
			return planeType;
		}
	}
	public Airplane firstArrivedPlane;
	public Airplane lastArrivedPlane;
	
	public Airport() {
		firstArrivedPlane = null;
		lastArrivedPlane = null;
	}
	public boolean isEmpty() {
		return firstArrivedPlane == null;
	}
	public void enqueue(String type, int passengers){
		Airplane oldLast = lastArrivedPlane;
		lastArrivedPlane = new Airplane(type,passengers);
		if(isEmpty()) {
			firstArrivedPlane = lastArrivedPlane;
		}else {
			oldLast.next = lastArrivedPlane;
		}
		System.out.println(lastArrivedPlane + " arrived at the airport.");
	}
	
	public Airplane dequeue() {
		if(isEmpty()) {
			System.out.println("No plane is waiting for landing instruction");
			return null;
		}
		if(firstArrivedPlane == lastArrivedPlane) {
			Airplane temp = firstArrivedPlane;
			firstArrivedPlane = null;
			lastArrivedPlane = null;
			System.out.println("\nAirplane " + temp + " landed.");
			return temp;	
		}else {
			Airplane temp = firstArrivedPlane;
			firstArrivedPlane = firstArrivedPlane.next;
			System.out.println("\nAirplane " + temp + " landed.");
			return temp;
		}
	}
	public void display() {
		System.out.println("\nAirplanes waiting for landing instruction:");
		System.out.println("------------------------------------------");
		if(isEmpty())System.out.println("None\n");
		Airplane thePlane = firstArrivedPlane;
		int k = 1;
		while(thePlane != null) {
			System.out.print(k++ + ")");
			thePlane.display();
			thePlane = thePlane.next;
		}
	}
}

/* OUTPUT: 

Boeing 747 arrived at the airport.
Airbus A300 arrived at the airport.
Airbus A380 arrived at the airport.

Airplanes waiting for landing instruction:
------------------------------------------
1)Airplane: Boeing 747  -  Number of passengers: 524.
2)Airplane: Airbus A300  -  Number of passengers: 256.
3)Airplane: Airbus A380  -  Number of passengers: 555.

Airplane Boeing 747 landed.

Airplane Airbus A300 landed.

Airplanes waiting for landing instruction:
------------------------------------------
1)Airplane: Airbus A380  -  Number of passengers: 555.

*/