package recior.cecior.util.settings;

/**
 *@param K Key
 *@param V value
 *
 * @author recior
 */
public class SettingPair<K,V> {
	
	K key;
	V value;

	public SettingPair(K key, V value){
		if(key !=null && value !=null) {
		this.key = key;
		this.value = value;
		} else {
			return;
		}
	}
	
	public SettingPair(){
		
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public void setKey(K K) {
		this.key = K;
	}
	
	public void setValue(V V) {
		this.value = V;
	}
	
}
