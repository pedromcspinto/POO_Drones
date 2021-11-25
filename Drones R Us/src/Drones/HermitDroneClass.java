package Drones;

import Mission.Mission;
import Orders.Order;

public class HermitDroneClass extends AbstractDroneClass implements HermitDrone{
	
	String kind;
	Mission[]mission;
	int countMission;
	int flying;
	Order o;
	int timer;
	private static final String SPACE = " ";
	private static final int MAX =2;
	
	public HermitDroneClass(String id, String baseId, String kind, int carryCapacity, int range) {
		super(id, baseId, carryCapacity, range);
		this.id=id;
		this.baseId=baseId;
		this.kind=kind;
		this.carryCapacity=carryCapacity;
		this.range=range;
		countMission=0;
		mission= new Mission[MAX];
		flying=0;
		o = null;
		timer=0;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public String getBaseId() {
		return baseId;
	}
	@Override
	public int getCarry() {
		return carryCapacity;
	}
	@Override
	public int getRange() {
		return range;
	}
	@Override
	public String getKind() {
		return kind;
	}
	@Override
	public String toString() {
		return getId()+SPACE+getCarry()+SPACE+getRange();
	}
	@Override
	public void addMission(Mission m) {
		mission[countMission++]=m;	
	}
	@Override
	public int getMissionCount() {
		return countMission;
	}
	@Override
	public Mission getMission() {
		Mission m = mission[0];
		return m;
	}
	@Override
	public int getFlying() {
		return flying;
	}
	@Override
	public void tick() {
		flying+=10;
	}
	@Override
	public void setRange() {
		Mission m = mission[0];
		int distance = m.getDistance();
		range-=distance;		
	}
	@Override
	public void addOrder(Order order) {
		o=order;
		
	}
	@Override
	public Order getOrder() {
		return o;
	}
}
