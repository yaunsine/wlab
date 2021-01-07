/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.UserInfo;
import bean.Word;

/**
 * @author Administrator
 *
 */
public class GetConn {

	/**
	 * 
	 */
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getconn(){
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "yuan";
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public GetConn() {
		// TODO Auto-generated constructor stub
		
	}
	public List<UserInfo> queryall(){
		Connection conn = getconn();
		ResultSet rs = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user");
			while(rs.next()){
				String username = rs.getString(1);
				String password = rs.getString(2);
				int age = rs.getInt(3);
				String power = rs.getString(4);
				UserInfo userinfo = new UserInfo();
				UserInfo user = userinfo.user(username, password, age, power);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<UserInfo> queryuname(String username){
		Connection conn = getconn();
		ResultSet rs = null;
		UserInfo userinfo =  new UserInfo();
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from user where username = ?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			while(rs.next()){
				String password = rs.getString(2);
				int age = rs.getInt(3);
				String power = rs.getString(4);
				userinfo.setuser(username, password, age, power);
				list.add(userinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void deleteuser(String username){
		Connection conn = getconn();
		String sql = "delete from user where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteword(int id){
		Connection conn = getconn();
		String sql = "delete from word where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean insertuser(UserInfo user){
		Connection conn = getconn();
		String sql = "insert into user values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getAge());
			stmt.setString(4, user.getPower());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean addWord(Word word){
		Connection conn = getconn();
		String sql = "insert into word(wtext,sentence,stime,meaning) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, word.getWtext());
			ps.setString(2, word.getSentence());
			ps.setString(3, word.getWtime());
			ps.setString(4, word.getMeaning());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean modifyWord(Word word,int id){
		ResultSet rs;
		Connection conn = getconn();
		String sql = "update word set wtext = ?,sentence = ?,stime = ?,meaning=? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,word.getWtext());
			ps.setString(2,word.getSentence());
			ps.setString(3,word.getWtime());
			ps.setInt(5,id);
			ps.setString(4,word.getMeaning());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean modify(UserInfo user){
		ResultSet rs;
		Connection conn = getconn();
		String sql = "update user set password = ?,age = ?,power = ? where username = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getPassword());
			stmt.setInt(2, user.getAge());
			stmt.setString(3, user.getPower());
			stmt.setString(4, user.getUsername());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<Word> queryWord(){
		List<Word> wlist = new ArrayList<Word>();
		ResultSet rs;
		Connection conn = getconn();
		String sql = "select * from word";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Word word = new Word();
				word.setWtext(rs.getString(1));
				word.setSentence(rs.getString(2));
				word.setWtime(rs.getString(3));
				word.setId(rs.getInt(4));
				word.setMeaning(rs.getString(5));
				wlist.add(word);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wlist;
	}
	public int query(String username,String password) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = getconn();
		String sql = "select power from user where username = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1) != null){
					if(rs.getString(1).equals("vip")){
						return 1;
					}else if(rs.getString(1).equals("NULL")){
						return 0;
					}
				}
				else{
					return 0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
