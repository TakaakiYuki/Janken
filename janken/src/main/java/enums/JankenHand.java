package enums;

import java.util.Arrays;


public enum JankenHand {
	/**
	 * グー
	 */
	GU(0, "グー"),
	/**
	 * チョキ
	 */
	CYOKI(1, "チョキ"),
	/**
	 * パー
	 */
	PA(2, "パー");

	/**
	 * 手の種類番号
	 */
	private int handNum;

	/**
	 * 手の名前
	 */
	private String handName;

	/**
	 * じゃんけんに使う手のコンストラクタ
	 *
	 * @param handNum
	 *            手の番号のインデックス
	 */
	private JankenHand(int handNum, String handName) {
		this.handNum = handNum;
		this.handName = handName;

	}

	/**
	 * じゃんけんの手を取得する
	 *
	 * @param handNum
	 *            じゃんけんの手の番号
	 * @return じゃんけんの手
	 */
	public static JankenHand getJankenHand(String handNum) {
//		for (JankenHand handType : JankenHand.values()) {
//			if (handNum.equals(Integer.toString(handType.handNum))) {
//				return handType;
//			}
//		}

		return Arrays.stream(values()).filter(hand -> Integer.toString(hand.handNum).equals(handNum)).findFirst().get();
		
	}

	/**
	 * じゃんけんの手を取得する
	 *
	 * @param handNum
	 *            じゃんけんの手の番号
	 * @return じゃんけんの手
	 */
	public static JankenHand getJankenHand(int handNum) {
//		for (JankenHand handType : JankenHand.values()) {
//			if (handNum == handType.handNum) {
//				return handType;
//			}
//		}
//		
		return Arrays.stream(values()).filter(hand -> (hand.handNum== handNum )).findFirst().get();
	}

	/**
	 * じゃんけんの手の種類番号取得
	 *
	 * @return じゃんけんの手の種類番号
	 */
	public int getHandNum() {
		return this.handNum;
	}

	/**
	 * じゃんけんの手の名前を取得する
	 *
	 * @param hand
	 *            じゃんけんの手
	 * @return じゃんけんの手の名前
	 */
	public String getHandName() {
		return this.handName;
	}
}
