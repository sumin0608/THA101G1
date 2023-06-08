package tw.idv.ixercise.report.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.idv.ixercise.report.entity.Message;
import tw.idv.ixercise.report.entity.ResultMessage;

public class MessageUtil {

	 
	
	public static String getMessage(boolean isSystemMessage,Integer memberId,Object message ) {
		
		try {
			ResultMessage result = new ResultMessage();
			result.setisSystem(isSystemMessage);
			result.setMessage(message);
			if(memberId!=null) {
				result.setMemberId(memberId);
			}
			ObjectMapper mapper= new ObjectMapper();
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		return null;
	    
	    
	}
	
	
	
	
}
