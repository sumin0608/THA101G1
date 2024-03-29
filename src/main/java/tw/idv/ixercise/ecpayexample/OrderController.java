package tw.idv.ixercise.ecpayexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/ecpayCheckout")
    public String ecpayCheckout(@RequestParam("expectedPrice") String expectedPrice, String description, String eventName) {
        System.out.println("抵達controller>>expectedPrice1:" + expectedPrice);
        System.out.println("抵達controller>>description1:" + description);
        System.out.println("抵達controller>>eventName1:" + eventName);

        String aioCheckOutALLForm = orderService.ecpayCheckout(expectedPrice, description, eventName);
        return aioCheckOutALLForm;
    }

    @PostMapping("/ecpayReturnURL")
    public String ecpayReturnURL(@RequestParam("MerchantTradeNo") String merchantTradeNo,
                                 @RequestParam("PaymentDate") String paymentDate,
                                 @RequestParam("PaymentType") String paymentType) {
//        public String ecpayReturnURL(HttpServletRequest request) {

//        String merchantTradeNo = request.getParameter("MerchantTradeNo");
//        String paymentDate = request.getParameter("PaymentDate");
//        String paymentType = request.getParameter("PaymentType");
        // 根據處理結果返回相應的頁面
        System.out.println("Credit card payment success");
        System.out.println("merchantTradeNo>>" + merchantTradeNo + "paymentDate>>" + paymentDate + "paymentType>>" + paymentType);
        return "1|OK";
    }

}
