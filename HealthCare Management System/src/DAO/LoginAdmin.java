package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginAdmin {

	public static boolean login(String id, String password){
	//	System.out.println(id+"  "+password);
		
		boolean b=false;
		String statement="select * from USER1.LOGIN where ID='"+id+"' and PASSWORD='"+password+"'";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
		
			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}
