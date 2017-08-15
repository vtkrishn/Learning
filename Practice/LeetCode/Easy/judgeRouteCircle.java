public class Solution {
    public boolean judgeCircle(String moves) {
        int count = 0;
        for(int i=0;i<moves.length();i++){
            char move = moves.charAt(i);
            if(move == 'U')
                count += 1;
            else if(move == 'D')
                count -= 1;
            else if(move == 'L')
                count += 2;
            else if(move == 'R')
                count -= 2;
        }
        return count == 0;
    }
}
