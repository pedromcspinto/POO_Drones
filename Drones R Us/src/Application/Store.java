package Application;

import Bases.*;
import Drones.*;
import Iterators.*;
import Orders.*;

/**
 * @author Pedro Pinto
 *
 */
public interface Store {
	/**
	 * metodo que cria uma base e guarda num array de bases
	 * @param b base a ser adicionada
	 */
	void createBase(Base b);
	/**
	 * metodo que verifica de existe uma base no sistema
	 * @param base base a ser procura
	 * @return </code>true</code> caso exista </code>false</code> caso nao exista
	 */
	boolean existsBase(String base);
	/**
	 * metodo que retorna a contagem de bases no sistema
	 * @return numero de bases que existem no sistema
	 */
	int getCountBases();
	/**
	 * metodo que lista os drones do hangar numa base, metodo que podia ser feito com interface Base
	 * @param base nome da base a ser procurada
	 * @return classe iteradora que lista o hangar de uma base
	 */
	DroneIterator listHangar(String base);
	/**
	 * metodo que lista os drone na area de servico de uma base , metodo que podia ser feito com uma interface base
	 * @param base nome da base a ser procurada
	 * @return classe iteradora do tipo DroneIterator
	 */
	DroneIterator listBay(String base);
	/**
	 * metodo que lista as bases do sistema
	 * @return classe iteradora do tipo BaseIterator 
	 */
	BaseIterator listBases();
	/**
	 * procura o indice de uma base no sistema
	 * @param base base a ser procurada
	 * @return indice da base procurada ou -1 caso nao exista
	 */
	int searchIndexBase(String base);
	/**
	 * metodo que remove um drone de uma base, metodo que pode ser feito usado apenas a interface Base 
	 * para realizar o processo
	 * @param b objeto do tipo Base a ser retirado o objeto do tipo Drone
	 * @param d objeto do tipo Drone a ser retirado
	 */
	void removeDroneFromBase(Base b, Drone d);
	/**
	 * metodo que verifica se um drone existe numa base, metodo que poderia ser feito usando apenas a interface base
	 * @param b objeto do tipo base a quem ira ser verificado se existe o objeto do tipo drone
	 * @param d objeto do tipo drone a verificar se existe
	 * @return </code>true</code> se existe ou </code>false</code> se nao existe
	 */
	boolean existDroneOnBase(Base b, Drone d);
	/**
	 * metodo que pode ser feito usado a interface base, que adiciona um drone numa base
	 * @param base nome da base a ser adicionado o drone
	 * @param d objeto do tipo drone a ser adicionado na base
	 */
	void addDrone(String base, Drone d);
	/**
	 * metodo inutil
	 * @param drone
	 * @return
	 */
	boolean existsDrone(String drone);
	/**
	 * metodo que retorna a contagem de drones no sistema
	 * @return contagem de drones no sistema
	 */
	int getCountDrones();
	/**
	 * metodo que lista drones do sistema
	 * @return classe iteradora do tipo DroneIterator
	 */
	DroneIterator listDrones();
	/**
	 * metodo que procura o indice de um drone
	 * @param drone drone a ser procurado o indice
	 * @return retorna o indice do drone procurado ou -1 caso nao exista
	 */
	int searchIndexDrone(String drone);
	/**
	 * metodo que cria uma ordem numa base, metodo que podia ter sido feito apenas usando a interface base
	 * @param base base a ser procurada
	 * @param d objeto do tipo Order a ser criado
	 */
	void createOrder(String base, Order d);
	/**
	 * metodo inutil
	 * @param order
	 * @return
	 */
	boolean existOrder(String order);
	/**
	 * metodo que retorna a contagem de encomendas no sistema
	 * @return contagem de encomendas no sistema
	 */
	int getOrderCount();
	/**
	 * metodo que lista encomendas de uma base que poderia receber uma interface Base
	 * @param base nome da base a listar as encomendas
	 * @return classe iteradora do tipo OrderIterator
	 */
	OrderIterator listOrders(String base);
	/**
	 * metodo que lista todas as encomendas do sistema 
	 * @return classe iteradora do tipo OrderIterator
	 */
	OrderIterator listAllOrders();
	/**
	 * metodo que devolve o indice de uma encomenda no sistema
	 * @param order encomenda a ser procurada
	 * @return indice da encomenda ou -1 se nao existir
	 */
	int searchIndexOrder(String order);
	/**
	 * metodo que devolve o objeto base atraves do nome da base, tem de garantir que existe para ser realizado
	 * @param base nome da base a ser devolvida
	 * @return objeto base 
	 */
	Base objectifyBase(String base);
	/**
	 * metodo que devolve o objeto Drone atraves do nome do drone, tem de garantir que existe para ser realizado
	 * @param drone nome do drone a ser devolvido
	 * @return objeto drone
	 */
	Drone objectifyDrone(String drone);
	/**
	 * metodo auxiliar que compara cordenadas para saber se pode ser criada uma base em certo sitio
	 * @param latitude latitude a ser comparada
	 * @param longitude longitude a ser comparada
	 * @return </code>true</code> se nao existe nenhuma base no mesmo sitio </code>false</code> caso contrario
	 */
	boolean compareCordinates(int latitude, int longitude);
	/**
	 * metodo auxiliar que verifica se existem varios drones com o mesmo nome a serem adicionados num swarm 
	 * @param drones array de objetos do tipo Drone a serem adicionados ao swarm
	 * @param inicialDrones contagem de drones a serem adicionados ao swarm que serve de contador
	 * para verificar 
	 * @return -1 se nao encontrar iguais ou o indice do drone replicado
	 */
	int checkForEquals(Drone[] drones, int inicialDrones);
	/**
	 * metodo auxiliar que verifica se estao a ser adicionado drones hermitas a um swarm
	 * @param drones array de objetos do tipo Drone
	 * @param inicialDrones contagem de drones a serem adicionados que funcionam como contador
	 * para a verificacao
	 * @return -1 se nao existir nenhum drone hermita ou o indice do primeiro drone hermita
	 */
	int checkForKind(Drone[]drones, int inicialDrones);
	/**
	 * metodo auxiliar que ajuda a remover os drones da base de forma a que fiquem so contidos no swarm
	 * @param drones array de objetos do tipo drone
	 * @param inicialDrones contagem de drones a serem adicionados no swarm que vai funcionar
	 * como contador para a eliminacao
	 * @param b objeto do tipo Base aos quais vao ser retirados os drones
	 */
	void auxRemoveDrones(Drone[]drones, int inicialDrones, Base b);
	/**
	 * metodo que poderia nao ter sido feito
	 * @param drones
	 * @param b
	 * @param inicialDrones
	 * @return
	 */
	int auxExistDroneOnBase(Drone[]drones, Base b, int inicialDrones);
	/**
	 * metodo auxiliar que verifica qual o menor range para ser adicionado ao swarm  apos ser verificado se existem na base
	 * @param drones array de objetos do tipo drone que vao comparar ranges entre si
	 * @param inicialDrones contagem de drones a serem adiconados no swarm que funciona como contador
	 * para percorrer o array
	 * @return o range minimo de todos os objetos do tipo Drone
	 */
	int auxMinimumRange(Drone[]drones, int inicialDrones);
	/**
	 * metodo auxiliar que ajuda a verificar se os drones a serem adicionados em um swarm existem no hangar de uma base
	 * recebendo um array de objetos do tipo Drone, ao que foi adicionado os drones a serem adicionados no swarm
	 * @param drones array de drones a serem adicionados a um swarm
	 * @param b objeto do tipo Base onde se vai verificar se existem os drones no hangar
	 * @param inicialDrones numeros de drones a serem adicionados no swarm funciona como contador
	 * @return -1 caso todos existam ou retorna o indice do primeiro drone a ser verificado que nao pertence a base
	 */
	int auxExistDroneOnHangar(Drone[]drones, Base b, int inicialDrones);
	/**
	 * metodo que verifica a se existe um objeto Drone numa base
	 * @param b objeto Base
	 * @param d objteo Drone
	 * @return </code>true</code> se existe </code>false</code>
	 */
	boolean existDroneOnHangar(Base b, Drone d);
	/**
	 * metodo que verifica se o objeto Drone e do tipo Swarm
	 * @param d objeto drone a ser verificado
	 * @return </code>true</code> se for do tipo Swarm </code>false</code> caso contrario
	 */
	boolean checkForSwarm(Drone d);
	/**
	 * Metodo que procura se ha drones a ser postos na area de servico comparando o seu range ao treshold
	 * @param b objeto base a ser verificado quais drones podem servir
	 * @param treshold parametro que serve para comparar e escolher quais drones estao habilitados a fazer o trabalho
	 * @return </code>true</code> se existir </code>false</code> se nao existir nenhum
	 */
	boolean checkForThreshold(Base b, int treshold);
	/**
	 * metodo auxiliar que calcula a distancia entre dois objetos Base
	 * @param b1 objeto base 
	 * @param b2 objeto base
	 * @return distancia entre bases
	 */
	int getDistanceOfBases(Base b1, Base b2);
	/**
	 * metodo que lista drones a voar no sistema
	 * @return classe iteradora do tipo droneIterator
	 */
	DroneIterator listFly();
	/**
	 * metodo que devolve a contagem de drones a voar no sistema
	 * @return contagem de drones no sistema
	 */
	int getFlyCount();
	/**
	 * 
	 * @param d
	 */
	void addToFly(Drone d);
	/**
	 * metodo auxiliar que aterra drones e os volta a por no hangar e a terminar a missao destinada
	 */
	void auxFinishFlying();
	/**
	 * metodo que aterra um objeto drone
	 * @param d objeto drone a aterrar
	 */
	void removeDroneFromFlying(Drone d);
	/**
	 * metodo que retorna o indice de um drone que esteja a voar
	 * @param drone nome do drone que esta a voar
	 * @return o indice do drone ou -1 caso nao exista
	 */
	int searchIndexFly(String drone);
	/**
	 * metodo que lista encomendas entregues no sistema
	 * @return classe iteradora do tipo OrderIterator
	 */
	OrderIterator listDelivered();
	/**
	 * metodo que retorna a contagem de encomendas entregues
	 * @return contagem de encomendas entregues
	 */
	int getCountDelivered();
	/**
	 * metodo que calcula distancias entre bases ou entre bases e o destino de uma encomenda
	 * @param x1 latitude da base
	 * @param y1 longitude da base
	 * @param x2 latitude destino
	 * @param y2 latitude destino
	 * @return distancia a ser percorrida
	 */
	int calculateDistance(int x1, int y1, int x2, int y2);
	/**
	 * metodo que procura o objeto Order atraves do seu nome, tem de garantir que existe para ser realizado
	 * @param order
	 * @return
	 */
	Order objectifyOrder(String order);
	/**
	 * metodo inutil
	 * @param o
	 */
	void addOrderToDelivered(Order o);
	/**
	 * metodo inutil
	 */
	void addTime();
	/**
	 * metodo inutil
	 * @return
	 */
	int getTime();
	/**
	 * metodo inutil
	 * @param drones
	 * @param inicialDrones
	 */
	void removeDroneFromAll(Drone[]drones, int inicialDrones);
	/**
	 * metodo inutil
	 * @param d
	 */
	void removeDrone(Drone d);
}
