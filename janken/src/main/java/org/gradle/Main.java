package org.gradle;

/**
 * ジャンケンゲームを実行する
 * @author takaaki_yuki
 *
 */
public class Main {
	/**
	 * ジャンケンゲームメイン
	 * @param args 未使用
	 */
	public static void main(String[] args) {

		JankenStrategy strategy=new RandomStrategy();
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(strategy);

		Output out = new SystemOutputString();
		out.outputString("ジャンケンゲームを始めます");

		janken.playGame();

		out.outputString("プログラムを終了します。");


	}
}
