import java.util.Scanner;
import Application.*;
import Bases.*;
import Drones.*;
import Iterators.*;
import Mission.*;
import Orders.*;


/**
 * @author Pedro Pinto
 *
 */
/**
 * @author Pedro Pinto
 *
 */
/**
 * @author Pedro Pinto
 *
 */
/**
 * @author Pedro Pinto
 *
 */
public class Main {

	// Comandos do programa
	private enum Command {	
		help, exit, base, listbases, drone, service, swarm, swarmcomponents, disband, listdrones, flytobase,
		addorder, orders, allorders, deliver, delivered, intransit, tictac, desconhecido
	};
	private static final String HELP =
			"base - registers a new distribution base\r\n" + 
					"listBases - lists existing distribution bases\r\n" + 
					"drone - registers a new drone in a starting base\r\n" + 
					"service - service all grounded drones requiring service in a base\r\n" + 
					"swarm - creates a new swarm from free drones in a base\r\n" + 
					"swarmComponents - lists the drones within a swarm\r\n" + 
					"disband - disbands the whole swarm\r\n" + 
					"listDrones - lists all existing drones (and swarms)\r\n" + 
					"flyToBase - fly a drone (or swarm) to a base\r\n" + 
					"addOrder - add a new order to a base\r\n" + 
					"orders - lists all pending orders from a base\r\n" + 
					"allOrders - lists all pending orders from all bases\r\n" + 
					"deliver - deliver a package to a customer\r\n" + 
					"delivered - lists all delivered orders\r\n" + 
					"inTransit - lists all drones (and swarms) currently flying\r\n" + 
					"ticTac - advances the simulation clock n timestamps\r\n" + 
					"help - shows the available commands\r\n" + 
					"exit - terminates the execution of the program" ;			
	private static final String DEFAULT = "Unknown command. Type help to see available commands.";
	private static final String BYE = "Bye!";
	private static final String DOT = ".";
	private static final String SPACE = " ";
	private static final String EXCLAMATION = "!";
	private static final String PARENTISIS_RETOS_E = "[";
	private static final String PARENTISIS_RETOS_D = "]";
	private static final String COMA = ",";
	private static final String TWO_DOTS = ":";
	private static final String BASE = "Base";
	private static final String CREATED_AT = "created at";
	private static final String NO_BASES = "There are no bases";
	private static final String EMPTY_HANGAR = "The hangar is empty";
	private static final String EMPTY_BAY = "The service bay is empty";
	private static final String EXISTS_BASE_AT = "There is already another base at";
	private static final String EXISTS_BASE = "Base already exists";
	private static final String DRONE = "Drone";
	private static final String CREATED = "created";
	private static final String HANGAR = "Hangar";	
	private static final String INVALID_RANGE = "Invalid range for a new drone";
	private static final String INVALID_CAPACITY = "Capacity has to be a positive integer";
	private static final String INVALID_DIMENSION = "dimension must be a positive integer";
	private static final String ALREADY_EXIST = "already exists";
	private static final String NOT_EXIST = "does not exist";
	private static final String INVALID_TYPE = "Invalid drone type!";
	private static final String SOCIABLE = "sociable";
	private static final String HERMIT = "hermit";
	private static final String NO_DRONES = "There are no drones";
	private static final String QUEUED = "Order queued for delivery";
	private static final String ORDER = "Order";
	private static final String ALREADY_REGISTED = "already registed";
	private static final String SOURCE = "Source";
	private static final String NO_ORDERS = "There are no pending orders";
	private static final String NO_PENDING= "There are no pending orders in";
	private static final String ORDERS_IN = "Orders in";
	private static final String AT_LEAST_TWO = "Swarm must have at least two drones";
	private static final String CANNOT_ADD = "Cannot add";
	private static final String TWICE = "twice";
	private static final String NOT_AVAILABLE_ON_BASE = "is not available in this base";
	private static final String SWARM = "Swarm";
	private static final String SWARM_LOWER = "swarm";
	private static final String IS_NOT_A ="is not a";
	private static final String DISBANDED = "disbanded";
	private static final String IS_NOT_AT = "is not at";
	private static final String NO_DRONES_SENT = "No drones were sent to the service station";
	private static final String FLYING_FROM = "flying from";
	private static final String TO = "to";
	private static final String RELOCATION ="relocation";
	private static final String DELIVERY = "delivery";
	private static final String TARGET = "Target";
	private static final String NO_DRONES_FLYING = "No drones are flying";
	private static final String BASE_LOW = "base";
	private static final String MOVED_TO_BAY = "moved to service bay";
	private static final String SERVICE_BAY = "Service bay";
	private static final String NO_DELIVERED_ORDERS = "No orders delivered so far";
	private static final String IS_NOT_PENDING = "is not pending";
	private static final String IS_TO_FAR_FOR = "is too far for";
	private static final String IS_TO_HEAVY_FOR = "is too heavy for";
	private static final String WILL_DELIVER = "will deliver";


