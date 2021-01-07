package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import bean.Word;
import dao.GetConn;

/**
 * Servlet implementation class AddWordServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddWordServlet" })
public class AddWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GB2312");
		String wtext = request.getParameter("newword");
		String sentence = request.getParameter("sentence");
		String meaning = request.getParameter("meaning");
		Word word = new Word();
		word.setWtext(wtext);
		word.setSentence(sentence);
		word.setMeaning(meaning);
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		String wtime = sp.format(new Date());
		word.setWtime(wtime);
//		word.setSentence(sentence);
		GetConn getc = new GetConn();
		boolean flag = getc.addWord(word);
		List<Word> wlist = getc.queryWord();
		request.setAttribute("wlist", wlist);
		if(flag == true){
			request.getRequestDispatcher("../manager.jsp").forward(request, response);
		}else{
//			javax.swing.JOptionPane.showMessageDialog(null, "添加失败,请重新添加！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
