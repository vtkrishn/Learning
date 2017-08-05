package javaproject.dynamic;

public class Lex {
    public Lex() {
        super();
    }
    
    public static void main(String[] args){
        int total = 103;
        for(int i=100;i<=total;i++){
            System.out.println(i);
            lexi(i, total%10,total);
        }
    }
    
    public static void lexi(int val, int n,int total){
        if(val==0 || n < 10*val)
            return;
        for(int i=0;i<=n;i++){
            if(10 * val + i < total){
                System.out.println(10 * val + i);
                lexi(i, n%10,total);
            }
        }
    }
}
