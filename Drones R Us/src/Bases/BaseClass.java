package Bases;
import Drones.*;
import Iterators.DroneIterator;
import Iterators.DroneIteratorClass;
import Iterators.OrderIterator;
import Iterators.OrderIteratorClass;
import Orders.*;

public class BaseClass implements Base {
	private String name;
	private int latitude;
	private int longitude;
	private Drone[]drones;
	private Drone[]hangar;
	private Drone[]bay;
	private Order[]orders;
	private int countDrones;
	private int countHangar;
	private int countBay;
	private int countOrders;
	private static final int MAX = 50;
	private static final String SPACE = " ";
	private static final String P_RETOS_E = "[";
	private static final String P_RETOS_D = "]";
	private static final String COMA = ",";
	
	public BaseClass(String name, int latitude, int longitude){
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;	
		drones = new Drone[MAX];
		hangar = new Drone[MAX];
		bay = new Drone[MAX];
		orders = new Order[MAX];
		countDrones=0;
		countHangar=0;
		countBay=0;
		countOrders=0;
	}

	@Override
	public String getBaseName() {
		return name;
	}
	@Override
	public int getLatitude() {
		return latitude;
	}
	@Override
	public int getLongitude() {
		return longitude;
	}
	@Override
	public int getHangarCount() {
		return countHangar;
	}
	@Override
	public int getBayCount() {
		return countBay;
	}
	@Override
	public DroneIterator listHangar() {
		return new DroneIteratorClass(hangar, countHangar);
	}
	@Override
	public DroneIterator listBay() {
		return new DroneIteratorClass(bay, countBay);
	}
	@Override
	public void addDrone(Drone d) {	
		drones[countDrones++] = d;
		hangar[countHangar++] = d;
	}
	@Override
	public int getDronesCount() {
		return countDrones;
	}
	@Override
	public DroneIterator listDrones() {
		return new DroneIteratorClass(drones, countDrones);
	}	
	public String toString() {
		return getBaseName()+SPACE+P_RETOS_E+getLatitude()+COMA+getLongitude()+P_RETOS_D;			
	}
	@Override
	public void addOrder(Order o) {
		orders[countOrders++]=o;
	}
	@Override
	public OrderIterator listOrders() {
		return new OrderIteratorClass(orders, countOrders);
	}
	@Override
	public int getOrderCount() {
		return countOrders;
	}
	@Override
	public void removeDrone(Drone d) {
		String name = d.getId();
		int index = searchIndexDroneOnHangar(name);	
		for(int i = index; i<countHangar-1; i++) {
			hangar[i]=hangar[i+1];
		}
		countHangar--;
		 
	}
	
	public int searchIndexDrone(String drone) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<countDrones && !found)
			if (drones[i].getId().equals(drone))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	@Override
	public boolean existDrone(Drone d) {
		return searchIndexDrone(d.getId())>=0;
	}
	
	public int searchIndexDroneOnHangar(String drone) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<countHangar && !found)
			if (hangar[i].getId().equals(drone))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	@Override
	public boolean existDroneOnHangar(String drone) {
		return searchIndexDroneOnHangar(drone)>=0;
	}

	@Override
	public void disbandSwarm(Drone d) {
		DroneIterator it = ((Swarm)d).listSwarm();
		while(it.hasNext()) {
			Drone drone = it.next();
			if(drone instanceof Swarm) {
				DroneIterator it2 = ((Swarm)drone).listSwarm();
				while(it2.hasNext()) {
				Drone drone2 = it2.next();
				hangar[countHangar++]=drone2;
				}
			}else {
			hangar[countHangar++]=drone;
			}
		}
		removeDrone(d);
	}
	@Override
	public void sendDronesToService(Drone d) {	
			bay[countBay++]=d;	
	}

	@Override
	public void removeToBay() {
		for(int i=0; i<countBay; i++) {
			for(int j=0; j<countHangar; j++) {
				if(hangar[j]==bay[i]) {
					removeDrone(hangar[j]);
				}
			}
		}	
	}

	@Override
	public void removeOrder(Order o) {
		String name = o.getOrderId();
		int index = searchIndexOrder(name);	
		for(int i = index; i<countOrders-1; i++) {
			orders[i]=orders[i+1];
		}
		countOrders--;
		
		
	}

	@Override
	public int searchIndexOrder(String Order) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<countOrders && !found)
			if (orders[i].getOrderId().equals(Order))
				found = true;
			else
				i++;
		if (found)
			result = i;
		return result;
	}

	@Override
	public boolean existOrder(Order o) {
		boolean found = false;
		OrderIterator it = listOrders();
		while(it.hasNext()) {
			Order order = it.next();
			if(order==o)
				found=true;
		}
		return found;
	}	
}
