package br.com.projetoRest.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetoRest.entidade.EViagem;

public interface ViagemDaoInterface {
	public int incluir(EViagem tipo)throws SQLException;
    public int atualizar(EViagem tipo)throws SQLException;
    public int excluir(int codigo)throws SQLException;
    public EViagem consultar(int codigo)throws Exception;
    public ArrayList<EViagem> listar()throws Exception;
}
