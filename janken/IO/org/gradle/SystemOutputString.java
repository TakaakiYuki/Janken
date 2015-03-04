package org.gradle;

/**
 * 標準出力へ文字列を出力する
 * @author takaaki_yuki
 *
 */
public class SystemOutputString implements Output {
	/**
	 * 標準出力へ文字列を出力する
	 * @param outStr 出力する文字列
	 */
	public void outputString(String outStr){
		System.out.println(outStr);
	}
}
