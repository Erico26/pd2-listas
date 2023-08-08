package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Genero;

public class GeneroDAO {

	public boolean inserir(Genero p) {
		//intanciar
		Conexao c = Conexao.getInstancia();
		
		//abrir instancia com o banco de dados
		Connection con = c.conectar();
		
		String query = "INSERT INTO genero (id_jogo, 'nome_jogo') VALUES (1, Bloodborne)";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			//seta parametros
			ps.setInt(1, p.getIdjogo());
			ps.setString(2, p.getNomejogo());
			
			//Consolidar a conexão do comando no banco
			ps.executeUpdate();
			
			//fecha a conexão
			c.fecharConexao();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
