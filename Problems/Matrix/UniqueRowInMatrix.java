package javaproject;

/** Unique Row in Matrix **/
//--------------------------------------------
import java.util.*;
public class UniqueRow{
	public static void main(String[] args){
	    int[][] matrix1 = { { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
	                                    { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 1 },
	                                    { 1, 0, 0, 0, 1 } };
                int[][] array = {
		{1,0,1,0},
		{1,1,0,0},
		{1,0,1,0},
		{0,1,1,1}
		};
		printRow(uiqueRowInArray(matrix1));
	}

	static class TrieNode{
		TrieNode[] kids = null;
	}

    private static void printRow(int[][] array){
        for(int[] i : array){
            for(Integer j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
	private static int[][] uiqueRowInArray(int[][] array){
            int row = array.length;
            int column = array[0].length;

            TrieNode root = new TrieNode();
            TrieNode p;
            int uniqueCount = 0;
            boolean[] unique = new boolean[row];

            for(int i=0;i<row;i++){
                p = root;
                for(int j = 0;j<column;j++){
                    int digit = array[i][j];
                    if(p.kids == null)
                        p.kids = new TrieNode[2];

                    if(p.kids[digit] == null)
                        p.kids[digit] = new TrieNode();

                    if(j == column - 1){
                        uniqueCount++;
                        unique[i] = true;
                    }
                    p = p.kids[digit];
                }
            }
                int[][] result = new int[uniqueCount][];
                int k = 0;
                for (int w = 0; w < unique.length; w++) {
                    if (unique[w]) {
                            result[k++] = array[w];
                    }
                }
                return result;
        }
}
