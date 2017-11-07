package oracle.apps.match;

public class KMP {
    public KMP() {
        super();
    }

    public static void main(String args[]){

        String str = "abacadabrabracabracadabrabrabracad";
        String pattern = "abracadabra";
        String temp ="";
        String pmatch = "";
        String jjj = "";
        int i = 0;
        int x=0;
        for(int j = 0; j<pattern.length();){
            char s = str.charAt(i);
            char p = pattern.charAt(j);
            //System.out.println(s+"=="+p);
            x++;
            if(p == s){
                j++;
                temp = temp+p;
                pmatch=pmatch +","+ i;
                if(temp.equals(pattern)){
                    String[] firstTwo = pmatch.split(",");
                    System.out.println("\nFound at "+firstTwo[1] +"-"+firstTwo[firstTwo.length-1]);
                    j=0;
                    i = Integer.valueOf(firstTwo[1]);
                    temp="";
                    pmatch="";
                }
            }
            else{
                temp = "";
                pmatch="";
                j=0;
            }
            i++;
            if(i == str.length()){
                break;
            }
            //System.out.print(i+" ");
            jjj = jjj + j +" ";
        }
        //System.out.println(jjj);
        System.out.println("No of comparisons :: "+x);

    }
}
