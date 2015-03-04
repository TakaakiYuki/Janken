package org.gradle;


/**
 * ジャンケンのインターフェース
 * @author takaaki_yuki
 *
 */
public interface Janken {
	/**
	 * ジャンケンの勝敗を返すメソッド
	 * @return
	 */
	public WinLoseType battleResult(JankenPlayer user,JankenPlayer cpu);

	/**
	 * ジャンケンを行うメソッド
	 */
	public void playGame();
}
