package org.gradle;

import enums.JankenHand;


/**
 * ジャンケンのプレイヤー
 *
 * @author takaaki_yuki
 *
 */
public class JankenPlayer {
	/**
	 * じゃんけんの手のパターン
	 */
	private JankenHand hand;

	/**
	 * コンストラクタ
	 *
	 * @param hand
	 *            じゃんけんの手のパターン
	 */
	private JankenPlayer(JankenHand hand) {
		this.hand = hand;
	}

	/**
	 * じゃんけんのプレイヤーのインスタンスを返す
	 * @param jankenHand じゃんけんの手
	 * @return じゃんけんのプレイヤー
	 */
	public static JankenPlayer getInstance(JankenHand jankenHand){
		return new JankenPlayer(jankenHand);
	}
	/**
	 * 手のパターンを返す
	 *
	 * @return 手のパターン
	 */
	public JankenHand getHand() {
		return hand;
	}

	/**
	 * 手のパターンを設定する
	 *
	 * @param hand
	 */
	public void setHand(JankenHand hand) {
		this.hand = hand;
	}

}
