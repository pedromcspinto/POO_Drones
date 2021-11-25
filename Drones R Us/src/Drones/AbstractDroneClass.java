package Drones;
import Mission.*;

public abstract class AbstractDroneClass implements Drone{
	
	String id;
	String baseId;
	int carryCapacity;
	int range;
	Mission[]mission;
	int countMission;
	int flying;
	private static final int MAX =1;

	public AbstractDroneClass(String id, String baseId, int carryCapacity, int range) {
		this.id=id;
		this.baseId=baseId;
		this.carryCapacity=carryCapacity;
		this.range=range;	
		mission= new Mission[MAX];
		countMission=0;
		flying=0;
	}

	@Override
	public abstract String getId();
	@Override
	public abstract String getBaseId();
	@Override
	public abstract int getCarry();
	@Override
	public abstract int getRange();
	@Override	
	public abstract String toString();
}
