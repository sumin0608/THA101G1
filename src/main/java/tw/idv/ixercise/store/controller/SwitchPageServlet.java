package tw.idv.ixercise.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SwitchPageServlet
 */
@WebServlet("/SwitchPageServlet")
public class SwitchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SwitchPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("sportyStyle");
		System.out.println(name);
		if("進入籃球商城".equals(name)) {
			response.sendRedirect("pageV5.jsp");
		}else if("進入棒球商城".equals(name)) {
			response.sendRedirect("baseball01.jsp");
		}else if("進入足球商城".equals(name)) {
			response.sendRedirect("soccer01.jsp");
		}else if("進入網球商城".equals(name)) {
			response.sendRedirect("soccer01.jsp");
		}
	}

}
