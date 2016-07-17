package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.Category;

public class ModelCategory {
	LibaryConnectDatabase db=new LibaryConnectDatabase();
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	public ArrayList<Category> getListCat() {
		ArrayList<Category> alCat = new ArrayList<>();
		Category cat;
		String query="SELECT* FROM category";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				cat=new Category(rs.getInt(1),rs.getString(2));
				alCat.add(cat);
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
		
		return alCat;
	}
	public int addItemCat(Category objCat) {
		int result=0;
		String query="INSERT INTO category(name) value(?) ";
		try {
			ps=db.getConnectMySQL().prepareStatement(query);
			ps.setString(1,objCat.getName());
			ps.executeUpdate();
			result=1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int delItemCat(int cid) {
		int result=0;
		String query="DELETE FROM category WHERE id_cat=?  LIMIT 1";
		try {
			ps=db.getConnectMySQL().prepareStatement(query);
			ps.setInt(1, cid);
			ps.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public Category getListByItem(int id) {
		Category cat=null;
		String sql="SELECT * FROM category WHERE id_cat= "+id;
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				cat=new Category(rs.getInt(1),rs.getString(2));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return cat;
	}
	public int editItemCat(Category objCat) {
		int result=0;
		String sql="UPDATE category SET name=? WHERE id_cat=? LIMIT 1";
		
		try {
			ps=db.getConnectMySQL().prepareStatement(sql);
			ps.setString(1,objCat.getName());
			ps.setInt(2,objCat.getIdCat());
			ps.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int getTotal() {
		int total=0;
		String sql="Select count(id_cat) as total from category";
		try {
			ps=db.getConnectMySQL().prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	public ArrayList<Category> getListForPaginator(int offset, int row_count) {
		ArrayList<Category> alCat=new ArrayList<>();
		Category cat;
		String sql=" SELECT id_cat,name from category LIMIT "+offset+","+row_count;		
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				cat =new Category(rs.getInt(1), rs.getString(2));
				alCat.add(cat);
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
		return alCat;
	}

	

}
