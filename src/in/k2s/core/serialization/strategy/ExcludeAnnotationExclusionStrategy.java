package in.k2s.core.serialization.strategy;

import in.k2s.core.serialization.Exclude;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ExcludeAnnotationExclusionStrategy implements ExclusionStrategy {

	public ExcludeAnnotationExclusionStrategy() {
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(Exclude.class) == null ? false : true;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

}
