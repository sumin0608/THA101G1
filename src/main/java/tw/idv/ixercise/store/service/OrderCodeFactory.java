package tw.idv.ixercise.store.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class OrderCodeFactory {
    /** 訂單類別頭 */
    private static final String ORDER_CODE = "1";
    
    private static final int[] r = new int[]{7, 9, 6, 2, 8 , 1, 3, 0, 5, 4};
    /** 用戶id和隨機數總長度 */
    private static final int maxLength = 5;
    
    
//    public static void main(String[] args) {
//    	OrderCodeFactory fc = new OrderCodeFactory();
//    	String a = fc.getOrderCode(1L);
//    	System.out.println("P"+a);
//    }
    /**
     * 更具id進行加密+加隨機數組成固定長度編碼
     */
    private static String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1 ; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i)-'0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }
     
    /**
     * 生成時間戳
     */
    /*private static String getDateTime(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }*/
    
    /**
     * 生成固定長度隨機碼
     * @param n    長度
     */
    private static long getRandom(long n) {
        long min = 1,max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min ;
        return rangeLong;
    }
    
    /**
     * 生成不帶類別標頭的編碼
     * @param userId
     */
    private static synchronized String getCode(Long userId){
        userId = userId == null ? 10000 : userId;
        return toCode(userId);
    }
    
    /**
     * 生成訂單單號編碼
     * @param userId
     */
    public static String getOrderCode(Long userId){
        return ORDER_CODE + getCode(userId);
    }
    
}