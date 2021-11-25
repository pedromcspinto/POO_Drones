package Orders;

public class OrderClass implements Order {
	private String baseId;
	private String orderId;
	private int dimension;
	private int latitude;
	private int longitude;
	private int time;
	private static final String SPACE = " ";
	private static final String P_RETOS_E = "[";
	private static final String P_RETOS_D = "]";
	private static final String COMA = ",";
	private static final String DOT_COMA = ";";
	
	public OrderClass(String baseId, String orderId, int dimension, int latitude, int longitude) {
		this.baseId=baseId;
		this.orderId=orderId;
		this.dimension=dimension;
		this.latitude=latitude;
		this.longitude=longitude;
		time=0;
	}

	@Override
	public String getOrderId() {
		return orderId;
	}
	@Override
	public String getBaseId() {
		return baseId;
	}
	@Override
	public int getDimension() {
		return dimension;
	}
	@Override
	public int getLatitude() {
		return latitude;
	}
	@Override
	public int getLongitude() {
		return longitude;
	}
	public String toString() {
		return getOrderId()+DOT_COMA+SPACE+getDimension()+DOT_COMA+SPACE+
				P_RETOS_E+getLatitude()+COMA+getLongitude()+P_RETOS_D;
	}

	@Override
	public void setTime(int x) {
		time=x;
		
	}

	@Override
	public int getTime() {
		return time;
	}
}
