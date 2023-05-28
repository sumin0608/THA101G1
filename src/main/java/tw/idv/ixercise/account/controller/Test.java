package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.dao.impl.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;

import java.util.List;

//@RequestMapping("/test")
@RestController
public class Test {

@Autowired
private AccountService service;

//	測試存取DB
//	請求http://localhost:8080/ixercise/t，會把1號會員的資料顯示在畫面上
//	@GetMapping("/t")
//	@ResponseBody
//	public String testrepo() {
//		System.out.println(dao.selectById(1));
//		System.out.println("1 done=================");
//		return dao.selectById(1).toString();
//	}

//	@ResponseBody
	@GetMapping("/trepo")
	public List<Account> test() {
		return service.findAll();
	}

//	測試JSP路徑 WEB-INF底下可以自行建立資料夾
//	起點是webapp
//	請求http://localhost:8080/ixercise/tj，會顯示account.jsp
//	@GetMapping("/tj")
//	public String tj() {
//		return "WEB-INF/account/account.jsp";
//	}
//
////	測試html路徑
////	從static開始打目錄就好了
////	請求http://localhost:8080/ixercise/AccountPage，會顯示AccountPage.html
//	@GetMapping("/AccountPage")
//	public String AccountPage() {
//		System.out.println("test");
//		return "Account/AccountPage";
//	}
}
