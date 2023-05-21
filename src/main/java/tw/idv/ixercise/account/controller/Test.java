package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.ixercise.account.dao.impl.AccountDaoImpl;

//@RequestMapping("/test")
@Controller
public class Test {
	@Autowired
	private AccountDaoImpl dao;

//	測試存取DB
//	請求http://localhost:8080/ixercise/t，會把1號會員的資料顯示在畫面上
	@GetMapping("/t")
	@ResponseBody
	public String test() {
		System.out.println(dao.selectById1(1));
		System.out.println("1 done=================");
		return dao.selectById1(1).toString();
	}
	
//	測試JSP路徑 WEB-INF底下可以自行建立資料夾
//	起點是webapp
//	請求http://localhost:8080/ixercise/tj，會顯示account.jsp
	@GetMapping("/tj")
	public String tj() {
		return "WEB-INF/account/account.jsp";
	}
	
//	測試html路徑
//	從static開始打目錄就好了
//	請求http://localhost:8080/ixercise/AccountPage，會顯示AccountPage.html
	@GetMapping("/AccountPage")
	public String AccountPage() {
		System.out.println("test"); 
		return "Account/AccountPage";
	}
}
