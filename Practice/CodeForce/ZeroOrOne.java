public class Main{
    public static void main(String[] args){
            String[] value = {"0","0","1"};
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            int c = Integer.parseInt(value[2]);
            int sum =  a + b + c;
            if(sum == 3 || sum == 0)
              System.out.println("*");
            else if(sum == 2)
              System.out.println(sum - a == sum ? "A" : (sum - b == sum ? "B" : "C"));
            else if(sum == 1)
              System.out.println(sum - a == 0 ? "A" : (sum - b == 0 ? "B" : "C"));
    }
}
