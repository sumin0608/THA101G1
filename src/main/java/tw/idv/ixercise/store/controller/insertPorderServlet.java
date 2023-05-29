package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		product p = (product)session.getAttribute("P");
		
		String porderNo = request.getParameter("porderNo");
		String num = request.getParameter("pamount");
		int amount = Integer.parseInt(num);
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		porder order = new porder(porderNo,"m003",name,p.getProductName(),amount,phone,email);
		new ImplPorder().insert(order);
		if(order!=null) {
			PrintWriter out = response.getWriter();
			out.println("Success");
		}
	}

}