	/**
	 * linha de comandos
	 * @param args
	 */
	public static void main(String[] args) {
		Store s = new StoreClass();
		Scanner in = new Scanner(System.in);
		Command comm = getCommand(in);

		while (!comm.equals(Command.exit)){
			switch (comm) {
			case base: 
				createBase(in, s);
				break;
			case listbases:
				listBases(s);
				break;
			case drone:
				createDrone(in, s);
				break;
			case service: 
				service(in, s);
				break;
			case swarm:
				createSwarm(in , s);
				break;
			case swarmcomponents:
				listSwarms(in, s);
				break;
			case disband:
				disbandSwarm(in, s);
				break;
			case listdrones:
				listDrones(s);
				break;
			case flytobase:
				flyToBase(in, s);
				break;
			case addorder:
				createOrders(in, s);
				break;
			case orders:
				listOrders(in, s);
				break;
			case allorders:
				listAllOrders(s);
				break;
			case deliver:
				deliverOrder(in ,s);
				break;
			case delivered:
				deliveredOrders(s);
				break;
			case intransit:
				inTransit(in ,s);
				break;
			case tictac:
				titTac(in, s);
				break;
			case help:
				System.out.println(HELP);
				break;				
			case desconhecido:
				System.out.println(DEFAULT);
			default:
				break;
			}
			comm = getCommand(in);
		}
		System.out.println(BYE);
		in.close();
	}


	/**
	 * comando deliver, coloca em marcha uma entrega
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void deliverOrder(Scanner in, Store s) {
		String baseId = in.nextLine();
		String droneId = in.nextLine();
		String orderId = in.nextLine();
		int x1, y1, x2, y2, sum;

		if(!s.existsBase(baseId)) {
			System.out.println(BASE+SPACE+baseId+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		if(!s.existsDrone(droneId)) {
			System.out.println(droneId+SPACE+IS_NOT_AT+SPACE+baseId+EXCLAMATION);
			return;
		}
		Base b = s.objectifyBase(baseId);
		Drone d = s.objectifyDrone(droneId);
		if(!s.existDroneOnHangar(b, d)) {
			System.out.println(droneId+SPACE+IS_NOT_AT+SPACE+baseId+EXCLAMATION);
			return;
		}
		Order o = s.objectifyOrder(orderId);
		if(b.existOrder(o)==false) {
			System.out.println(orderId+SPACE+IS_NOT_PENDING+EXCLAMATION);
			return;
		}
		x1 = b.getLatitude();
		y1 = b.getLongitude();
		x2 = o.getLatitude();
		y2 = o.getLongitude();
		sum = s.calculateDistance(x1, y1, x2, y2);
		sum+=sum;
		if(d.getRange()<sum) {
			System.out.println(orderId+SPACE+IS_TO_FAR_FOR+SPACE+droneId+EXCLAMATION);
			return;
		}
		if(d.getCarry()<o.getDimension()) {
			System.out.println(orderId+SPACE+IS_TO_HEAVY_FOR+SPACE+droneId+EXCLAMATION);
			return;
		}
		b.removeOrder(o);
		b.removeDrone(d);
		s.addToFly(d);
		Mission m = new DeliveryClass(baseId, baseId, sum);
		d.addMission(m);
		d.addOrder(o);
		System.out.println(droneId+SPACE+WILL_DELIVER+SPACE+orderId+DOT);	
	}

	/**
	 * comando delivered, lista encomendas entregues
	 * @param s classe topo
	 */
	private static void deliveredOrders(Store s) {
		if(s.getCountDelivered()==0) {
			System.out.println(NO_DELIVERED_ORDERS+EXCLAMATION);
			return;
		}
		OrderIterator it = s.listDelivered();
		while(it.hasNext()) {
			Order o = it.next();
			System.out.println(o.getTime()+SPACE+o.getOrderId()+SPACE+o.getBaseId());

		}

	}
	
