package tw.idv.ixercise.ecpayexample;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/ecpayCheckout")
	public String ecpayCheckout(@RequestParam("expectedPrice") String expectedPrice,  String description, String eventName) {
		System.out.println("抵達controller>>expectedPrice1:"+expectedPrice);
		System.out.println("抵達controller>>description1:"+description);
		System.out.println("抵達controller>>eventName1:"+eventName);

		String aioCheckOutALLForm = orderService.ecpayCheckout(expectedPrice);
		return aioCheckOutALLForm;
	}
	

}
