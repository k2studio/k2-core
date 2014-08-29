package in.k2s.core.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import net.vidageek.mirror.dsl.Mirror;

public abstract class BaseLog {
	
	private String path;
	
	private final Mirror mirror = new Mirror();
	
	public BaseLog(String path) {
		this.path = path;
	}
	
	protected void write(String value) {
		try {
			// Create file
			FileWriter fstream = new FileWriter(path, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(value + "\n");
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	protected boolean excludeField(Field field, String[] excludes) {
		for(String exclude : excludes) {
			if(exclude.equals(field.getName())) return true;
		}
		return false;
	}
	
	protected boolean isPrimitiveType(Field field) {
		if (field.getType().equals(String.class))     return true;
		if (field.getType().equals(Integer.class))    return true;
		if (field.getType().equals(Timestamp.class))  return true;
		if (field.getType().equals(Double.class))     return true;
		if (field.getType().equals(Date.class))       return true;
		if (field.getType().equals(Long.class))       return true;
		if (field.getType().equals(BigDecimal.class)) return true;
		if (field.getType().isEnum()) return true;
		
		return false;
	}
	
	//TODO implementar formatacao
	protected String formatField(String value) {
		/*
		value = value.replace(";", "");
		value = value.replace("&", "");
		value = value.replace("%", "");
		value = value.replace("$", "");
		value = value.replace("#", "");
		value = value.replace("@", "");
		value = value.replace("!", "");
		value = value.replace("*", "");
		value = value.replace(":", "");
		value = value.replace("\"", "");
		value = value.replace("?", "");
		value = value.replace(">", "&gt;");
		value = value.replace("<", "&lt;");
		value = value.replace("", "");
		*/
		return value;
	}

	protected Mirror getMirror() {
		return mirror;
	}
}
