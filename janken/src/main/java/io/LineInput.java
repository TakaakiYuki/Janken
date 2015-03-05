package io;

import java.util.Scanner;

/**
 * 標準入力から1行分の文字列を取得する
 * 
 * @author takaaki_yuki
 *
 */
public class LineInput implements Input {
	/**
	 * 標準入力から1行分の文字列を取得する。
	 * 
	 * @return 入力された文字列
	 */
	@Override
	public String getInputString() {
		try (Scanner scan = new Scanner(System.in)) {
			String inputString = scan.next();
			return inputString;
		}
	}
}
