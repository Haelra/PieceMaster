// Copyright � 2012 Christian Kollross

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

// imcs.svcs.cs.pdx.edu:3589

public class Board {

	private char[][] board = new char[6][5];

	private int moveNum = 1;

	private char onMove = 'W';

	private String ls = "\n\r"; // line separator

	public Board() {
		String intialSetup = "1 W" + ls + "kqbnr" + ls + "ppppp" + ls + "....."
				+ ls + "....." + ls + "PPPPP" + ls + "RNBQK";
		new Board(intialSetup);
	}

	public Board(String input) {
		String[] lines = input.split(ls);

		// Process first line
		String firstLine = lines[0];
		String moveNumText = firstLine.split(" ")[0];
		moveNum = Integer.parseInt(moveNumText);
		for (int i = 0; i < firstLine.length(); i++) {
			if (firstLine.charAt(0) == 'W' || firstLine.charAt(0) == 'B')
				onMove = firstLine.charAt(0);
		}

		// Process board
		String line;
		for (int l = 1; l < 6; l++) {
			line = lines[l];
			for (int i = 0; i < 5; i++) {
				board[l - 1][i] = line.charAt(i);
			}
		}
	}

	public Board(InputStream is) {
		// InputStreamReader isr = new InputStreamReader(is);

	}

	public String toString() {
		String output = moveNum + " " + onMove + ls;
		for (int l = 0; l < 6; l++) {
			for (int i = 0; i < 5; i++) {
				output += board[l][i];
			}
			output += ls;
		}

		return output;
	}

	public void print(OutputStream os) {

	}
}
