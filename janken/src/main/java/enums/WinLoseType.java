package enums;

import java.util.Arrays;

public enum WinLoseType {
	/**
	 * 負け
	 */
	LOSE(0, "あなたの負けです。"),
	/**
	 * 引き分け
	 */
	DRAW(1, "引き分けです。"),
	/**
	 * 勝ち
	 */
	WIN(2, "あなたの勝ちです。");

	/**
	 * 結果のインデックス
	 */
	private int winLoseNum;
	/**
	 * 勝敗メッセージ
	 */
	private String message;

	/**
	 * 勝敗のコンストラクタ
	 *
	 * @param winLoseNum 勝敗番号
	 */
	private WinLoseType(final int winLoseNum, final String message) {
		this.winLoseNum = winLoseNum;
		this.message = message;
	}

	/**
	 * 番号と紐づいている勝敗タイプを取得する
	 * 
	 * @param resultNum 勝敗番号
	 * @return 勝敗タイプ
	 */
	public static WinLoseType getWinLose(final int winLoseNum) {
		// for (WinLoseType type : WinLoseType.values()) {
		// if (type.resultNum == winLoseNum) {
		// return type;
		// }
		// }
		return Arrays.stream(values())
				.filter(type -> (type.winLoseNum == winLoseNum)).findFirst()
				.get();
	}

	/**
	 * メッセージの取得
	 *
	 * @return メッセージ
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * 勝敗番号を取得する
	 * 
	 * @return 勝敗番号
	 */
	public int getWinLoseNum() {
		return this.winLoseNum;
	}
}
