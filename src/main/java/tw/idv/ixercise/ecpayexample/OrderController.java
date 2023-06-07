package tw.idv.ixercise.ecpayexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/ecpayCheckout")
	public String ecpayCheckout() {
		String aioCheckOutALLForm = orderService.ecpayCheckout();
		return aioCheckOutALLForm;
	}

	@GetMapping("/ecpayReturnURL")
	public String ecpayReturnURL() {
		String ReturnURL = "回傳ecpayReturnURL";

		return ReturnURL;
	}
}
