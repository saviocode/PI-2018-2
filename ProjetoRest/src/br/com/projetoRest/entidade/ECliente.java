package br.com.projetoRest.entidade;

public class ECliente {
	
	private int id;
	private String cpf;
	private String telefone;
	private String nome;
	private String email;
	private String numeroCartao;
	private String dataValidadeCartao;
	private String codigoSegurancaCartao;
	
	public ECliente() {}
	public ECliente(int id, String cpf, String telefone, String nome, String email, String numeroCartao,
			String dataValidadeCartao, String codigoSegurancaCartao) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.numeroCartao = numeroCartao;
		this.dataValidadeCartao = dataValidadeCartao;
		this.codigoSegurancaCartao = codigoSegurancaCartao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	public String getDataValidadeCartao() {
		return dataValidadeCartao;
	}
	public void setDataValidadeCartao(String dataValidadeCartao) {
		this.dataValidadeCartao = dataValidadeCartao;
	}
	
	public String getCodigoSegurancaCartao() {
		return codigoSegurancaCartao;
	}
	public void setCodigoSegurancaCartao(String codigoSegurancaCartao) {
		this.codigoSegurancaCartao = codigoSegurancaCartao;
	}
	
}