	/**
	 * comando service, coloca drones na area de servico
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void service(Scanner in, Store s) {
		String baseId=in.nextLine();
		int treshold=in.nextInt();in.nextLine();

		if(!s.existsBase(baseId)) {
			System.out.println(BASE+SPACE+baseId+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		Base b = s.objectifyBase(baseId);
		if(s.checkForThreshold(b, treshold)==false) {
			System.out.println(NO_DRONES_SENT+EXCLAMATION);
			return;
		}

		DroneIterator it = b.listHangar();
		while(it.hasNext()) {
			Drone d = it.next();
			if(d.getRange()<treshold) {
				b.sendDronesToService(d);
				String name = d.getId();
				System.out.println(name+SPACE+MOVED_TO_BAY+DOT);
			}		
		}
		b.removeToBay();
	}

	/**
	 * comando tictac, avanca o tempo da simulacao
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void titTac(Scanner in, Store s) {
		int time = in.nextInt();in.nextLine();
		for(int i = 0; i<time; i++) {
			DroneIterator it = s.listFly();
			while(it.hasNext()) {
				Drone d = it.next();
				d.tick();
				s.addTime();
			}	

			s.auxFinishFlying();

		}	
	}	

	/**
	 * comando intransit, lista drones a voar
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void inTransit(Scanner in, Store s) {
		DroneIterator it = s.listFly();
		if(!it.hasNext()) {
			System.out.println(NO_DRONES_FLYING+EXCLAMATION);
			return;
		}
		while(it.hasNext()) {
			Drone d = it.next();
			if(d.getMissionCount()>0) {
				Mission m = d.getMission();
				if(m instanceof Relocation)
					System.out.println(d.getId()+SPACE+m.getOBase()+SPACE+m.getTBase()+SPACE+d.getFlying()+SPACE+m.getDistance()+SPACE+RELOCATION+EXCLAMATION);
				else
					System.out.println(d.getId()+SPACE+m.getOBase()+SPACE+m.getTBase()+SPACE+d.getFlying()+SPACE+m.getDistance()+SPACE+DELIVERY+EXCLAMATION);
			}
		}	
	}

	/**
	 * comando flytobase, envia um drone de uma base para outra
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void flyToBase(Scanner in, Store s) {
		String originBase=in.nextLine();
		String droneId=in.nextLine();
		String targetBase=in.nextLine();

		if(!s.existsBase(originBase)) {
			System.out.println(SOURCE+SPACE+BASE_LOW+SPACE+originBase+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		if(!s.existsBase(targetBase)) {
			System.out.println(TARGET+SPACE+BASE_LOW+SPACE+targetBase+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		Base ob = s.objectifyBase(originBase);
		Base tb = s.objectifyBase(targetBase);
		Drone d = s.objectifyDrone(droneId);
		if(!s.existDroneOnHangar(ob, d)) {
			System.out.println(droneId+SPACE+IS_NOT_AT+SPACE+originBase+EXCLAMATION);
			return;		
		}
		int dist = s.getDistanceOfBases(ob, tb);
		Mission m = new RelocationClass(originBase, targetBase, dist);
		d.addMission(m);
		ob.removeDrone(d);
		s.addToFly(d);
		System.out.println(droneId+SPACE+FLYING_FROM+SPACE+originBase+SPACE+TO+SPACE+targetBase+DOT);


	}



	/**
	 * comando disband, elimina um swarm deixando para tras os seus componentes
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void disbandSwarm(Scanner in, Store s) {
		String baseId = in.nextLine();
		String SwarmId = in.nextLine();

		if(!s.existsBase(baseId)) {
			System.out.println(BASE+SPACE+baseId+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		Base b = s.objectifyBase(baseId);
		Drone d = s.objectifyDrone(SwarmId);
		if(!s.existDroneOnBase(b, d)) {
			System.out.println(DRONE+SPACE+SwarmId+SPACE+NOT_AVAILABLE_ON_BASE+EXCLAMATION);
			return;		
		}
		b.disbandSwarm(d);
		System.out.println(SwarmId+SPACE+DISBANDED+DOT);
	}



	/**
	 * comando swarmcomponents, lista os componentes de um swarm
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void listSwarms(Scanner in, Store s) {
		String SwarmId = in.nextLine();
		if(!s.existsDrone(SwarmId)) {
			System.out.println(SwarmId+SPACE+IS_NOT_A+SPACE+SWARM_LOWER+EXCLAMATION);
			return;
		}
		Drone d = s.objectifyDrone(SwarmId);
		if(s.checkForSwarm(d)==false) {
			String name = d.getId();
			System.out.println(name+SPACE+IS_NOT_A+SPACE+SWARM_LOWER+EXCLAMATION);
			return;
		}
		DroneIterator it = ((Swarm)d).listSwarm();
		while(it.hasNext()) {
			Drone drone = it.next();
			if(s.checkForSwarm(drone)==true) {
				DroneIterator it2 = ((Swarm)drone).listSwarm();
				while(it2.hasNext()) {
					Drone drone2 = it2.next();
					System.out.println(drone2.getId());
				}
			}else {
				System.out.println(drone.getId());
			}
		}
		System.out.println(d.getCarry()+SPACE+d.getRange());
	}



	/**
	 * comando swarm, cria um swarm/ um grupo de drones
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void createSwarm(Scanner in, Store s) {
		String baseId = in.nextLine();
		String swarmId = in.nextLine();
		int inicialDrones= in.nextInt(); in.nextLine();

		Drone[]drones;
		drones = new Drone[inicialDrones];
		int c=0;
		int r=0;
		for(int i=0; i<inicialDrones; i++) {
			String drone = in.nextLine();	
			Drone d = s.objectifyDrone(drone);
			c+=d.getCarry();
			drones[i]=d;

		}
		if(!s.existsBase(baseId)) {
			System.out.println(BASE+SPACE+baseId+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		} 
		if(inicialDrones<2) {
			System.out.println(AT_LEAST_TWO+EXCLAMATION);
			return;
		}
		Base objBase = s.objectifyBase(baseId);
		int check = s.checkForEquals(drones, inicialDrones);
		if(check>0) {
			String droneName = drones[check].getId();
			System.out.println(CANNOT_ADD+SPACE+DRONE+SPACE+droneName+SPACE+TWICE+EXCLAMATION);
			return;
		}
		int kind = s.checkForKind(drones, inicialDrones);
		if(kind!=0) {
			String droneName = drones[kind].getId();
			System.out.println(CANNOT_ADD+SPACE+HERMIT+SPACE+DRONE+SPACE+droneName+EXCLAMATION);
			return;
		}
		int exist = s.auxExistDroneOnBase(drones, objBase, inicialDrones);
		if(exist>0) {
			String name = drones[exist].getId();
			System.out.println(DRONE+SPACE+name+SPACE+NOT_AVAILABLE_ON_BASE+EXCLAMATION);
			return;
		}
		if(s.existsDrone(swarmId)) {
			System.out.println(SWARM+SPACE+swarmId+SPACE+ALREADY_EXIST+EXCLAMATION);
			return;
		}
		r=s.auxMinimumRange(drones, inicialDrones);
		Drone d = new SwarmClass(swarmId, baseId, inicialDrones, c, r, drones);
		s.addDrone(baseId, d);
		s.auxRemoveDrones(drones, inicialDrones, objBase);
		s.removeDroneFromAll(drones, inicialDrones);
		System.out.println(swarmId+SPACE+CREATED+DOT);
	}



	/**
	 * comando allorders, lista todas as encomendas em espera
	 * @param s scanner
	 */
	private static void listAllOrders(Store s) {

		if(s.getOrderCount()==0) {
			System.out.println(NO_PENDING+EXCLAMATION);
			return;
		}

		BaseIterator it = s.listBases();
		while(it.hasNext()) {
			Base b = it.next();
			OrderIterator Oit = s.listOrders(b.getBaseName());
			if(!Oit.hasNext()) {System.out.println(NO_PENDING+SPACE+b.getBaseName()+DOT);}
			else{			
				System.out.println(ORDERS_IN+SPACE+b.getBaseName()+TWO_DOTS);
				while(Oit.hasNext()) {
					Order o = Oit.next();
					System.out.println(o.toString());
				}
			}
		}
	}



