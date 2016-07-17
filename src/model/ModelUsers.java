package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.Users;

public class ModelUsers {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	LibaryConnectDatabase db=new LibaryConnectDatabase();
	public ArrayList<Users> getListUsers() {
		ArrayList<Users> alUsers=new ArrayList<>();
		Users users;
		String sql="SELECT * FROM users ";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				users=new Users(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
				alUsers.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alUsers;
	}
	public int addItemUsers(Users users) {
		int result=0;
		String sql="INSERT INTO users(username,password,fullname) values(?,?,?)";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,users.getUsername());
			pst.setString(2, users.getPassword());
			pst.setString(3, users.getFullname());
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public Users getListByItem(int uid) {
		Users objUser=null;
		
		
		String sql="Select*from users where id_users=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			if(rs.next()){
				objUser=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
		} catch (SQLException e) {
			
		
		}finally{
			try {
				rs.close();
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return objUser;
}
	public int editItem(Users objUser) {
		int result=0;
		String sql="UPDATE users SET username=?, password=?, fullname=? WHERE id_users=? LIMIT 1" ;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			
			pst.setString(1,objUser.getUsername() );
			pst.setString(2, objUser.getPassword());
			pst.setString(3, objUser.getFullname());
			pst.setInt(4,objUser.getIdUsers());
			
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
		}finally{
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	public int delItemUsers(int uid) {
		int result=0;
		String sql="DELETE FROM users WHERE id_users=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,uid);
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public Users checkLogin(String username, String pass_new) {
		Users objUser = null;
		
		String query = "SELECT * FROM users WHERE username =? && password =? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			pst.setString(1,username);
			pst.setString(2, pass_new);
			rs = pst.executeQuery();
			if(rs.next()){
				objUser = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return objUser;
		
		
	}
	public int getTotal() {
		int total=0;
		String sql="Select count(id_users) as total from users";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	public ArrayList<Users> getListForPaginator(int offset, int row_count) {
		ArrayList<Users> alUsers=new ArrayList<>();
		Users objUsers;
		String sql=" SELECT id_users,username,password,fullname from users LIMIT "+offset+","+row_count;		
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objUsers =new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				alUsers.add(objUsers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alUsers;
	}
	/*public Users getListString(String search) {
		Users users=null;
		String sql="SELECT* FROM users WHERE username like=?";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,search);;
			pst.executeUpdate();
			if(rs.next()){
				users=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return users;
	}*/
}
