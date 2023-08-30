package com.data;

/**
 * Utility class to create a reference ID, can be used for anything
 * @author nurali
 *
 */
public class UtilID {
	
	private String alpha ="";
	
	
	
	UtilID(){
		
	}

	/**
	 * make a reference ID
	 * @return String
	 */
	public static String makeID() {
		String refid = "";
		for(int i=1; i<=4; i++) {
			int num =(int) (Math.random() * 10);
			String nums = Integer.toString(num);
			refid += nums;
		}
		
		for(int i =1; i <= 4; i++) {
			char c = (char)(Math.random() * 26 + 'a');
			//System.out.println(c);
			refid += c;
		}
		System.out.println("size: " + refid.length());
		System.out.println("::" + refid);
		
		return refid;
	}
	
	public static String makeTicketID() {
		String refid = "";
		// 6 digit number
		for(int i=1; i<=6; i++) {
			int num =(int) (Math.random() * 10);
			String nums = Integer.toString(num);
			refid += nums;
		}
		
		//Integer number = Integer.valueOf(refid);
		//int x = number.intValue();
		
		return refid;
	}
	
	
	public static String makeTicketID(int value) {
		String refid = "";
		// 6 digit number
		for(int i=1; i<=value; i++) {
			int num =(int) (Math.random() * 10);
			String nums = Integer.toString(num);
			refid += nums;
		}
		
		//Integer number = Integer.valueOf(refid);
		//int x = number.intValue();
		
		return refid;
	}
	
}
