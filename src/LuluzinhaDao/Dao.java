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
    final private String url = "172.19.18.130:3306/entrega_agenda";
    final private String driver = "com.mysql.jdbc.Driver";
    final private String usuario ="root";
    final private String senha="";
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
