package sqlImgUtil;

import java.sql.*;

public class DBConnector {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/webdemo?useUnicode=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static void  release(PreparedStatement pstmt , Connection conn , ResultSet rs) throws SQLException{
        if(pstmt != null){
            pstmt.close();
        }
        if(conn != null){
            conn.close();
        }
        if(rs != null){
            rs.close();
        }
    }
}