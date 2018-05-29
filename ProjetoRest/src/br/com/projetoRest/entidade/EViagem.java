package br.com.projetoRest.entidade;

import br.com.projetoRest.util.DataHelper;

public class EViagem {
	
	private int id;
	private EMotorista motorista;
	private ECliente cliente;
	private String origem;
	private String destino;
	private String formaPagamento;
	private DataHelper dataHoraPedido;
	private DataHelper dataHoraConfirmado;
	private DataHelper dataHoraInicio;
	private DataHelper dataHoraFim;
	private DataHelper dataHoraCancelado;
	
	public EViagem() {}
	public EViagem(int id, ECliente cliente, String origem, String destino, String formaPagamento,
			DataHelper dataHoraPedido) {
		super();
		this.id = id;
		this.motorista = null;
		this.cliente = cliente;
		this.origem = origem;
		this.destino = destino;
		this.formaPagamento = formaPagamento;
		this.dataHoraPedido = dataHoraPedido;
		this.dataHoraConfirmado = null;
		this.dataHoraInicio = null;
		this.dataHoraFim = null;
		this.dataHoraCancelado = null;
	}
	public EViagem(int id, EMotorista motorista, ECliente cliente, String origem, String destino, String formaPagamento,
			DataHelper dataHoraPedido, DataHelper dataHoraConfirmado, DataHelper dataHoraInicio, DataHelper dataHoraFim,
			DataHelper dataHoraCancelado) {
		super();
		this.id = id;
		this.motorista = motorista;
		this.cliente = cliente;
		this.origem = origem;
		this.destino = destino;
		this.formaPagamento = formaPagamento;
		this.dataHoraPedido = dataHoraPedido;
		this.dataHoraConfirmado = dataHoraConfirmado;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.dataHoraCancelado = dataHoraCancelado;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EMotorista getMotorista() {
		return motorista;
	}
	public void setMotorista(EMotorista motorista) {
		this.motorista = motorista;
	}
	public ECliente getCliente() {
		return cliente;
	}
	public void setCliente(ECliente cliente) {
		this.cliente = cliente;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public DataHelper getDataHoraPedido() {
		return dataHoraPedido;
	}
	public void setDataHoraPedido(DataHelper dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}
	public DataHelper getDataHoraConfirmado() {
		return dataHoraConfirmado;
	}
	public void setDataHoraConfirmado(DataHelper dataHoraConfirmado) {
		this.dataHoraConfirmado = dataHoraConfirmado;
	}
	public DataHelper getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(DataHelper dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public DataHelper getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(DataHelper dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public DataHelper getDataHoraCancelado() {
		return dataHoraCancelado;
	}
	public void setDataHoraCancelado(DataHelper dataHoraCancelado) {
		this.dataHoraCancelado = dataHoraCancelado;
	}
	
}
