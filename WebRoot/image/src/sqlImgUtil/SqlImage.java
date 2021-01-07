package sqlImgUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class SqlImage {
    public static Connection conn;
    public static PreparedStatement pstmt;
    public static ResultSet rs;

    /**
     * 将图片转化成字节流，然后以blod（sql）格式存入数据库中
     *
     * @param
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void saveFile2Sql(InputStream in) throws SQLException, IOException, ClassNotFoundException {
        //FileInputStream fin = new FileInputStream(new File(path));
        conn = DBConnector.getConnection();
        String sql = "insert into image values(?,?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setBinaryStream(1, in, in.available());
        pstmt.setInt(2, 9);
        pstmt.executeUpdate();
        DBConnector.release(pstmt, conn, rs);

    }

    /**
     * 通过将从数据库中获取的图片资源转化为输入流
     *
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @return in InputStream
     */
    public static InputStream getSqlImgFile() throws SQLException, FileNotFoundException, ClassNotFoundException {
        conn = DBConnector.getConnection();
        String sql = "select imag from image where id = 8";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        InputStream in = null;
        while (rs.next()) {
            Blob blob = rs.getBlob(1);
            // 从数据中获取图片资源输入到输入流
            in = blob.getBinaryStream();
            // 可以将输入流写到BufferImage中
            return in;
        }
        DBConnector.release(pstmt, conn, rs);

        return null;

    }
}
