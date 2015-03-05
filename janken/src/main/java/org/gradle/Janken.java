package org.gradle;

import enums.WinLoseType;

/**
 * ジャンケンのインターフェース
 * 
 * @author takaaki_yuki
 *
 */
public interface Janken {
	/**
	 * ジャンケンの勝敗を返すメソッド
	 * 
	 * @return
	 */
	WinLoseType battleResult();

	/**
	 * ジャンケンを行うメソッド
	 * 
	 */
	void playGame();

}
