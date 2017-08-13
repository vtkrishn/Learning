import java.util.*;
public class YourClassNameHere {
    public static void main(String[] args) {
        char[][] pixels = {
          {'W','W','B'},
          {'W','B','W'},
          {'B','B','W'}
          };
        lonely(pixels);
    }

    public static int lonely(char[][] pixels) {
        int res = 0;
        int[] rowCount = new int[pixels.length];
        int[] colCount = new int[pixels[0].length];
        for(int i = 0;i<pixels.length;i++){
          for(int j = 0;j<pixels[0].length;j++){
            if(pixels[i][j] == 'B'){
                  ++rowCount[i];
                  ++colCount[j];
            }
          }
        }

        for(int i = 0;i<pixels.length;i++){
          for(int j = 0;j<pixels[0].length;j++){
            if(pixels[i][j] == 'B'){
                  if(rowCount[i] == 1 && colCount[j] == 1)
                    res++;
            }
          }
        }
        return res;
    }
}
