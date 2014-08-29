package in.k2s.core.bean;

import in.k2s.core.interfaces.Bean;
import in.k2s.core.serialization.strategy.ExcludeAnnotationExclusionStrategy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseBean implements Bean {

	private static final long serialVersionUID = 1L;

	public String json() {
		return new GsonBuilder().addSerializationExclusionStrategy(new ExcludeAnnotationExclusionStrategy()).create().toJson(this);
	}
	
	public String json(boolean indent) {
		if(indent) return new GsonBuilder().setPrettyPrinting().addSerializationExclusionStrategy(new ExcludeAnnotationExclusionStrategy()).create().toJson(this); 
		return new Gson().toJson(this);
	}
	
	public String jsonOnlyExposed() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this); 
	}
	
	public String jsonOnlyExposed(boolean indent) {
		if(indent) return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(this);
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this); 
	}
	
}