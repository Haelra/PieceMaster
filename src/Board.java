// Copyright (c) 2012 Christian Kollross

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

// imcs.svcs.cs.pdx.edu:3589

public class Board {

	private char[][] board = new char[6][5];

	private int moveNum = -1;

	private char onMove = '?';

	private String ls = "\n"; // line separator

	public Board() {
		String intialSetup = "1 W" + ls + "kqbnr" + ls + "ppppp" + ls + "....."
				+ ls + "....." + ls + "PPPPP" + ls + "RNBQK";
		setBoard(intialSetup);
	}

	public Board(String input) {
		setBoard(input);
	}

	public void setBoard(String input) {
		String[] lines = input.split(ls);
		assert (lines.length == 7);

		// Process first line
		String firstLine = lines[0];
		String moveNumText = firstLine.split(" ")[0];
		moveNum = Integer.parseInt(moveNumText);
		for (int i = 0; i < firstLine.length(); i++) {
			if (firstLine.charAt(i) == 'W' || firstLine.charAt(i) == 'B')
				onMove = firstLine.charAt(i);
		}

		// Process board
		String line;
		for (int l = 1; l < 7; l++) {
			line = lines[l];
			for (int i = 0; i < 5; i++) {
				this.board[l - 1][i] = line.charAt(i);
			}
		}
		assert(moveNum > 0 && moveNum <= 40);
		assert (onMove == 'B' || onMove == 'W');
	}

	public Board(InputStream is) throws IOException {
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String read = br.readLine();

		while(read != null) {
		    System.out.println(read);
		    read = br.readLine();
		}
		setBoard(read);
	}

	public String toString() {
		String output = moveNum + " " + onMove + ls;
		for (int l = 0; l < 6; l++) {
			for (int i = 0; i < 5; i++) {
				output += (char) this.board[l][i];
			}
			output += ls;
		}
		return output;
	}

	public void print(OutputStream os) {

	}

}
