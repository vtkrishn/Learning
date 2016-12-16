package oracle.apps;


public class SearchMaze{


  public enum DIRECTION{
			LEFT,RIGHT,UP,DOWN;
	}

	static class Cell{

			int row;
			int column;
			int value;
			boolean visited;

			public Cell(int i, int j,int value){
				this.row = i;
				this.column = j;
				this.value = value;
			}

			public int getRow(){
				return row;
			}

			public int getColumn(){
				return column;
			}

			public int getValue(){
				return value;
			}
	}

	static class Board{

		//Cells for the maze
		Cell[][] cellArray;

		//method to create the maze with the array
		public void createMaze(int[][] array){
			int x = array.length;
			int y = array[0].length;

			//cell Array gets initialized with the size
			cellArray = new Cell[x][y];

			//populate the cell with the sample array
			for(int i=0;i<x;i++){
				for(int j=0;j<y;j++){
					//create a new cell
					Cell cell = new Cell(i,j,array[i][j]);
					//add the newly created cell to the cell array
					cellArray[i][j] = cell;
				}
			}

		}

		public boolean findWay(Cell current, Cell destination){

                        current.visited=true;
                        System.out.println("Row = " + current.getRow() + "/"+"Column ="+ current.getColumn() + "/"+"Value"+current.value);

                        if(current.getRow() == destination.getRow() && current.getColumn() == destination.getColumn() &&
				current.getValue() == destination.getValue()){
					return true;
				}

				//will be updated below - defaulting
				int nextValidRow = current.getRow();
				int nextValidColumn = current.getColumn();

				//if feasible then set the visited to true and then add it to stack and update the cell
				if(isFeasible(current,DIRECTION.DOWN) && current.getRow() != destination.getRow())
                                        nextValidRow =  current.getRow() + 1;
				else if(isFeasible(current,DIRECTION.LEFT) && current.getColumn() != destination.getColumn())
					nextValidColumn = current.getColumn() - 1;
                                else if(isFeasible(current,DIRECTION.RIGHT) && current.getColumn() != destination.getColumn())
					nextValidColumn = current.getColumn() + 1;
                                else if(isFeasible(current,DIRECTION.UP) && current.getRow() != destination.getRow())
                                        nextValidRow = current.getRow() - 1;


                        Cell nextValidCell = findCell(nextValidRow,nextValidColumn);
        		if(nextValidCell != null && !nextValidCell.visited){
        			return findWay(nextValidCell, destination);
        		}

                        return false;
        	}


		//return the cell objection for the row and column
		public Cell findCell(int i, int j){
        	return cellArray[i][j];
		}

		//is it possible to go in the direction specified
		private boolean isFeasible(Cell cell, DIRECTION direction){
			int row = cell.getRow();
			int column = cell.getColumn();
			boolean flag = false;
			//out of bounds check
			if(row < 0 || column < 0 || row > cellArray.length || column > cellArray[0].length)
				return false;

			//navigation check
			if(direction == DIRECTION.DOWN){
				if(row + 1 < cellArray.length)
					flag = isCellValid(row + 1 , cellArray.length, cellArray[row + 1][column].value);
			}
			else if(direction == DIRECTION.UP){
				if(row - 1 > 0)
					flag = isCellValid(row - 1 , cellArray.length, cellArray[row - 1][column].value);
			}
			else if(direction == DIRECTION.LEFT){
				if(column - 1 > 0)
					flag = isCellValid(column , cellArray[0].length, cellArray[row][column-1].value);
			}
			else if(direction == DIRECTION.RIGHT){
				if(column + 1 < cellArray[0].length)
					flag = isCellValid(column , cellArray[0].length, cellArray[row][column+1].value);
			}

    		return flag;
		}


        //check if the cell is valid or not
        private boolean isCellValid(int index, int length, int value){
            return (index < length && value != 1);
        }

    }
	//handler main method
	public static void main(String[] args){
		Board board = new Board();

		int[][] array =                 {{0,0,1},
						                        {0,1,0},
						                        {0,0,1}};
		board.createMaze(array);

		Cell destination = board.findCell(1,2);

	    int x = array.length;
	    int y = array[0].length;

            boolean flag = false;
	    for(int i=0;i<x;i++){
	            for(int j=0;j<y;j++){
	                Cell source = board.findCell(i,j);
	                if(!source.visited && source.value != 1)
                            flag = board.findWay(source,destination);
                        if(flag){
                                System.out.println("PATH FOUND from : " + i +":"+j+" to destination "+destination.getRow()+":"+destination.getColumn());
                                return;
                        }
                        else{
                            //System.out.println("PATH NOT FOUND for : " + i +":"+j);
                        }
	            }
	    }
	}

}
