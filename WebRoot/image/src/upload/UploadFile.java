package upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sqlImgUtil.SqlImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 将图片上传至数据库
 *
 * @author SJ676
 *
 */
@WebServlet("/uploadFile")
public class UploadFile extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String serverPath = getServletContext().getRealPath("/").replace("\\", "/");
        // 基于磁盘文件创建工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 最大缓存，超过这个阈值将先保存至临时文件目录
        factory.setSizeThreshold(10 * 1024);
        // 临时文件目录 测试时可以直接打印在控制台显示实际路径
        factory.setRepository(new File(serverPath));

        ServletFileUpload sfupload = new ServletFileUpload(factory);
        sfupload.setSizeMax(10 * 1024 * 1024);// 文件最大上限
        /**************************************************************************************************************/
        try {
            // 在这里是直接获取了表单域中所有输入框的数据，在后面通过判断每一个< input > 的域值是否为上传文件，是的话就开始上传操作
            @SuppressWarnings("unchecked")
            // 获取所有文件列表开始上传
                    List<FileItem> items = sfupload.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                // 里面一个for循环，获取一行的数据
                FileItem item = items.get(i);
                // 判断是否为表单数据
                if (!item.isFormField()) {
                    // 文件名
                    String fileName = item.getName().toLowerCase();
                    InputStream in = item.getInputStream();
                    //获取上传文件的输入流，然后将输入流保存到数据库中
                    SqlImage.saveFile2Sql(in);
                    request.getRequestDispatcher("showImage.jsp").forward(request, response);
                } else {
                    // 如果是表单域中的数据，则直接输出表单中的数据，也可以不做处理
                    // String value = item.getString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
