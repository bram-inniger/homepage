package be.inniger.homepage.web.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class TmpResponse<K, V> {

	private final K key;
	private final V value;
}
