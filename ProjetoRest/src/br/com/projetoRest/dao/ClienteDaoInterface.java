package br.com.projetoRest.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetoRest.entidade.ECliente;

public interface ClienteDaoInterface {
	
	public int incluir(ECliente tipo)throws SQLException;
    public int atualizar(ECliente tipo)throws SQLException;
    public int excluir(int codigo)throws SQLException;
    public ECliente consultar(int codigo)throws SQLException;
    public ArrayList<ECliente> listar()throws SQLException;
    
}
