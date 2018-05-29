package br.com.projetoRest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.projetoRest.entidade.ECliente;
import br.com.projetoRest.util.Conexao;

public class ClienteDao implements ClienteDaoInterface{

	@Override
	public int incluir(ECliente tipo) throws SQLException {
		int idGerado = 0;
        String sql = "INSERT INTO public.cliente(cpfcliente, telefonecliente, nomecliente, emailcliente, numerocartaocliente, datavalidadecartaocliente, codigosegurancacartaocliente)\r\n" + 
        		"	VALUES (?, ?, ?, ?, ?, ?, ?);";
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        prd.setString(1, tipo.getCpf());
        prd.setString(2, tipo.getTelefone());
        prd.setString(3, tipo.getNome());
        prd.setString(4, tipo.getEmail());
        prd.setString(5, tipo.getNumeroCartao());
        prd.setString(6, tipo.getDataValidadeCartao());
        prd.setString(7, tipo.getCodigoSegurancaCartao());
        prd.execute();
        
        ResultSet rs = prd.getGeneratedKeys();
		if (rs.next())idGerado = rs.getInt(1);
		
		cnn.close();
		return idGerado;
	}

	@Override
	public int atualizar(ECliente tipo) throws SQLException {
				
		String sql = "UPDATE public.cliente SET cpfcliente=?, telefonecliente=?, nomecliente=?, emailcliente=?, numerocartaocliente=?, datavalidadecartaocliente=?, codigosegurancacartaocliente=?"
				+" WHERE idcliente=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, tipo.getCpf());
        prd.setString(2, tipo.getTelefone());
        prd.setString(3, tipo.getNome());
        prd.setString(4, tipo.getEmail());
        prd.setString(5, tipo.getNumeroCartao());
        prd.setString(6, tipo.getDataValidadeCartao());
        prd.setString(7, tipo.getCodigoSegurancaCartao());
        prd.setInt	 (8, tipo.getId());
        
        int saida = prd.executeUpdate();
        
        cnn.close();
        return saida;
	}

	@Override
	public int excluir(int codigo) throws SQLException {
		String sql = "DELETE FROM public.cliente WHERE idcliente=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, codigo);

        int saida = prd.executeUpdate();
        
        cnn.close();
        return saida;
	}

	@Override
	public ECliente consultar(int codigo) throws SQLException {
		String sql = "SELECT * FROM public.cliente"
                + " WHERE idcliente=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();

        ECliente tipo = new ECliente();

        if (rs.next()) {
            tipo.setId(rs.getInt("idcliente"));
            tipo.setCpf(rs.getString("cpfcliente"));
            tipo.setTelefone(rs.getString("telefonecliente"));
            tipo.setNome(rs.getString("nomecliente"));
            tipo.setEmail(rs.getString("emailcliente"));
            tipo.setNumeroCartao(rs.getString("numerocartaocliente"));
            tipo.setDataValidadeCartao(rs.getString("datavalidadecartaocliente"));
            tipo.setCodigoSegurancaCartao(rs.getString("codigosegurancacartaocliente"));
        }
        cnn.close();
        return tipo;
	}

	@Override
	public ArrayList<ECliente> listar() throws SQLException {
		String sql = "SELECT * FROM public.cliente;";

        Connection cnn = Conexao.getConexao();
        Statement prd = cnn.createStatement();
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<ECliente> lista = new ArrayList<ECliente>();

        while (rs.next()) {
        	ECliente tipo = new ECliente();
        	tipo.setId(rs.getInt("idcliente"));
            tipo.setCpf(rs.getString("cpfcliente"));
            tipo.setTelefone(rs.getString("telefonecliente"));
            tipo.setNome(rs.getString("nomecliente"));
            tipo.setEmail(rs.getString("emailcliente"));
            tipo.setNumeroCartao(rs.getString("numerocartaocliente"));
            tipo.setDataValidadeCartao(rs.getString("datavalidadecartaocliente"));
            tipo.setCodigoSegurancaCartao(rs.getString("codigosegurancacartaocliente"));
            lista.add(tipo);
        }
        cnn.close();
        return lista;
	}

}
