package Application;
import Bases.*;
import Drones.*;
import Iterators.*;
import Mission.*;
import Orders.*;

public class StoreClass implements Store{

	private Base[]bases;
	private Drone[]drones;
	private Order[]orders;
	private Drone[]fly;
	private Order[]delivered;
	private int countDelivered;
	private int countBases;
	private int countDrones;
	private int countOrders;
	private int countFly;
	private int time;
	private static final int MAX = 50;
	
	public StoreClass() {
		bases = new Base[MAX];
		drones = new Drone[MAX];
		orders = new Order[MAX];
		fly = new Drone[MAX];
		delivered = new Order[MAX];
		countBases = 0;
		countDrones = 0;
		countOrders = 0;
		countFly=0;
		countDelivered=0;
		time=0;
	}

	@Override
	public void createBase(Base b) {
		bases[countBases++]=b;
	}	
	@Override
	public boolean existsBase(String base) {
		return searchIndexBase(base)>=0;
	}
	@Override
	public int getCountBases() {
		return countBases;
	}
	@Override
	public DroneIterator listHangar(String base) {
		Base b = bases[searchIndexBase(base)];
		return b.listHangar();
	}
	@Override
	public DroneIterator listBay(String base) {
		Base b = bases[searchIndexBase(base)];
		return b.listBay();
	}	
	@Override
	public BaseIterator listBases() {
		return new BaseIteratorClass(bases, countBases);
	}
	@Override
	public int searchIndexBase(String base) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<countBases && !found)
			if (bases[i].getBaseName().equals(base))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}			
	@Override
	public void addDrone(String base, Drone d) {
		bases[searchIndexBase(base)].addDrone(d);
		drones[countDrones++]=d;
	}
	@Override
	public boolean existsDrone(String drone) {
		return searchIndexDrone(drone)>=0;
	}
	@Override
	public int getCountDrones() {
		return countDrones;
	}
	@Override
	public DroneIterator listDrones() {
		return new DroneIteratorClass(drones, countDrones);
	}
	@Override
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
	public void createOrder(String base, Order d) {	
		bases[searchIndexBase(base)].addOrder(d);
		orders[countOrders++]= d;
	}
	@Override
	public boolean existOrder(String order) {
		return searchIndexOrder(order)>=0;
	}
	@Override
	public int getOrderCount() {
		return countOrders;
	}
	@Override
	public OrderIterator listOrders(String base) {
		Base b = bases[searchIndexBase(base)];
		return b.listOrders();
	}
	@Override
	public OrderIterator listAllOrders() {
		return new OrderIteratorClass(orders, countOrders);
	}
	@Override
	public int searchIndexOrder(String order) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<countOrders && !found)
			if (orders[i].getOrderId().equals(order))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}
	@Override
	public Base objectifyBase(String base) {
		Base b = bases[searchIndexBase(base)];
		return b;
	}
	@Override
	public Drone objectifyDrone(String drone) {
		Drone d = drones[searchIndexDrone(drone)];
		return d;
	}
	@Override
	public boolean compareCordinates(int latitude, int longitude) {
		boolean found=false;
		for(int i=0; i<countBases; i++) {
			if(bases[i].getLatitude()==latitude && bases[i].getLongitude()==longitude) {
				found = true;			
			}	
		}
		return found;
	}

	@Override
	public void removeDroneFromBase(Base b, Drone d) {
		b.removeDrone(d);
		
	}

	@Override
	public boolean existDroneOnBase(Base b, Drone d) {
		return b.existDrone(d);
	}

	@Override
	public int checkForEquals(Drone[] drones, int inicialDrones) {
		int check = -1;
		for(int i=0; i<inicialDrones; i++) {
			for(int x=0; x<i; x++) {
				if(drones[i]==drones[x])
					check=i;
			}		
		}
		return check;
	}

	@Override
	public int checkForKind(Drone[] drones, int inicialDrones) {
		int x = 0;
		for(int i=0; i<inicialDrones; i++) {
			if(drones[i] instanceof HermitDrone) {
				x=1;	
			}
		}
		return x;
	}

	@Override
	public void auxRemoveDrones(Drone[] drones, int inicialDrones, Base b) {
		for(int i=0; i<inicialDrones; i++) {
			Drone d = drones[i];
			b.removeDrone(d);	
		}
		
	}

	@Override
	public int auxExistDroneOnBase(Drone[]drones, Base b, int inicialDrones) {
		int exist=-1;
		for(int i = 0; i<inicialDrones; i++) { 
			Drone d = drones[i];
				if(!existDroneOnBase(b,d)) {
					exist =i;
				}	
		}
		return exist;
	}

	@Override
	public int auxMinimumRange(Drone[] drones, int inicialDrones) {
		int minimum=0;
		for(int i=0; i<inicialDrones; i++) {
			if(minimum==0)
				minimum=drones[i].getRange();				
			else {
				if(drones[i].getRange()<minimum)
					minimum=drones[i].getRange();
			}
			
		}
		return minimum;
	}

	@Override
	public int auxExistDroneOnHangar(Drone[] drones, Base b, int inicialDrones) {
		int exist=0;
		boolean found = false;
		for(int i = 0; i<inicialDrones; i++) { 
			Drone d = drones[i];
				if(existDroneOnHangar(b, d)) {
					exist =i;
					found = true;
				}	
				if(found==true)
					break;
		}
		return exist;
	}

	@Override
	public boolean existDroneOnHangar(Base b, Drone d) {
		return b.existDroneOnHangar(d.getId());
	}

	@Override
	public boolean checkForSwarm(Drone d) {
		boolean found = false;
		if(d instanceof Swarm) {
			found=true;			
		}
		return found;
	}

	@Override
	public boolean checkForThreshold(Base b, int treshold) {
		boolean found = false;
		DroneIterator it = b.listHangar();
		while(it.hasNext()) {
			Drone d = it.next();
			if(d.getRange()<treshold) {
				found=true;
			}			
		}
		return found;
	}

	@Override
	public int getDistanceOfBases(Base b1, Base b2) {
		int x1, x2, y1, y2, over;	
		x1= b1.getLatitude(); y1= b1.getLongitude(); x2= b2.getLatitude(); y2= b2.getLongitude();
		over = calculateDistance(x1, y1, x2, y2);
		return over;
	}

	@Override
	public DroneIterator listFly() {
		return new DroneIteratorClass(fly, countFly);
	}

	@Override
	public int getFlyCount() {
		return countFly;
	}

	@Override
	public void addToFly(Drone d) {
		fly[countFly++]=d;
		
	}

	@Override
	public void auxFinishFlying() {
		
		for(int i = 0; i<countFly;i++) {
			Drone d = fly[i];
			int flying = d.getFlying();
			Mission m = d.getMission();
			String targetBase = m.getTBase();
			int distance = m.getDistance();
			if(flying>=distance) {
				removeDroneFromFlying(d);
				Base b = objectifyBase(targetBase);
				d.setRange();
				if(!existDroneOnHangar(b, d))
					addDrone(targetBase, d);
				i--;
				if(m instanceof Delivery){
					Order o = d.getOrder();
					addOrderToDelivered(o);
					int x = getTime();
					o.setTime(x);
				}
			}
		}
	}

	@Override
	public void removeDroneFromFlying(Drone d) {
			String name = d.getId();
			int index = searchIndexFly(name);	
			for(int i = index; i<countFly-1; i++) {
				fly[i]=fly[i+1];
			}
			countFly--;
	}

	@Override
	public int searchIndexFly(String drone) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<countFly && !found)
			if (fly[i].getId().equals(drone))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	@Override
	public OrderIterator listDelivered() {
		return new OrderIteratorClass(delivered, countDelivered);
	}

	@Override
	public int getCountDelivered() {
		return countDelivered;
	}

	@Override
	public int calculateDistance(int x1, int y1, int x2, int y2) {
		int sumx, sumy, sumt, over;
		float total;
		if(x1<0)
			x1*=(-1);
		if(x2<0)
			x2*=(-1);
		if(y1<0)
			y1*=(-1);
		if(y2<0)
			y2*=(-1);
		
		sumx=x1-x2;
		sumy=y1-y2;
		
		if(sumx<0)
			sumx*=(-1);
		if(sumy<0)
			sumy*=(-1);
		
		sumx=sumx*sumx;
		sumy=sumy*sumy;
		sumt=sumx+sumy;
		total=(float) Math.sqrt(sumt);
		over=(int) Math.ceil(total);
		return over;
	}

	@Override
	public Order objectifyOrder(String order) {
		Order o = orders[searchIndexOrder(order)];
		return o;
	}

	@Override
	public void addOrderToDelivered(Order o) {
		delivered[countDelivered++]=o;
		
	}

	@Override
	public void addTime() {
		time++;
		
	}

	@Override
	public int getTime() {
		return time;
		
	}

	@Override
	public void removeDroneFromAll(Drone[] drones, int inicialDrones) {
		for(int i=0; i<inicialDrones; i++) {
			Drone d = drones[i];
			removeDrone(d);	
		}
		
	}

	@Override
	public void removeDrone(Drone d) {
		String name = d.getId();
		int index = searchIndexDrone(name);	
		for(int i = index; i<countDrones-1; i++) {
			drones[i]=drones[i+1];
		}
		countDrones--;
		
	}
}


