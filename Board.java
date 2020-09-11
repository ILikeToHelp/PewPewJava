public class Board {

	private static Square [][] board = new Square[9][9];

	public Board(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square(i,j);
		}
	}

	public void printBoard(){
		System.out.print("\n  a b c d e f g h i\n");
		System.out.print(" -------------------  \n");

		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && board[i][j].hasSoldier())
						System.out.print(row+" "+board[i][j].getSoldier().getSymbol());
					else if ((j==0) && !board[i][j].hasSoldier())
						System.out.print(row+"  " );
					else if (board[i][j].hasSoldier())
						System.out.print("|"+board[i][j].getSoldier().getSymbol());
					else
						System.out.print("| ");
				}
				System.out.print(" "+row+"\n");
		}
		System.out.print(" -------------------  ");
		System.out.print("\n  a b c d e f g h i\n");

	}

	public boolean moveSoldier(int i0, int j0, int i1, int j1, Soldier s){
		board[i0][j0].removeSoldier();
		// if(board[i1][j1].hasSoldier()){
		// 	if(board[i1][j1].getSoldier().getSymbol() == "\u2654" ||
		// 			board[i1][j1].getSoldier().getSymbol() == "\u265A"  )
		// 			{
		// 				return true;
		// 			}
    //     }
	setSoldier(i1, j1, s);
	printBoard();
	return false;
}

public void setSoldier(int i, int j, Soldier s){
  board[i][j].setSoldier(s);
}
public Soldier getSoldier(int i, int j){
  return board[i][j].getSoldier();
}
public boolean hasSoldier(int i, int j){
  return board[i][j].hasSoldier();
}
	public static Square[][] getBoard(){
		return board;
	}

}