	/**
	 * comando orders, lista todas as encomendas de uma base
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void listOrders(Scanner in, Store s) {
		String base = in.nextLine().trim();

		if(!s.existsBase(base)) {
			System.out.println(BASE+SPACE+base+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		if(s.objectifyBase(base).getOrderCount()==0) {
			System.out.println(NO_ORDERS+EXCLAMATION);
			return;
		}
		OrderIterator it = s.listOrders(base);
		while(it.hasNext()){
			Order o = it.next();
			System.out.println(o.toString());

		}
	}



	/**
	 * comando orders, cria uma encomenda
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void createOrders(Scanner in, Store s) {
		String base = in.nextLine();
		String orderId = in.nextLine();
		int dimension = in.nextInt();
		int latitude = in.nextInt();
		int longitude = in.nextInt();
		in.nextLine();

		if(!s.existsBase(base)) {
			System.out.println(SOURCE+SPACE+base+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		if(s.existOrder(orderId)) {
			System.out.println(ORDER+SPACE+orderId+SPACE+ALREADY_REGISTED+EXCLAMATION);
			return;
		}
		if(dimension<0) {
			System.out.println(ORDER+SPACE+INVALID_DIMENSION+EXCLAMATION);
			return;
		}
		Order o = new OrderClass(base, orderId, dimension, latitude, longitude);
		s.createOrder(base, o);
		System.out.println(QUEUED+DOT);
	}

	/**
	 * comando listdrones, lista todsos os drones
	 * @param s scanner
	 */
	private static void listDrones(Store s) {
		if(s.getCountDrones()==0) {
			System.out.println(NO_DRONES+EXCLAMATION);
			return;
		}
		DroneIterator it = s.listDrones();
		while(it.hasNext()) {
			Drone d = it.next();
			System.out.println(d.getId());		
		}
	}

