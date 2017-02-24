public static String reverseIntegerReturnAsString(int value){

        if(value < Integer.MIN_VALUE || value > Integer.MAX_VALUE){
            return "overflow";
        }
        int sign = 1;
        if (value < 1){
            sign = -1;
        }

        int x = sign * value;
        int digits = (int)Math.log10(x) + 1;

        int i = 0;
        if(sign < 0){
            digits++;
        }

        char[] ch = new char[digits];

        while(x >= 1){
            //ch[--digits] = (char)(48 + (x % 10));
            ch[i++] = (char)(48 + (x % 10));
            x = x / 10;
        }

        if(sign < 0){
            ch[i] = '-';
        }
        return new String(ch);
}
