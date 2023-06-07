package tw.idv.ixercise.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.dao.implMember;
import tw.idv.ixercise.store.entity.member;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		member m=new implMember().queryMember(username, password);
		HttpSession session=request.getSession();

		session.setAttribute("Member", m);
		response.sendRedirect("makeListServlet");

		System.out.println(username);
		System.out.println(password);
		System.out.println(m.getPassword());
	}

}
