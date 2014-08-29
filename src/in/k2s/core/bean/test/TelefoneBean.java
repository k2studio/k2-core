package in.k2s.core.bean.test;

import in.k2s.core.bean.BaseBean;

public class TelefoneBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	public TelefoneBean() {}
	
	public TelefoneBean(String telefone) {
		super();
		this.telefone = telefone;
	}

	private String telefone;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
