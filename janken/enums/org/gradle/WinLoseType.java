package org.gradle;

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
	private int resultNum;
	/**
	 * 勝敗メッセージ
	 */
	private String message;

	/**
	 * 勝敗のコンストラクタ
	 *
	 * @param winLoseNum
	 *            勝敗番号
	 */
	private WinLoseType(int winLoseNum ,String message) {
		this.resultNum = winLoseNum;
		this.message=message;
	}
	/**
	 * 番号と紐づいている勝敗タイプを取得する
	 * @param resultNum 勝敗番号
	 * @return 勝敗タイプ
	 */
	public static WinLoseType getWinLose(int winLoseNum) {
		for (WinLoseType type : WinLoseType.values()) {
			if (type.resultNum == winLoseNum) {
				return type;
			}
		}
		return null;
	}

	/**
	 * メッセージの取得
	 *
	 * @return メッセージ
	 */
	public String getMessage() {
		return message;
	}


}
