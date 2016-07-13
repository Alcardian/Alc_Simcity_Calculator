package org.alcardian.simcity.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlcardianToolBox {

	public static ArrayList<String> readFile(String fileName)
			throws FileNotFoundException {
		ArrayList<String> buffer = new ArrayList<String>(); // an ArrayList to
															// hold the text
															// from the file.
		Scanner sc; // scanner, for read from file

		sc = new Scanner(new File(fileName));
		while (sc.hasNext()) { // While there is another line.
			buffer.add(sc.nextLine()); // Save the line to next slot in the
										// ArrayList
		}
		sc.close(); // close the scanner to prevent a leak.

		return buffer; // return the data from the file
	}

	/**
	 * Checks an entire string to make sure it's just numbers,and - symbols.
	 * returns false if anyting else is found.
	 * 
	 * @param number
	 * @param wantDouble
	 *            if this is true it will return double numbers as true, else it
	 *            will count it as false.
	 * @return
	 */
	public static boolean isNumber(String number, boolean wantDouble) {
		boolean a = true;
		int dotCount = 0;
		char temp;
		for (int b = 0; b < number.length(); b++) {
			temp = number.charAt(b);
			if (temp == '0' || temp == '1' || temp == '2' || temp == '3'
					|| temp == '4' || temp == '5' || temp == '6' || temp == '7'
					|| temp == '8' || temp == '9' || temp == '-') {

			} else if (wantDouble && (temp == '.') && dotCount == 0) {
				dotCount++;
			} else {
				a = false; // false if it is not a number
			}
		}
		return a;
	}
}
