package Orders;

public interface Order {
/**
 * metodo que retorna o nome da encomenda
 * @return nome da encomenda
 */
String getOrderId();
/**
 * metodo que retorna o nome da base em que se encontra a encomenda
 * @return nome da base em que a encomenda se encontra
 */
String getBaseId();
/**
 * retorna a dimensao da encomenda
 * @return dimensao da encomenda
 */
int getDimension();
/**
 * metodo que retorna a latitude do destino da encomenda
 * @return latitude do destino
 */
int getLatitude();
/**
 * metodo que retorna a longitude do destino da encomenda
 * @return longitude do destino
 */
int getLongitude();
void setTime(int x);
int getTime();
}
