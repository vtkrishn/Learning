package javaproject.graph;

public class Jumble {
    public Jumble() {
        super();
    }
    
    public static void main(String[] args){
        char[] s = "vinod".toCharArray();
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]);
            for(int j=0;j<s.length;j++){
                if(s[i] != s[j])
                    System.out.print(s[j]);
            }
            //jumble(s,i);
            System.out.println("");
        }
    }
    
    public static void jumble(char[] s,int i){
        if(i == s.length)
            return;
        System.out.print(s[i]);
        jumble(s, i+1);
    }
}
