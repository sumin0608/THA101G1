package tw.idv.ixercise.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import tw.idv.ixercise.course.entity.TrainerCert;
import tw.idv.ixercise.course.service.TrainerCertService;

@WebServlet(value = "/getAllTrainerCertServlet", loadOnStartup = 1)
public class GetAllTrainerCertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	private TrainerCertService service;
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        ServletContext servletContext = getServletContext();
	        WebApplicationContext webApplicationContext = WebApplicationContextUtils
	                .getWebApplicationContext(servletContext);
	        service = webApplicationContext.getBean(TrainerCertService.class);
	    }
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();

		try {
			List<TrainerCert> getallList = service.getall();
			System.out.println("迴圈每筆列出");
			for (TrainerCert cert : getallList) {
				System.out.println(cert); // toString()已override
			}
			// html印出
			Gson gson = new Gson();
			String json = gson.toJson(getallList);
			out.print(json);
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("Error");
		} finally {
			out.close();
		}
	}
}