	/**
	 * comando drone, cria um drone
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void createDrone(Scanner in, Store s) {
		String id = in.nextLine();
		String baseId = in.nextLine();
		String kind = in.next().trim();
		int carryCapacity = in.nextInt();
		int range = in.nextInt(); in.nextLine();

		if(range<10) {
			System.out.println(INVALID_RANGE+EXCLAMATION);
			return;
		}
		if(carryCapacity<0) {
			System.out.println(INVALID_CAPACITY+EXCLAMATION);
			return;
		}
		if(!s.existsBase(baseId)) {
			System.out.println(BASE+SPACE+baseId+SPACE+NOT_EXIST+EXCLAMATION);
			return;
		}
		if(s.existsDrone(id)) {
			System.out.println(DRONE+SPACE+id+SPACE+ALREADY_EXIST+EXCLAMATION);
			return;
		}
		if(!kind.equals(HERMIT) && !kind.equals(SOCIABLE)) {
			System.out.println(INVALID_TYPE);
			return;
		}
		if(kind.equals(HERMIT)) {
			Drone d = new HermitDroneClass(id, baseId, kind, carryCapacity, range);
			s.addDrone(baseId,d);
		}
		else {
			Drone d = new SociableDroneClass(id, baseId, kind, carryCapacity, range);
			s.addDrone(baseId,d);
		}
		System.out.println(DRONE+SPACE+id+SPACE+CREATED+DOT);

	}

	/**
	 * comando listbases, lista todas as bases
	 * @param s scanner
	 */
	private static void listBases(Store s) {
		if(s.getCountBases()==0) {System.out.println(NO_BASES+EXCLAMATION);}
		else {
			BaseIterator it = s.listBases();
			it.initializeIterator();
			while(it.hasNext()) {
				Base b = it.next();
				System.out.println(b.toString());
				if(b.getDronesCount()==0) {
					System.out.println(EMPTY_HANGAR+EXCLAMATION);
					System.out.println(EMPTY_BAY+EXCLAMATION);
				}else {
					if(b.getHangarCount()!=0) {
						DroneIterator Dit = b.listHangar();
						System.out.print(HANGAR+TWO_DOTS+SPACE+PARENTISIS_RETOS_E);
						while(Dit.hasNext()) {
							Drone d = Dit.next();
							if(!Dit.hasNext()) {System.out.print(d.toString());}
							else {
								System.out.print(d.toString()+COMA+SPACE);
							}
						}	
						System.out.println(PARENTISIS_RETOS_D);			
					}else {System.out.println(EMPTY_HANGAR+EXCLAMATION);}
					if(b.getBayCount()!=0) {
						DroneIterator itD = b.listBay();
						System.out.print(SERVICE_BAY+TWO_DOTS+SPACE+PARENTISIS_RETOS_E);
						while(itD.hasNext()) {
							Drone D = itD.next();
							if(!itD.hasNext()) {System.out.print(D.toString());}
							else {
								System.out.print(D.toString()+COMA+SPACE);
							}
						}
						System.out.println(PARENTISIS_RETOS_D);
					}else {System.out.println(EMPTY_BAY+EXCLAMATION);}
				}
			}		
		}
	}

