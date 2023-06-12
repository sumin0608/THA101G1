package tw.idv.ixercise.ecpayexample;

import java.util.UUID;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import tw.idv.ixercise.ecpay.payment.integration.AllInOne;
import tw.idv.ixercise.ecpay.payment.integration.domain.AioCheckOutALL;

@Service
public class OrderService {

	public String ecpayCheckout(String expectedPrice,  String description, String eventName) {

		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		System.out.println(uuId);

		AllInOne all = new AllInOne("");
		AioCheckOutALL obj = new AioCheckOutALL();

		obj.setMerchantTradeNo(uuId);

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDateTime = formatter.format(currentDate);
		obj.setMerchantTradeDate(formattedDateTime);
//			obj.setMerchantTradeDate("2017/01/01 08:05:23");

//		String expectedPrice =  coursePay.getFirst("expectedPrice");
//		System.out.println("expectedPrice:"+expectedPrice);
//		obj.setTotalAmount(expectedPrice);
//		obj.setTotalAmount("50");
		obj.setTotalAmount(expectedPrice);
		System.out.println("expectedPrice:" + expectedPrice);

//		String description = (String) coursePay.getFirst("description");
//		System.out.println("description:"+description);
//		obj.setTradeDesc(description);
		obj.setTradeDesc("test Description1");

//		String eventName = (String) coursePay.getFirst("eventName");
//		System.out.println("eventName:"+eventName);
		obj.setItemName(eventName);
//		obj.setItemName("TestItem1");

//	        // 商店轉跳網址 (Optional)
//	        obj.setClientBackURL("http://10.2.1.213:8080/ixercise/jimmy/Course_homePage.html");

		// 交易結果回傳網址，只接受 https 開頭的網站，可以使用 ngrok
//			obj.setReturnURL("http://211.23.128.214:5000"); //綠界範例
//			obj.setReturnURL("https://  /ixercise/index.html");
//			obj.setOrderResultURL("http://10.2.1.213:8080/ixercise/jimmy/course_intro_page.html");

		obj.setReturnURL("https://4a50-1-164-238-247.jp.ngrok.io/ecpayReturnURL");
		obj.setOrderResultURL("http://localhost:8080/ixercise/jimmy/Course_homePage.html");

		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);

		return form;
	}
}
