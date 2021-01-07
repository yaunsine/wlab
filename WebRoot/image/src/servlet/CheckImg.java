package servlet;

import sqlImgUtil.SqlImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class CheckImg
 */


@WebServlet("/CheckImg")
public class CheckImg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckImg() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        /***********************************************************************************************************/
        BufferedImage image = null;
        try {
            image = ImageIO.read(SqlImage.getSqlImgFile());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        //Graphics g = image.getGraphics();
        //加了下面这一行会在原图片上显示这个大小的700 600 大小的图片
        //g.drawImage(image,0,0,700,600,null);
        ImageIO.write(image, "JPRG", response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}