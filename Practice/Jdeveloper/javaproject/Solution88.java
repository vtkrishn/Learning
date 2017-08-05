package javaproject;

public class Solution88 {
    public Solution88() {
        super();
    }
    
    public static void main(String[] args){
        String[] str = {"ab12345yu"," ","569815571556", "4938532894754", "1234567", "472844278465445","12","76543210","12304567","1634616512"};
        int[] dp = new int[7];
            for(int i=0;i<str.length;i++){
                if(isValid(str[i]))
                    continue;
                else{
                    //int count=0;
                    int k = 0;
                    boolean skipped  = false;
                    for(int j=0;j<7;j++){
                            if(k+1<str[i].length()){
                            int ch = str[i].charAt(k)-48;
                            int append = (ch*10) + str[i].charAt(k+1)-48;
                              if(append > 10 && append < 59){
                                  dp[j] = append;
                              }
                              else{
                                  skipped=true;
                              }
                        }
                    }
                    if(!skipped)
                        System.out.println(str[i]);
                    else
                        dp = new int[7];
                }
            }
    }
    
    private static boolean isValid(String str){
        return str.length() > 14 || str.length() < 7 || !str.matches("[0-9]+");
    }
}
