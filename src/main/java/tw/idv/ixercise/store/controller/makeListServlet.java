package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.entity.product;

@WebServlet("/makeListServlet")
public class makeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public makeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<product> pr = new ArrayList();
		HttpSession session=request.getSession();
		session.setAttribute("L",pr);
		
		response.sendRedirect("shop.jsp");
	}

}
