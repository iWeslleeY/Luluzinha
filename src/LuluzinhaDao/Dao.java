package LuluzinhaDao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author F0127063
 */
public class Dao {
    final private String url = "jdbc:mysql://mysql.emiliocelso.com.br:3306/entrega2_porto";
    final private String usuario ="entrega2_porto";
    final private String senha="p@ssw0rd";
    private PreparedStatement stmt;
    protected ResultSet rs;
    
    private Connection conexao;
    
    public Connection abrirConexao() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conexao = (Connection) DriverManager.getConnection(url , usuario , senha);
        return null;
    }
            
    public Connection fecharConexao() throws Exception{
		if(conexao!=null && !conexao.isClosed()){
			conexao.close();
		}
        return null;
	}
    
}
