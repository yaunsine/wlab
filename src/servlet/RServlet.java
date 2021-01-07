package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import bean.Word;
import dao.GetConn;

public class RServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GB2312");
		int username = Integer.parseInt(request.getParameter("uname"));
		GetConn getc = new GetConn();
		getc.deleteword(username);
		GetConn getconn = new GetConn();
		List<Word> ulist = getconn.queryWord();
		request.setAttribute("wlist", ulist);
		
		String url = java.net.URLDecoder.decode("../manager.jsp","GB2312");
		request.getRequestDispatcher(url).forward(request, response);
	}

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
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GB2312");
		GetConn getconn = new GetConn();
		String username = request.getParameter("idinput");
		String password = request.getParameter("pwdinput");
		int flag = getconn.query(username, password);
		String name = "";
		if(flag==1){
			request.getSession().setAttribute(name, "µ«¬º≥…π¶");
			List<UserInfo> ulist = getconn.queryall();
			request.setAttribute("ulist", ulist);
			request.setAttribute("nameinput", username);
			List<Word> wlist = getconn.queryWord();
			request.setAttribute("wlist",wlist);
			request.getRequestDispatcher("../manager.jsp").forward(request, response);
		}else if(flag == -1){
			//javax.swing.JOptionPane.showMessageDialog(null, "µ«¬º ß∞‹£¨«ÎºÏ≤È’À∫≈√‹¬Î «∑Ò’˝»∑£°");
			response.sendRedirect("../index.jsp");
		}else{
			List<UserInfo> ulist = getconn.queryall();
			request.setAttribute("ulist", ulist);
			request.setAttribute("nameinput", username);
			request.getRequestDispatcher("../normal.jsp").forward(request, response);
		}
		
	}

}
