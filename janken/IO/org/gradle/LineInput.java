package org.gradle;

import java.util.Scanner;

/**
 * 標準入力から1行分の文字列を取得する
 * @author takaaki_yuki
 *
 */
public class LineInput implements Input{
	/**
	 * 標準入力から1行分の文字列を取得する。
	 * @return 入力された文字列
	 */
	public String getInputString() {
		Scanner scan = new Scanner(System.in);
		String inputString = scan.next();
		scan.close();
		return inputString;
	}
}
