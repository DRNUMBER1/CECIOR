package recior.cecior.util.settings;

public class SettingPairS<K,V> {
	
	K key;
	V value;

	public SettingPairS(K key, V value){
		if(key !=null && value !=null) {
		this.key = key;
		this.value = value;
		} else {
			return;
		}
	}
	
	public SettingPairS(){
		
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
