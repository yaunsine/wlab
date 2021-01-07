package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import dao.GetConn;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GB2312");
		String username = request.getParameter("namevalue");
		String password = request.getParameter("pwdvalue");
		int age = Integer.parseInt(request.getParameter("agevalue"));
		String power = request.getParameter("level");
		if("1".equals(power)){
			power = "vip";
		}else{
			power = null;
		}
		UserInfo userinfo = new UserInfo();
		UserInfo u = userinfo.user(username, password, age, power);
		GetConn getc = new GetConn();
		boolean flag = getc.insertuser(u);
		List<UserInfo> ulist = getc.queryall();
		request.setAttribute("ulist", ulist);
		if(flag == true){
			request.getRequestDispatcher("../manager.jsp").forward(request, response);
		}else{
//			javax.swing.JOptionPane.showMessageDialog(null, "添加失败,请重新添加！");
		}
		
	}

}
