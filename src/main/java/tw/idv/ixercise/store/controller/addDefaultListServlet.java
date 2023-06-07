package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.dao.implProduct;
import tw.idv.ixercise.store.entity.member;
import tw.idv.ixercise.store.entity.porder;
import tw.idv.ixercise.store.entity.product;


@WebServlet("/addDefaultListServlet")
public class addDefaultListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addDefaultListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<porder> l=(List)session.getAttribute("L");
		
		product pr = (product)session.getAttribute("P");
		
		member m=(member)session.getAttribute("Member");
		
		
		//porder p=new porder("p001",m.getMember_no(),m.getName(),pr.getProductName(),1,m.getUsername(),m.getEmail());
		porder p=new porder("p001","P001",m.getName(),pr.getProductName(),1,m.getUsername(),m.getEmail());
		l.add(p);
		
		
		//HttpSession session=request.getSession();
		//product pd = (product)session.getAttribute("P");
		//List<product> pr = (List)session.getAttribute("L");
		 //pr.add(pd);
		
		//response.sendRedirect("pageV5.jsp");
		request.setCharacterEncoding("UTF-8");
		
		String name=(String)session.getAttribute("buyProductName");
		
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
