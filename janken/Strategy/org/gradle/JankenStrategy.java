package org.gradle;

/**
 * じゃんけんの戦略
 * @author takaaki_yuki
 *
 */
public interface JankenStrategy {
	/**
	 * じゃんけんで出す手を決定する
	 *
	 * @return じゃんけんで出す手
	 */
	public JankenHand execute();
}
