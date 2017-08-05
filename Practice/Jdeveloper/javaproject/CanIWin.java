package javaproject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CanIWin {
    static Set<Integer> set  = new HashSet<Integer>();
    public CanIWin() {
        super();
    }
    
    public static void main(String[] args){
        int maxChoosable=10;    
        int target = 19;
        canIWin(maxChoosable,target);
    }
    
    
    private static void canIWin(int maxChoosable, int target){
            boolean player1 = false;
            for(int i=1;i<=maxChoosable;i++){
                    set.add(i);
                    //System.out.println("Player1 chose :: " + i);
                    if(player1 == canIWin(maxChoosable,target, i,player1))//player1 chose i, player is passed
                        System.out.println("Player1 can win ::" + i);
                   // else
                    //    System.out.println("Player1 cannot win");
                    set.remove(i);
                    
            }       
    }

    private static boolean canIWin(int maxChoosable, int target,int indexValue,boolean playerToggle){
            if(target <= 0 || indexValue > maxChoosable)
                    return playerToggle;
            int max = 0;
            for(int i=1;i<=maxChoosable;i++){
                    if(!set.contains(i))
                            max = Math.max(max,i);
            }
            //System.out.println("Max Value :: "+ max);
            if(target - max <= 0)
                    return playerToggle;
            for(int j=1;j<=maxChoosable;j++){
                    if(!set.contains(j)){
                            set.add(j);
                            boolean b = canIWin(maxChoosable,target-indexValue,j,!playerToggle);  
                            set.remove(j);
                            if(b == true)
                                return b;
                    }               
            }
            return playerToggle;
    }

}
