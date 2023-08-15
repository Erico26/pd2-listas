package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Genero;

public class GeneroDAO {

	
	public ArrayList<Genero> listar(){
		 Conexao c = Conexao.getInstancia();
		 
		 Connection con = c.conectar();
		 
		 ArrayList<Genero> generos = new ArrayList();
		 
		 String query = "SELECT * from genero";
		 try {
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int idjogo = rs.getInt("idjogo");
					
					String genero = rs.getString("genero");
				}
				
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 return generos;
	}
	
	
	
	public boolean inserir(Genero p) {
		//intanciar
		Conexao c = Conexao.getInstancia();
		
		//abrir instancia com o banco de dados
		Connection con = c.conectar();
		
		String query = "INSERT INTO genero " + "(id_jogo, 'nome_jogo')" + "VALUES (?, ?)";
		
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
