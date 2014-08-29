package in.k2s.core.bundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class K2Bundle {
	
	private static final String FILE = "project";
	
	private static ResourceBundle rb;
	private static Map<String, String> databaseBundle = new HashMap<String, String>();
	
	private K2Bundle() {};
	
	public static String getParam(String param) {
		if(rb == null) {
			rb = ResourceBundle.getBundle(FILE);
			loadDatabaseBundle();
			if(rb != null) {
				System.out.println("INFO: "+FILE+".properties iniciado");
			} else {
				System.out.println("ERROR: "+FILE+".properties nao foi encontrado");
			}
		}
		String value = databaseBundle.get(param);
		if(value == null) value = rb.getString(param);
		return value;
	}
	
	private static void loadDatabaseBundle() {
		if(K2Bundle.getBoolean("bundle.db.active")) {
			try {
				InitialContext cxt = new InitialContext();
				DataSource ds = (DataSource) cxt.lookup( "java:jboss/datasources/" + K2Bundle.getParam("bundle.db.ds"));
				Connection conn = ds.getConnection();
				String QUERY = String.format("SELECT %s, %s FROM %s", K2Bundle.getParam("bundle.db.table.column.key"), K2Bundle.getParam("bundle.db.table.column.value"), K2Bundle.getParam("bundle.db.table"));
				ResultSet rs = conn.prepareStatement(QUERY).executeQuery();
				while(rs.next()) {
					databaseBundle.put(rs.getString(K2Bundle.getParam("bundle.db.table.column.key")), rs.getString(K2Bundle.getParam("bundle.db.table.column.value")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Double getDouble(String param) {
		String value = K2Bundle.getParam(param);
		return new Double(value);
	}
	
	public static Integer getInteger(String param) {
		String value = K2Bundle.getParam(param);
		return new Integer(value);
	}
	
	public static Long getLong(String param) {
		String value = K2Bundle.getParam(param);
		return new Long(value);
	}
	
	public static Boolean getBoolean(String param) {
		String value = K2Bundle.getParam(param);
		return new Boolean(value);
	}
	
	public static String[] getArray(String param) {
		return K2Bundle.getArray(param, ",");
	}
	
	public static String[] getArray(String param, String separator) {
		String value = K2Bundle.getParam(param);
		return value.split(separator);
	}

}
