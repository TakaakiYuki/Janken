package org.gradle;

/**
 * 出力インタフェース
 * @author takaaki_yuki
 *
 */
public interface Output {
	/**
	 * データの出力
	 * @param outStr 出力文字列
	 */
	public void outputString(String outStr);
}
