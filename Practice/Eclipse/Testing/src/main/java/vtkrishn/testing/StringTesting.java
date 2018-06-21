package vtkrishn.testing;

public class StringTesting {

	public static void main(String[] args){
		System.out.println("\"\"\"94567\" :: "+getAddressPostalCode("\"\"\"94567\"")[0]);
		System.out.println("\"\"\"94567 :: "+getAddressPostalCode("\"\"\"94567")[0]);
		System.out.println("94567\"\"\" :: "+getAddressPostalCode("94567\"\"\"")[0]);
		
		System.out.println("94567 :: "+getAddressPostalCode("94567")[0]); // 94567
		System.out.println("\"94567\" :: "+getAddressPostalCode("\"94567\"")[0]); // "94567"
        System.out.println("\"94567 :: "+getAddressPostalCode("\"94567")[0]); // "94567
        System.out.println("94567\" :: "+getAddressPostalCode("94567\"")[0]); // 94567"
        System.out.println("\"94567-\" :: "+getAddressPostalCode("\"94567-\"")[0]); // "94567-"
        System.out.println("94567-\" :: "+getAddressPostalCode("94567-\"")[0]); // 94567-"
        System.out.println("\"94567- :: "+getAddressPostalCode("\"94567-")[0]); // "94567-
        
        System.out.println("\"94567-94568\" :: "+getAddressPostalCode("\"94567-94568\"")[0]);  //
        System.out.println("94567-94568\" :: "+getAddressPostalCode("94567-94568\"")[0]);
        System.out.println("\"94567-94568 :: "+getAddressPostalCode("\"94567-94568")[0]);
        
        
//        System.out.println(getAddressPostalCode("\"\"\"\"9456"));
//        System.out.println(getAddressPostalCode("9456\"\"\""));
//        System.out.println(getAddressPostalCode("\"94\"\"\"56\""));
//        System.out.println(getAddressPostalCode("\"94\"\"-\"56\""));
    }
    
	static String[] check(String rawPostalCode) {
		String[] result = new String[2];
		
		//check if its having quotes
    	if(!rawPostalCode.contains("\"")) {
    		//the string does not have any quotes in it then return
    		return new String[]{rawPostalCode, null};
    	}
    	else {
    		int len = rawPostalCode.length();
    		boolean first = false;
    		boolean second = false;
    		int firstRepeat = 0;
    		int secondRepeat = 0;
    		//check where the quotes present
    		//first index
    		if(rawPostalCode.charAt(0) == '\"') {
    			first = true;
    		}
    		
    		//last index
    		if(rawPostalCode.charAt(len-1) == '\"') {
    			second = true;
    		}
    		
    		//in the middle
    			
    		
    		if(first) {
    			while(rawPostalCode.charAt(firstRepeat+1) == '\"')
    				firstRepeat++;
    		}
    		
    		if(second) {
    			while(rawPostalCode.charAt(len-1-secondRepeat) == '\"')
    				secondRepeat++;
    		}
    		
    		if(first == second) {
    			return new String[]{rawPostalCode.substring(1+firstRepeat, len-1-secondRepeat+1)};
    		}
    		else {
    			if(first)
    				return new String[]{rawPostalCode.substring(1+firstRepeat)};
    			
    			if(second)
    				return new String[]{rawPostalCode.substring(0,len-1-secondRepeat+1)};
    		}
    			

            
            result[0]=rawPostalCode;
            result[1]="";
            return result;
    	}
	}
    static String[] getAddressPostalCode(String rawPostalCode){
        //check if the string has - 
        if(!rawPostalCode.contains("-")) {
        	return check(rawPostalCode);
        }
        else {
        	String[] str = check(rawPostalCode);
        	str[0] = str[0].substring(0,str[0].indexOf("-"));
        	return str;
        }
        
    }
    
}
