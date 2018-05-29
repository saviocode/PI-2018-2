package br.com.projetoRest.entidade;

public class EMotorista {
	
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String status;
	private String marcaModeloCarro;
	private String corCarro;
	private String placaCarro;
	private String localizacao;
	private float notaMedia;
	private boolean pagamentoCartao;
	private boolean pagamentoDinheiro;
	
	
	public EMotorista() {}
	public EMotorista(int id, String nome, String cpf, String telefone, String status, String marcaModeloCarro,
			String corCarro, String placaCarro, String localizacao, float notaMedia, boolean pagamentoCartao,
			boolean pagamentoDinheiro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.status = status;
		this.marcaModeloCarro = marcaModeloCarro;
		this.corCarro = corCarro;
		this.placaCarro = placaCarro;
		this.localizacao = localizacao;
		this.notaMedia = notaMedia;
		this.pagamentoCartao = pagamentoCartao;
		this.pagamentoDinheiro = pagamentoDinheiro;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMarcaModeloCarro() {
		return marcaModeloCarro;
	}
	public void setMarcaModeloCarro(String marcaModeloCarro) {
		this.marcaModeloCarro = marcaModeloCarro;
	}
	public String getCorCarro() {
		return corCarro;
	}
	public void setCorCarro(String corCarro) {
		this.corCarro = corCarro;
	}
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public float getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(float notaMedia) {
		this.notaMedia = notaMedia;
	}
	public boolean isPagamentoCartao() {
		return pagamentoCartao;
	}
	public void setPagamentoCartao(boolean pagamentoCartao) {
		this.pagamentoCartao = pagamentoCartao;
	}
	public boolean isPagamentoDinheiro() {
		return pagamentoDinheiro;
	}
	public void setPagamentoDinheiro(boolean pagamentoDinheiro) {
		this.pagamentoDinheiro = pagamentoDinheiro;
	}
	
	
}
