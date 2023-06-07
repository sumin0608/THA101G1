package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.dao.ImplPorder;
import tw.idv.ixercise.store.entity.porder;
import tw.idv.ixercise.store.entity.product;

/**
 * Servlet implementation class insertPorderServlet
 */
@WebServlet("/insertPorderServlet")
public class insertPorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPorderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<porder> l=(List)session.getAttribute("L");
		
		
		for(porder p:l)
		{
			new ImplPorder().insert(p);
			
		}
		
		response.sendRedirect("Success.jsp");
	}

}
