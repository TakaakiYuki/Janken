package org.gradle;


/**
 * ジャンケンのプレイヤー
 *
 * @author takaaki_yuki
 *
 */
public class JankenPlayer {
	/**
	 * 手のパターン
	 */
	private JankenHand hand;

	/**
	 * コンストラクタ
	 *
	 * @param hand
	 *            手のパターン
	 */
	private JankenPlayer(JankenHand hand) {
		this.hand = hand;
	}

	public static JankenPlayer getInstance(JankenHand jankenHand){
		if(jankenHand==null){
			return null;
		}
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
