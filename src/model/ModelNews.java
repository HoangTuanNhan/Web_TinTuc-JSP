package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.News;

public class ModelNews {
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private Statement st;
	private ResultSet rs;
	PreparedStatement pst;
	public ArrayList<News> getListNews() {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,c.name,preview_text,detail_text, id_cat,picture,n.name from news as n "
					+"inner join category c using(id_cat)"
					+"order by id_news desc";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				alNews.add(objNews);
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
		return alNews;
	}
	public News getItemById(int nid) {
		News objItem=null;		
		String sql=" SELECT id_news ,c.name,preview_text,detail_text, id_cat,picture,n.name from news as n "
				+"inner join category as c using(id_cat) "
				+"where id_news=?"
				+" order by id_news desc";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, nid);
			rs=pst.executeQuery();
			System.out.println(sql);
			if(rs.next()){
				objItem=new News(nid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				
			}
		} catch (SQLException e) {
			
		
		}finally{
			try {
				
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return objItem ;
	}
	
	public boolean addItem(News objNews) {
		boolean result=false;
		String sql="INSERT INTO news(name,preview_text,detail_text,id_cat,picture) values(?,?,?,?,?)";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1, objNews.getName());
			pst.setString(2,objNews.getPreview_text());
			pst.setString(3, objNews.getDetail_text());
			pst.setInt(4,objNews.getIdCat() );
			pst.setString(5,objNews.getPicture());
			pst.executeUpdate();
			result=true;
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
	public boolean editItem(News Item) {
		boolean result = false;
		
		String query = "UPDATE news SET name =?, preview_text =?, detail_text =?, id_cat =? ,picture =? WHERE id_news =? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			pst.setString(1, Item.getName());
			pst.setString(2, Item.getPreview_text());
			pst.setString(3, Item.getDetail_text());
			pst.setInt(4, Item.getIdCat());
			pst.setString(5, Item.getPicture());
			pst.setInt(6, Item.getIdNews());
			pst.executeUpdate();
			System.out.println( Item.getPicture());
			result =true;
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
	public int getTotal() {
		int total=0;
		String sql="Select count(id_news) as total from news inner join category USING(id_cat)";
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
	public ArrayList<News> getListForPaginator(int offset,int row_count) {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,c.name,preview_text,detail_text, id_cat,picture,n.name from news as n "
					+"inner join category c using(id_cat)"
					+"order by id_news desc LIMIT "+offset+","+row_count;
					
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				alNews.add(objNews);
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
		return alNews;
	}
	public ArrayList<News> getListByItem(int id) {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,c.name,preview_text,detail_text, id_cat,picture,n.name from news as n "
					+"inner join category c using(id_cat)"
					+"WHERE id_cat="+id;
					
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				alNews.add(objNews);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {

				st.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alNews;
	}
	public ArrayList<News> getListForPaginator(int offset,int row_count,int id) {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,c.name,preview_text,detail_text, id_cat,picture,n.name from news as n "
					+"inner join category c using(id_cat)"
					+"WHERE n.id_cat="+id
					+" order by id_news desc LIMIT "+offset+","+row_count;
					
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),"");
				alNews.add(objNews);
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
		return alNews;
	}
public News getItemByIdNews(int nid) {
		News Item = null;
		String query = "SELECT * FROM news WHERE id_news =? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			
			pst.setInt(1,nid);
			rs = pst.executeQuery();
			if(rs.next()){
				Item = new News(nid, rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6) ,"");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Item;
	}
public int delItemNews(int nid) {
	int result=0;
	String sql="DELETE FROM news WHERE id_news=? LIMIT 1";
	try {
		pst=db.getConnectMySQL().prepareStatement(sql);
		pst.setInt(1,nid);
		pst.executeUpdate();
		result=1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return result;
}
public News getListDetail(int id) {
	
	News objNews=null;
	String sql="SELECT * FROM news WHERE id_news=? LIMIT 1";
	try {
		pst=db.getConnectMySQL().prepareStatement(sql);
		pst.setInt(1, id);
		rs=pst.executeQuery();
		while(rs.next()){
			objNews=new News(id,rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5), rs.getString(6),"");	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return objNews;
}
public ArrayList<News> getListDetail(int id, int idCat) {
	ArrayList<News> alNews=new ArrayList<>();
	News objNews;
	String sql=" SELECT id_news ,n.name,preview_text,detail_text, id_cat,picture,is_active,c.name from news as n inner join category c using(id_cat) WHERE n.id_news!="+id+" && n.id_cat="+idCat+" order by id_news desc LIMIT 2";
	try {
		st=db.getConnectMySQL().createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()){
			objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
			alNews.add(objNews);
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
	return alNews;
}
}
