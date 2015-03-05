package strategy;

import enums.JankenHand;

/**
 * じゃんけんの戦略
 * 
 * @author takaaki_yuki
 *
 */
@FunctionalInterface
public interface JankenStrategy {
	/**
	 * じゃんけんで出す手を決定する
	 *
	 * @return じゃんけんで出す手
	 * @throws Exception 発生した例外をスローする
	 */
	JankenHand execute() throws Exception;
}