	/**
	 * comando base, cria uma base
	 * @param in scanner
	 * @param s classe topo
	 */
	private static void createBase(Scanner in, Store s) {

		int latitude = in.nextInt();
		int longitude = in.nextInt();
		String base = in.nextLine().trim();
		if(s.existsBase(base)) {System.out.println(EXISTS_BASE+EXCLAMATION);}
		else if(s.getCountBases()!=0 && s.compareCordinates(latitude, longitude)){System.out.println(EXISTS_BASE_AT
				+SPACE+PARENTISIS_RETOS_E+latitude+COMA+longitude+PARENTISIS_RETOS_D+EXCLAMATION);}
		else {
			Base b = new BaseClass(base, latitude, longitude);
			s.createBase(b);
			System.out.println(BASE+SPACE+base+SPACE+CREATED_AT+SPACE+PARENTISIS_RETOS_E+latitude+COMA+longitude
					+PARENTISIS_RETOS_D+DOT);
		}

	}

	private static Command getCommand(Scanner in) {
		System.out.print("> ");
		String comm = in.nextLine().toLowerCase();
		if (!belongsToCommand(comm)) {
			return Command.desconhecido;
		} else {
			return Command.valueOf(comm);
		}
	}


	private static boolean belongsToCommand(String comm) {
		for (Command c : Command.values()) {
			if (c.name().equals(comm)) {
				return true;
			}
		}
		return false;
	}
}
