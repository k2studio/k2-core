package in.k2s.core.interfaces;

import java.io.Serializable;

import com.google.gson.Gson;

public interface Bean extends Serializable {
	
	@SuppressWarnings("unchecked")
	public static <T extends Bean> T deserialize(Class<? extends Bean> bean, String json) {
		return (T) new Gson().fromJson(json, bean);
	}
	
	public String json();
	
	public String json(boolean indent);
	
	public String jsonOnlyExposed();
	
	public String jsonOnlyExposed(boolean indent);

}
