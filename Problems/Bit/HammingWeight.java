//order of O(n) where n is the integer bit length for java its 32
public static int getCount(char c){
     //have a mask
     int mask = 1;

     //int x = c;
     int x = 2147483647;

     //bit counter
     int bitCount = 0;

     //mask will run upto integer length ie 32 in java

     while(mask > 0){
         // bit or with 1 at the specific bit will get the same number
         if((x | mask) == x){
             bitCount++;
         }
         //left shift
         mask = mask << 1;
     }


// Order of O(n) - number of bit set
        int x = (int) c;
		int bitCount = 0;
		while(x > 0) {
			//subtracting only 1 changes the right most bit to 1 to 0 or 0 to 1.
			x = x & (x - 1);
			bitCount++;
		}

//Order of O(1)
    int x = (int) c;
		x = (x & 0x55) + (x >> 1) & 0x55;
		x = (x & 0x33) + (x >> 2) & 0x33;
		x = (x & 0x0F) + (x >> 4) & 0x0F;
		return x;

  return bitCount;
}
