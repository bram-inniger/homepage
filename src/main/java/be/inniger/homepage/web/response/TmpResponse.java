package be.inniger.homepage.web.response;

public class TmpResponse<K, V> {

	private final K key;
	private final V value;

	private TmpResponse(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public static <K, V> TmpResponse<K, V> of(K key, V value) {
		return new TmpResponse<>(key, value);
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}
}
