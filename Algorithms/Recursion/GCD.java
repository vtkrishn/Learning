public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int x = 1701;
        int y = 3768;

        //int q = 0, r = 1;
        //while(r > 0){
         //   q = (max / min);
         //   r = (max % min);
         //   max = min * q + r;
         //   max = min;
         //   if(r != 0)
          //      min = r;
          //  else
           //     break;
        //}

        System.out.println(gcd(x,y,1));
    }

    public static int gcd(int x, int y, int r){
        r = y % x;
        if(r == 0)
           return x;
        y = x;
        return gcd(r,y,r);
    }
