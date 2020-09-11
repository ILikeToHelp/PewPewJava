package chess;

public class CheckInput {



	public boolean checkCoordinateValidity(String input){
		// Input consists of 2 characters - switch types.
		char[] inputArray;
		inputArray = input.toCharArray();

		if (inputArray.length != 2){
			return false;
		}
		// Then cast them into integers, so we can
		// make use of the functions setPiece getPiece etc.
		int j = (int) inputArray[0]- 49;
		int i = (int) inputArray[1]- 97;
		// return false if the resulting coordinates are
		//  outside the board size
		if (i < 0 | i > 7 | j < 0 | j > 7){
			return false;
		}
		return true;
	}
}
