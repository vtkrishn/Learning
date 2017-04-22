package javaproject.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DominoProblem {
    public DominoProblem() {
        super();
    }
    /*

    Given a valid chain of domino tiles, determine if one more tile can be added to the chain.

    * New tile can be added to the front, back, or middle of the chain.
    * New tile can only be placed in a valid position, i.e. where it matches all adjacent tiles.
    * New tile can be flipped.

    * If the new tile can be added to the original chain in a valid position, return the modified chain.
    * If the new tile cannot be added to the original chain in a valid position, return the original chain.

    | Original Chain      | New Tile | Modified Chain             |
    |---------------------|----------|----------------------------|
    | [0|3]               | [3|4]    | [0|3]--[3|4]               |
    | [0|3]--[5|6]        | [1|0]    | [1|0]--[0|3]--[5|6]        |
    | [4|5]--[5|6]--[6|3] | [5|5]    | [4|5]--[5|5]--[5|6]--[6|3] |
    | [4|0]--[0|3]        | [2|3]    | [4|0]--[0|3]--[3|2]        |
    | [0|3]               | [5|6]    | [0|3]                      |
    | (empty chain)       | [1|5]    | [1|5]                      |

     */

    public static List attachTile(List<Domino> originalChain, Domino domino){
        List<Domino> newList = new ArrayList<Domino>();
        if(originalChain == null){
            newList.add(domino);
            return newList;
        }

        newList = originalChain;
        int size = originalChain.size();
        Deque<Domino> l = new ArrayDeque<Domino>();
        for(int i=0;i<size;i++){
          Domino temp = originalChain.get(i);
            if(temp.lower == domino.lower || temp.upper == domino.upper){
                domino.flip();
            }
            if(temp.lower == domino.upper){
                    newList.add(i+1, domino);
                    return newList;
            }

            if(temp.upper == domino.lower){
                if(i==0)
                    newList.add(i, domino);
                else
                    newList.add(i-1, domino);
                return newList;
            }

        }
        return newList;
    }

    public static void main(String[] args) {
        List<Domino> chain = new ArrayList<>();
        chain.add(new Domino(5,1));

        System.out.println(getScoreOfDominoChain(chain));

        chain = new ArrayList<>();
        chain.add(new Domino(3,5));
        chain.add(new Domino(5,5));
        chain.add(new Domino(5,1));

        System.out.println(getScoreOfDominoChain(chain));

        chain = new ArrayList<>();

        System.out.println(getScoreOfDominoChain(chain));

        chain = new ArrayList<>();
        chain.add(new Domino(3,5));
        chain.add(new Domino(6,1));

        System.out.println(getScoreOfDominoChain(chain));
        System.out.println(getScoreOfDominoChain(null));

          chain = new ArrayList<>();
          chain.add(new Domino(0,3));
        System.out.println(attachTile(chain, new Domino(5,6)));

          chain = new ArrayList<>();
          chain.add(new Domino(4,0));
          chain.add(new Domino(0,3));
          System.out.println(attachTile(chain, new Domino(2,3)));

          chain = new ArrayList<>();
          chain.add(new Domino(4,5));
          chain.add(new Domino(5,6));
          chain.add(new Domino(6,3));
          System.out.println(attachTile(chain, new Domino(5,5)));

          chain = new ArrayList<>();
          chain.add(new Domino(0,3));
          chain.add(new Domino(5,6));
          System.out.println(attachTile(chain, new Domino(1,0)));

          chain = new ArrayList<>();
          chain.add(new Domino(0,3));
          System.out.println(attachTile(chain, new Domino(3,4)));
      }

    public static int getScoreOfDominoChain(List<Domino> chain){

        int score = 0;
        if(chain == null)
          return 0;
        int size = chain.size();

        if(size == 0)
            return 0;

        if(chain.size() == 1) // 5/1 - 6
            return chain.get(0).getTotal();

      //[3|5|--[5|5]--[5|1]--[6|7]

        for(int i=1;i<size;i++){ //[2|4]--[4|5]--[5|6]
          Domino dom1 = chain.get(i);//[4|5] - 9 , [5|6]
          Domino dom2 = chain.get(i-1);//[2|4] - 6, [4|5]

          if(dom2.lower != dom1.upper)
              return -1;
          score = score + dom2.getTotal();
        }

        return score + chain.get(size-1).getTotal();
    }

    static class Domino{
        int upper;
        int lower;

        public Domino(int upperValue, int lowerValue){
          this.upper = upperValue;
          this.lower = lowerValue;
        }

        public int getTotal(){
          return this.upper + this.lower;
        }

        public void flip(){
            int temp = this.upper;
            this.upper = this.lower;
            this.lower = temp;
        }

        public String toString(){
            return "[" + this.upper +"|" + this.lower +"]";
        }
      }
}
