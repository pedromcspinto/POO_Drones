package Bases;
import Drones.*;
import Iterators.*;
import Orders.*;

public interface Base {
	/**
	 * metodo que retorna o nome da base
	 * @return nome da base
	 */
	String getBaseName();
	/**
	 * metodo que retorna a latitude da base
	 * @return latitude da base
	 */
	int getLatitude();
	/**
	 * metodo que retorna a longitude da base
	 * @return longitude da base
	 */
	int getLongitude();	
	/**
	 * metodo que retorna a contagem de drones no hangar da base
	 * @return contagem de drones no hangar da base
	 */
	int getHangarCount();
	/**
	 * metodo que retorna a contagem de drones na area de servico
	 * @return contagem de drones na area de servico
	 */
	int getBayCount();
	/**
	 * metodo booleano que retorna </code>true</code> caso exista certo drone na base </code>false</code> caso contrario
	 * @param d objeto do tipo Drone 
	 * @return </code>true</code> ou </code>false</code>
	 */
	boolean existDrone(Drone d);
	/** metodo que remove um drone do hangar
	 * @param d objeto do tipo drone 
	 */
	void removeDrone(Drone d);
	/**
	 * metodo iterador que lista drones no hangar
	 * @return uma classe iteradora do tipo DroneIterator
	 */
	public DroneIterator listHangar();
	/**
	 * metodo iterador que lista drones na area de servico
	 * @return uma classe iteradora do tipo DroneIterador
	 */
	public DroneIterator listBay();
	/**
	 * metodo que adiciona um drone a base
	 * @param d objeto do tipo drone
	 */
	void addDrone(Drone d);
	/**
	 * metodo que retorna a contagem de drones na base
	 * @return contagem de drones na base
	 */
	int getDronesCount();	
	/**
	 * metodo que lista drones da base
	 * @return uma classe iteradora do tipo DroneIterator
	 */
	DroneIterator listDrones();	
	/**
	 * metodo que adiciona uma encomenda a base
	 * @param o objeto do tipo Order 
	 */
	void addOrder(Order o);
	/**
	 * metodo que lista encomendas numa base
	 * @return uma classe iteradora do tipo OrderIterator
	 */
	public OrderIterator listOrders();
	/**
	 * metodo que retorna a contagem de encomendas na base
	 * @return contagem de encomendas na base
	 */
	int getOrderCount();
	/**
	 * metodo que procura o indice de um drone na base
	 * @param drone nome do drone a procurar 
	 * @return indice do drone procurado
	 */
	int searchIndexDrone(String drone);
	/**
	 * metodo que  procura o indice de um drone no hangar
	 * @param drone nome do drone a procurar
	 * @return indice do drone a procurar ou -1 caso nao exista
	 */
	int searchIndexDroneOnHangar(String drone);
	/**
	 * metodo booleando que retorna </code>true</code> caso um drone exista no hangar
	 *  metodo que podia ter sido feito a receber uma interface, </code>flase</code> caso nao exista
	 * @param drone nome do drone a procurar
	 * @return </code>true</code> ou </code>false</code>
	 */
	boolean existDroneOnHangar(String drone);
	/**
	 * metodo que desmancha um grupo de drones/ swarm
	 * @param d objeto do tipo Drone que ira ser desmanchado
	 */
	void disbandSwarm(Drone d);
	/**
	 * metodo que coloca drones na area de servico da base
	 * @param d objeto do tipo Drone a ser colocado na area de servico
	 */
	void sendDronesToService(Drone d);
	/**
	 * metodo que remove drones do hangar para a area de servico
	 */
	void removeToBay();
	/**
	 * metodo que remove uma encomenda da base
	 * @param o objeto do tipo Order a ser removido
	 */
	void removeOrder(Order o);
	/**
	 * metodo que encontra o indice de uma encomenda na base
	 * @param Order nome da encomenda a ser procurada
	 * @return indice da encomenda procurada ou -1 caso nao exista
	 */
	int searchIndexOrder(String Order);
	/**
	 * metodo booleano que procura se existe uma encomenda na base que retorna </code>true</code>
	 * se existe e </code>false</code> caso contrario
	 * @param o objeto do tipo Order a ser procurado
	 * @return </code>true</code> ou </code>false</code>
	 */
	boolean existOrder(Order o);
}
