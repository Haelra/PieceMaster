// Copyright (c) 2012 Michael Freymueller
public class Move {
	 /*New class Move
     * public Square fields "from", "to"
     * Constructor "Move(String)"
     * Method "toString()"
   * "Board.move(Move)" */
	public Move(String move) {
		// Add method "Board.move(String)" that takes a string of the form "a5-b4"
		move.charAt(0);
		
	}
	public Move(Square from, Square to) {
		//that moves the piece at the first argument to the location at the
	    //second.  For now, no checks are done.  Make sure to
	    //update side and move number.
		
	}
	
	public String toString() {
		return "";
	}
}

