package br.com.projetoRest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.projetoRest.entidade.EMotorista;
import br.com.projetoRest.util.Conexao;

public class MotoristaDao implements MotoristaDaoInterface {

	@Override
	public int incluir(EMotorista tipo) throws SQLException {
		int idGerado = 0;
        String sql = "INSERT INTO public.motorista(cpfmotorista, telefonemotorista, statusmotorista, marcamodelocarromotorista, localizacaomotorista, notamediamotorista, pagamentocartao, pagamentodinheiro, corcarromotorista, placacarromotorista, nomemotorista)" + 
        		" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        prd.setString(1, tipo.getCpf());
        prd.setString(2, tipo.getTelefone());
        prd.setString(3, tipo.getStatus());
        prd.setString(4, tipo.getMarcaModeloCarro());
        prd.setString(5, tipo.getLocalizacao());
        prd.setFloat (6, tipo.getNotaMedia());
        prd.setBoolean(7, tipo.isPagamentoCartao());
        prd.setBoolean(8, tipo.isPagamentoDinheiro());
        prd.setString(9, tipo.getCorCarro());
        prd.setString(10, tipo.getPlacaCarro());
        prd.setString(11, tipo.getNome());
        prd.execute();
        
        ResultSet rs = prd.getGeneratedKeys();
		if (rs.next())idGerado = rs.getInt(1);
		
		cnn.close();
		return idGerado;
	}

	@Override
	public int atualizar(EMotorista tipo) throws SQLException {
		String sql = "UPDATE public.motorista" + 
				"	SET cpfmotorista=?, telefonemotorista=?, statusmotorista=?, marcamodelocarromotorista=?, localizacaomotorista=?, notamediamotorista=?, pagamentocartao=?, pagamentodinheiro=?, corcarromotorista=?, placacarromotorista=?, nomemotorista=?" + 
				"	WHERE idmotorista=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, tipo.getCpf());
        prd.setString(2, tipo.getTelefone());
        prd.setString(3, tipo.getStatus());
        prd.setString(4, tipo.getMarcaModeloCarro());
        prd.setString(5, tipo.getLocalizacao());
        prd.setFloat (6, tipo.getNotaMedia());
        prd.setBoolean(7, tipo.isPagamentoCartao());
        prd.setBoolean(8, tipo.isPagamentoDinheiro());
        prd.setString(9, tipo.getCorCarro());
        prd.setString(10, tipo.getPlacaCarro());
        prd.setString(11, tipo.getNome());
        prd.setInt   (12, tipo.getId());
        
        int saida = prd.executeUpdate();
        
        cnn.close();
        return saida;
	}

	@Override
	public int excluir(int codigo) throws SQLException {
		String sql = "DELETE FROM public.motorista WHERE idmotorista=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, codigo);

        int saida = prd.executeUpdate();
        
        cnn.close();
        return saida;
	}

	@Override
	public EMotorista consultar(int codigo) throws SQLException {
		String sql = "SELECT * FROM public.motorista"
                + " WHERE idmotorista=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();

        EMotorista tipo = new EMotorista();

        if (rs.next()) {
            tipo.setId(rs.getInt("idmotorista"));
            tipo.setCpf(rs.getString("cpfmotorista"));
            tipo.setTelefone(rs.getString("telefonemotorista"));
            tipo.setStatus(rs.getString("statusmotorista"));
            tipo.setMarcaModeloCarro(rs.getString("marcamodelocarromotorista"));
            tipo.setLocalizacao(rs.getString("localizacaomotorista"));
            tipo.setNotaMedia(rs.getFloat("notamediamotorista"));
            tipo.setPagamentoCartao(rs.getBoolean("pagamentocartao"));
            tipo.setPagamentoDinheiro(rs.getBoolean("pagamentodinheiro"));
            tipo.setCorCarro(rs.getString("corcarromotorista"));
            tipo.setPlacaCarro(rs.getString("placacarromotorista"));
            tipo.setNome(rs.getString("nomemotorista"));
        }
        cnn.close();
        return tipo;
	}

	@Override
	public ArrayList<EMotorista> listar() throws SQLException {
		String sql = "SELECT * FROM public.motorista;";

        Connection cnn = Conexao.getConexao();
        Statement prd = cnn.createStatement();
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<EMotorista> lista = new ArrayList<EMotorista>();

        while (rs.next()) {
        	EMotorista tipo = new EMotorista();
        	 tipo.setId(rs.getInt("idmotorista"));
             tipo.setCpf(rs.getString("cpfmotorista"));
             tipo.setTelefone(rs.getString("telefonemotorista"));
             tipo.setStatus(rs.getString("statusmotorista"));
             tipo.setMarcaModeloCarro(rs.getString("marcamodelocarromotorista"));
             tipo.setLocalizacao(rs.getString("localizacaomotorista"));
             tipo.setNotaMedia(rs.getFloat("notamediamotorista"));
             tipo.setPagamentoCartao(rs.getBoolean("pagamentocartao"));
             tipo.setPagamentoDinheiro(rs.getBoolean("pagamentodinheiro"));
             tipo.setCorCarro(rs.getString("corcarromotorista"));
             tipo.setPlacaCarro(rs.getString("placacarromotorista"));
             tipo.setNome(rs.getString("nomemotorista"));
            lista.add(tipo);
        }
        cnn.close();
        return lista;
	}

}
