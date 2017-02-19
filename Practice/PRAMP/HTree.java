class Pramp {
   public static void main(String[] args) {
      drawHLine(5,5,16,5);
   }
}

  private static void drawHLine(int x, int y,int length, int depth){
        int halfLength = length/2;
        int x1 = x-halfLength;
        int x2 = x+halfLength;
        int y1 = y;
        int y2 = y;
        int initX1 = x1;
        int initX2 = x2;
        int initY1 = y1;
        int initY2 = y2;

        if(depth == 0)
           return;

        //draw Horizontal line
        drawline(x1, y1, x2, y2);

        x1 = initX1;
        x2 = initX2;
        y1  =initY1+halfLength;
        y2 = initY1-halfLength;

        //draw left vertical line
        drawline(x1, y1, x2, y2);

        drawHLine(x1,y1,Math.sqrt(length),depth-1);   //left top
        drawHLine(x2,y2,Math.sqrt(length),depth-1);  //left bottom

        x1 = initX2;
        x2 = initX2;
        y1  =initY2+halfLength;
        y2 = initY2-halfLength;

        //draw right vertical line
        drawline(x1, y1, x2, y2);

        //recurse with reduced length and depth
        drawHLine(x1,y1,Math.sqrt(length),depth-1);  //right top
        drawHLine(x2,y2,Math.sqrt(length),depth-1);  //right bottom

  }

                  
