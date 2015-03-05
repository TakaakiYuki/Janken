package org.gradle;

import io.Output;
import io.SystemOutputString;
import strategy.JankenStrategy;
import strategy.RandomStrategy;

/**
 * ジャンケンゲームを実行する
 * 
 * @author takaaki_yuki
 *
 */
public class Main {
	/**
	 * ジャンケンゲームメイン
	 * 
	 * @param args 未使用
	 */
	public static void main(final String[] args) {

		JankenStrategy strategy = new RandomStrategy();
		Output out = new SystemOutputString();
		out.outputString("ジャンケンゲームを始めます");
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();
		out.outputString("プログラムを終了します。");

	}
}
