package Mission;

public abstract class MissionClass implements Mission {

	String originBase;
	String targetBase;
	int distance;
	
	public MissionClass(String originBase, String targetBase, int distance) {
		this.originBase=originBase;
		this.targetBase=targetBase;
		this.distance=distance;
		
	}
	
}
