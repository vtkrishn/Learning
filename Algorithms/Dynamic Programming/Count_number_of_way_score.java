public class CountNumberOfWays {
    public CountNumberOfWays() {
        super();
    }

    public static void main(String[] args){
        int i;
        int n = 20;
        int[] table = new int[n+1];
        table[0] = 1;
            for (i=3; i<=n; i++)
               table[i] += table[i-3];
            for (i=5; i<=n; i++)
               table[i] += table[i-5];
            for (i=10; i<=n; i++)
               table[i] += table[i-10];

        System.out.println(table[n]);
    }

}
