import java.util.*;
public class Solution {
    static Map<String, String> bucket = new HashMap<String,String>();
    public static void main(String[] args) {
        Map<Long, String> hash = new HashMap();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String value = getHashValue(url);
        bucket.put(value,url);
        String hashedURL = "http://tinyurl.com/" + value;
        System.out.println(value);
        String decodedURL = decodeHashValue(value);
        System.out.println(bucket.get(value));
    }

    public static String getHashValue(String url){
        String map= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stb = new StringBuilder();
        int n = Math.abs(url.hashCode());
        while(n > 0){
            stb.append(map.charAt(n%62));
            n = n/62;
        }

        return stb.reverse().toString();
    }

    public static String decodeHashValue(String hash){
        int x=0;
        for(int i=0;i<hash.length();i++){
            char ch = hash.charAt(i);
            //x = x * 62 + hash.indexOf(ch);
             if(ch >= 'a' && ch <= 'z')
                 x = x*62 + ch-'a';
             if(ch >= 'A' && ch <= 'Z')
                 x = x*62 + ch-'A' + 26;
             if(ch >= '0' && ch <= '9')
                 x = x*62 + ch-'0' + 52;
        }
        return ""+x;
    }

}
