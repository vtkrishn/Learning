package javaproject.string;

public class ProductOfString {
    public ProductOfString() {
        super();
    }
    
    public static void main(String[] args){
        System.out.println(productOfString("2","3"));
    }
    
    private static String productOfString(String s1, String s2){
       //base case not null for both
       if(s1 == null || s2 == null)
           return null;
       //call string to convert to integer
       long l1 = convertToInteger(s1);
       long l2 = convertToInteger(s2);
       
       return convertToString(l1 * l2);
    }

    private static String convertToString(long value){ //12456
        long mod;
        long n = value;
        StringBuilder stb = new StringBuilder();
        while(n > 0){
            mod = n % 10;
            n = n / 10;
            stb.append(mod);
        }
        return stb.reverse().toString();
    }

    private static long convertToInteger(String s){ //1234
        int  value = 0;
        int j = 0;
        for(int i = s.length()-1;i>0;i--){ 
            char c = s.charAt(i); //4
            if(c >= '0' || c<='9'){
                if(value == 0)
                    value = Math.abs(48 - c);
                else
                    value = value + (int)(Math.pow(10, j) * Math.abs(48 - c));
                j++;
            }
        }
        return value;
    }
}
