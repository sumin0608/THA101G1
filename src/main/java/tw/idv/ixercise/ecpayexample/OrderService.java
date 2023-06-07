package tw.idv.ixercise.ecpayexample;

import java.util.UUID;

import org.springframework.stereotype.Service;

import tw.idv.ixercise.ecpay.payment.integration.AllInOne;
import tw.idv.ixercise.ecpay.payment.integration.domain.AioCheckOutALL;
@Service
public class OrderService {

		public String ecpayCheckout() {
			
			String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
			System.out.println(uuId);
			
			AllInOne all = new AllInOne("");
			
			AioCheckOutALL obj = new AioCheckOutALL();
			obj.setMerchantTradeNo(uuId);
			obj.setMerchantTradeDate("2017/01/01 08:05:23");
			obj.setTotalAmount("50");
			obj.setTradeDesc("test Description1");
			obj.setItemName("TestItem1");
//	        // 商店轉跳網址 (Optional)
//	        obj.setClientBackURL("http://10.2.1.213:8080/ixercise/jimmy/Course_homePage.html");

			//交易結果回傳網址，只接受 https 開頭的網站，可以使用 ngrok	
//			obj.setReturnURL("http://211.23.128.214:5000");
//			obj.setReturnURL("https://  /ixercise/index.html");
//			obj.setOrderResultURL("http://10.2.1.213:8080/ixercise/jimmy/Course_homePage.html");
			obj.setNeedExtraPaidInfo("N");
			String form = all.aioCheckOut(obj, null);
			
			return form;
		}
}
