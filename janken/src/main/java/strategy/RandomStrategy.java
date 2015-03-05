package strategy;

import java.util.Random;

import enums.JankenHand;

/**
 * じゃんけんで出す手を乱数によって決定する
 *
 * @author takaaki_yuki
 *
 */
public class RandomStrategy implements JankenStrategy {


	/**
	 * 乱数によりじゃんけんの手を決定する
	 */
	public JankenHand execute() {
		//じゃんけんの手のパターン数を最大値に乱数を生成
		return JankenHand.getJankenHand(new Random().nextInt(JankenHand.values().length));
	}
}
