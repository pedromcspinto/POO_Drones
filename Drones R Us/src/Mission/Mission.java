package Mission;

public interface Mission {
	
/**
 * metodo que retorna a base de origem de uma missao
 * @return nome da base de origem
 */
abstract String getOBase();
/**
 * metodo que retorna a base em que a missao e destinada
 * @return nome da base destinataria
 */
abstract String getTBase();
/**
 * metodo que retorna a distancia a ser percorrida
 * @return  a distancia a percorrer
 */
abstract int getDistance();

}
