package Mission;

public class DeliveryClass extends MissionClass implements Delivery{

	String originBase;
	String targetBase;
	int distance;
	
	public DeliveryClass(String originBase, String targetBase, int distance) {
		super(originBase, targetBase, distance);
		this.originBase=originBase;
		this.targetBase=targetBase;
		this.distance=distance;
	}

	@Override
	public String getOBase() {
		return originBase;
	}

	@Override
	public String getTBase() {
		return targetBase;
	}

	@Override
	public int getDistance() {
		return distance;
	}
}
