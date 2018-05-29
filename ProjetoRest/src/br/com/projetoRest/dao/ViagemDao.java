package br.com.projetoRest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.projetoRest.entidade.ECliente;
import br.com.projetoRest.entidade.EMotorista;
import br.com.projetoRest.entidade.EViagem;
import br.com.projetoRest.util.Conexao;
import br.com.projetoRest.util.DataHelper;

public class ViagemDao implements ViagemDaoInterface {

	@Override
	public int incluir(EViagem tipo) throws SQLException {
		int idGerado = 0;
        String sql = "INSERT INTO public.viagem(idmotorista, idcliente, destinoviagem, origemviagem, formadepagamento, datahorapedido, datahoraconfirmado, datahorainicio, datahorafim, datahoracancelado)\r\n" + 
        		"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        prd.setInt   (1, tipo.getMotorista().getId());
        prd.setInt   (2, tipo.getCliente().getId());
        prd.setString(3, tipo.getDestino());
        prd.setString(4, tipo.getOrigem());
        prd.setString(5, tipo.getFormaPagamento());
        prd.setObject(6, tipo.getDataHoraInicio().getDataString());
        prd.setObject(7, tipo.getDataHoraConfirmado().getDataString());
        prd.setObject(8, tipo.getDataHoraInicio().getDataString());
        prd.setObject(9, tipo.getDataHoraFim().getDataString());
        prd.setObject(10, tipo.getDataHoraCancelado().getDataString());
        prd.execute();
        
        ResultSet rs = prd.getGeneratedKeys();
		if (rs.next())idGerado = rs.getInt(1);
		
		cnn.close();
		return idGerado;
	}

	@Override
	public int atualizar(EViagem tipo) throws SQLException {
		String sql = "UPDATE public.viagem" + 
				"	SET idmotorista=?, idcliente=?, destinoviagem=?, origemviagem=?, formadepagamento=?, datahorapedido=?, datahoraconfirmado=?, datahorainicio=?, datahorafim=?, datahoracancelado=?" + 
				"	WHERE idviagem=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt   (1, tipo.getMotorista().getId());
        prd.setInt   (2, tipo.getCliente().getId());
        prd.setString(3, tipo.getDestino());
        prd.setString(4, tipo.getOrigem());
        prd.setString(5, tipo.getFormaPagamento());
        prd.setObject(6, tipo.getDataHoraInicio().getDataString());
        prd.setObject(7, tipo.getDataHoraConfirmado().getDataString());
        prd.setObject(8, tipo.getDataHoraInicio().getDataString());
        prd.setObject(9, tipo.getDataHoraFim().getDataString());
        prd.setObject(10, tipo.getDataHoraCancelado().getDataString());
        prd.setInt   (11, tipo.getId());
        
        int saida = prd.executeUpdate();
        
        cnn.close();
        return saida;
	}

	@Override
	public int excluir(int codigo) throws SQLException {
		String sql = "DELETE FROM public.viagem WHERE idviagem=?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, codigo);

        int saida = prd.executeUpdate();
        
        cnn.close();
        return saida;
	}

	@Override
	public EViagem consultar(int codigo) throws Exception {
		String sql = "SELECT *" + 
				" FROM public.viagem" + 
				" INNER JOIN public.motorista ON motorista.idmotorista = viagem.idmotorista" + 
				" INNER JOIN public.cliente	ON cliente.idcliente = viagem.idcliente" + 
				" WHERE viagem.idviagem = ?;";

        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();

        EViagem tipo = new EViagem();

        if (rs.next()) {
        	tipo.setId(rs.getInt("idviagem"));
            tipo.setMotorista(new EMotorista(rs.getInt("idmotorista"), rs.getString("nomemotorista"), rs.getString("cpfmotorista"), rs.getString("telefonemotorista"), rs.getString("statusmotorista"), rs.getString("marcamodelocarromotorista"), rs.getString("corcarromotorista"), rs.getString("placacarromotorista"), rs.getString("localizacaomotorista"), rs.getFloat("notamediamotorista"), rs.getBoolean("pagamentocartao"),  rs.getBoolean("pagamentodinheiro")));
            tipo.setCliente(new ECliente(rs.getInt("idcliente"), rs.getString("cpfcliente"), rs.getString("telefonecliente"), rs.getString("nomecliente"), rs.getString("emailcliente"), rs.getString("numerocartaocliente"), rs.getString("datavalidadecartaocliente"), rs.getString("codigosegurancacartaocliente")));
            tipo.setDestino(rs.getString("destinoviagem"));
            tipo.setOrigem(rs.getString("origemviagem"));
            tipo.setFormaPagamento(rs.getString("formadepagamento"));
            tipo.setDataHoraPedido(new DataHelper(rs.getString("datahorapedido")));
            tipo.setDataHoraConfirmado(new DataHelper(rs.getString("datahoraconfirmado")));
            tipo.setDataHoraInicio(new DataHelper(rs.getString("datahorainicio")));
            tipo.setDataHoraFim(new DataHelper(rs.getString("datahorafim")));
            tipo.setDataHoraCancelado(new DataHelper(rs.getString("datahoracancelado")));
        }
        cnn.close();
        return tipo;
	}

	@Override
	public ArrayList<EViagem> listar() throws Exception {
		String sql = "SELECT *" + 
				"	FROM public.viagem" + 
				"	INNER JOIN public.motorista ON motorista.idmotorista = viagem.idmotorista" + 
				"	INNER JOIN public.cliente	ON cliente.idcliente = viagem.idcliente;";

        Connection cnn = Conexao.getConexao();
        Statement prd = cnn.createStatement();
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<EViagem> lista = new ArrayList<EViagem>();

        while (rs.next()) {
        	EViagem tipo = new EViagem();
        	tipo.setId(rs.getInt("idviagem"));
            tipo.setMotorista(new EMotorista(rs.getInt("idmotorista"), rs.getString("nomemotorista"), rs.getString("cpfmotorista"), rs.getString("telefonemotorista"), rs.getString("statusmotorista"), rs.getString("marcamodelocarromotorista"), rs.getString("corcarromotorista"), rs.getString("placacarromotorista"), rs.getString("localizacaomotorista"), rs.getFloat("notamediamotorista"), rs.getBoolean("pagamentocartao"),  rs.getBoolean("pagamentodinheiro")));
            tipo.setCliente(new ECliente(rs.getInt("idcliente"), rs.getString("cpfcliente"), rs.getString("telefonecliente"), rs.getString("nomecliente"), rs.getString("emailcliente"), rs.getString("numerocartaocliente"), rs.getString("datavalidadecartaocliente"), rs.getString("codigosegurancacartaocliente")));
            tipo.setDestino(rs.getString("destinoviagem"));
            tipo.setOrigem(rs.getString("origemviagem"));
            tipo.setFormaPagamento(rs.getString("formadepagamento"));
            tipo.setDataHoraPedido(new DataHelper(rs.getString("datahorapedido")));
            tipo.setDataHoraConfirmado(new DataHelper(rs.getString("datahoraconfirmado")));
            tipo.setDataHoraInicio(new DataHelper(rs.getString("datahorainicio")));
            tipo.setDataHoraFim(new DataHelper(rs.getString("datahorafim")));
            tipo.setDataHoraCancelado(new DataHelper(rs.getString("datahoracancelado")));
            lista.add(tipo);
        }
        cnn.close();
        return lista;
	}

}
