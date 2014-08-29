package in.k2s.core.bean.test;

import in.k2s.core.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private List<TelefoneBean> telefones;
	
	public void addTelefone(String telefone) {
		if(telefones == null) telefones = new ArrayList<TelefoneBean>();
		this.telefones.add(new TelefoneBean(telefone));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<TelefoneBean> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneBean> telefones) {
		this.telefones = telefones;
	}

}
