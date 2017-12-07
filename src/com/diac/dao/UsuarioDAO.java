package com.diac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.diac.model.Usuario;
import com.diac.util.DBConnect;

public class UsuarioDAO {

	private DBConnect connect = new DBConnect();
	private int count;

    public UsuarioDAO() {
        connect.connectDB();
    }
    
    public int getCount() {
    	return count;
    }

    public void setCount(int count) {
    	this.count = count;
    }
    
		public void checkUsuario(Usuario user) {
				
				String value1 = user.getUnome();
				String value2 = user.getPass();
		        try {
		        	   Statement st = connect.getConn().createStatement();
			           ResultSet rs = st.executeQuery("select * from usuario where unome='"+value1+"' and pass='"+value2+"'");
			           setCount(0);
			           while(rs.next()){
			               setCount(getCount() + 1);
			           }
		 
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		

}
