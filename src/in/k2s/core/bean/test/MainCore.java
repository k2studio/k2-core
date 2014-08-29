package in.k2s.core.bean.test;

import in.k2s.core.bundle.K2Bundle;
import in.k2s.core.interfaces.Bean;

public class MainCore {
	
	public static void main(String[] args) {
		UsuarioBean bean = new UsuarioBean();
		bean = Bean.deserialize(UsuarioBean.class, "{\"id\":1,\"nome\":\"Monica\",\"sobrenome\":\"Kist\"}");
		bean.addTelefone("48 8465-3335");
		System.out.println(bean.json());
		System.out.println(bean.json(true));
		System.out.println(bean.jsonOnlyExposed());
		System.out.println(bean.jsonOnlyExposed(true));
		System.out.println(K2Bundle.getParam("teste"));
	}

}