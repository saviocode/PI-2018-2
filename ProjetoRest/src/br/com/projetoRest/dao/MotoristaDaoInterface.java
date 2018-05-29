package br.com.projetoRest.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetoRest.entidade.EMotorista;

public interface MotoristaDaoInterface {
	public int incluir(EMotorista tipo)throws SQLException;
    public int atualizar(EMotorista tipo)throws SQLException;
    public int excluir(int codigo)throws SQLException;
    public EMotorista consultar(int codigo)throws SQLException;
    public ArrayList<EMotorista> listar()throws SQLException;
}
