import java.util.*;
public class YourClassNameHere {
    public static void main(String[] args) {
        calculate();
    }

    public static void calculate(){
      int sum = 0;
      List<Integer> dp = new ArrayList<Integer>();
      dp.add(1);
      dp.add(1);
	  int start = 0;
	  int end = 0;
      for(int j = 0; j<4;j++){
			if(j == 0){
				start = 2;
				end = 10;
			}
			else{
				start = end+1;
				end = end + 10;
				if(end > 32)
				  end = 32;
			}

			for(int i=start;i<=end;i++){
				dp.add(dp.get(i-1) + dp.get(i-2));
				System.out.println(dp.get(i));
				if(dp.get(i) % 2 == 0)
					sum += dp.get(i);
			}
	  }

      System.out.println(sum);
    }
}
//4613732
