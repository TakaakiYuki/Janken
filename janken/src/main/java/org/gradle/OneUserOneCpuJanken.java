package org.gradle;

import io.Input;
import io.LineInput;
import io.Output;

import java.util.NoSuchElementException;

import strategy.JankenStrategy;
import enums.JankenHand;
import enums.WinLoseType;

/**
 * CPU相手にじゃんけんを行う
 * 
 * @author takaaki_yuki
 *
 */
public class OneUserOneCpuJanken implements Janken {

	private JankenStrategy strategy;
	private Output out;
	private JankenPlayer user;
	private JankenPlayer cpu;
	private WinLoseType winLoseType;

	/**
	 * コンストラクタ
	 * 
	 * @param out　出力先
	 * @param strategy CPUの戦略
	 */
	public OneUserOneCpuJanken(final Output out, final JankenStrategy strategy) {
		this.out = out;
		this.strategy = strategy;
	}

	@Override
	public WinLoseType battleResult() {

		return WinLoseType
				.getWinLose((this.cpu.getHand().getHandNum() + 4 - this.user
						.getHand().getHandNum()) % 3);
	}

	/**
	 * ジャンケンゲームを1回行う
	 */
	@Override
	public void playGame() {
		try {
			// ユーザーにじゃんけんで出す手を選ばせる
			String input = this.inputUserHand();
			// ユーザーを設定する
			this.user = this.createPlayer(input);
			// CPUを設定する
			this.cpu = this.createPlayer();
			// 勝敗判定
			this.winLoseType = this.battleResult();
			// 結果の出力
			this.outputResult();
		} catch (NullPointerException | NoSuchElementException e) {
			((Throwable) e).printStackTrace();
		} catch (Exception e) {
			((Throwable) e).printStackTrace();
		}
	}

	/**
	 * じゃんけんの結果を出力する。
	 */
	private void outputResult() {
		this.out.outputString("あなたの手は：\t" + this.user.getHand().getHandName());
		this.out.outputString("CPUの手は：\t" + this.cpu.getHand().getHandName());
		this.out.outputString(this.winLoseType.getMessage());
	}

	/**
	 * CPUプレイヤーを作成する
	 * 
	 * @return CPUプレイヤー
	 * @throws Exception 戦略作成時例外
	 */
	private JankenPlayer createPlayer() throws Exception {
		return JankenPlayer.getInstance(this.strategy.execute());
	}

	/**
	 * ユーザープレイヤーを作る
	 * 
	 * @param input じゃんけんの手の番号
	 * @return ユーザープレイヤー
	 */
	private JankenPlayer createPlayer(final String input) {
		JankenHand userHand = JankenHand.getJankenHand(input);
		return JankenPlayer.getInstance(userHand);

	}

	/**
	 * ユーザーにじゃんけんの手を表す番号を入力してもらう
	 * 
	 * @return　入力されたジャンケンの手の番号
	 */
	private String inputUserHand() {
		this.out.outputString(JankenHand.GU.getHandName() + ":"
				+ JankenHand.GU.getHandNum() + "  "
				+ JankenHand.CYOKI.getHandName() + ":"
				+ JankenHand.CYOKI.getHandNum() + "  "
				+ JankenHand.PA.getHandName() + ":"
				+ JankenHand.PA.getHandNum() + "のどれかの数字を入力してください。");
		Input lineInput = new LineInput();
		String input = lineInput.getInputString();
		return input;
	}
}