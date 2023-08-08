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
		
		String query = "INSERT INTO";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
