package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import bean.Word;
import dao.GetConn;

public class ModifyServlet extends HttpServlet {

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
		String age = request.getParameter("agevalue");
		String meaning = request.getParameter("meanvalue");
		int id = Integer.parseInt(request.getParameter("id"));
		Word word = new Word();
		word.setWtext(username);
		word.setSentence(password);
		word.setWtime(age);
		word.setMeaning(meaning);
		GetConn getc = new GetConn();
		boolean flag = getc.modifyWord(word,id);
		List<Word> ulist = getc.queryWord();
		request.setAttribute("wlist", ulist);
		if(flag == true){
			request.getRequestDispatcher("../manager.jsp").forward(request, response);
		}else{
		}
	}

}
