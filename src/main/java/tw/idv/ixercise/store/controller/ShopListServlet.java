package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.entity.member;
import tw.idv.ixercise.store.entity.porder;
import tw.idv.ixercise.store.entity.product;

@WebServlet("/ShopListServlet")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShopListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		product p = (product)session.getAttribute("P");
		List<porder> l = (List)session.getAttribute("L");
		member m=(member)session.getAttribute("Member");
		
		String porderNo = request.getParameter("porderNo");
		String num = request.getParameter("pamount");
		int amount = Integer.parseInt(num);
		
		String address = request.getParameter("address");
		
		
		//porder order = new porder(porderNo,m.getMember_no(),m.getName(),p.getProductName(),amount,m.getPhone(),m.getEmail());
		porder order = new porder(porderNo,"P001",m.getName(),p.getProductName(),amount,m.getUsername(),m.getEmail());
		l.add(order);
		
		
		response.sendRedirect("PayWay.jsp");
		
	}

}
