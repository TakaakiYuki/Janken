package org.gradle;

import java.util.NoSuchElementException;

/**
 * CPU相手にじゃんけんを行う
 * @author takaaki_yuki
 *
 */
public class OneUserOneCpuJanken implements Janken {

	private JankenStrategy strategy;

	OneUserOneCpuJanken(JankenStrategy strategy){
		this.strategy=strategy;
	}

	public WinLoseType battleResult(JankenPlayer user, JankenPlayer cpu) {

		return WinLoseType.getWinLose((cpu.getHand().getHandNum() + 4 - user
				.getHand().getHandNum()) % 3);
	}

	/**
	 * ジャンケンゲームを1回行う
	 */
	public void playGame() {
		Output out = new SystemOutputString();
		out.outputString(JankenHand.GU.getHandName() +":" + JankenHand.GU.getHandNum() +"  "+ JankenHand.CYOKI.getHandName()+ ":"
				+ JankenHand.CYOKI.getHandNum() +"  "+ JankenHand.PA.getHandName()+":"
				+ JankenHand.PA.getHandNum() + "のどれかの数字を入力してください。");
		Input lineInput = new LineInput();
		String input = lineInput.getInputString();

		try {
			JankenHand userHand = JankenHand.getJankenHand(input);
			JankenPlayer user = JankenPlayer.getInstance(userHand);

			if (user == null) {
				out.outputString(JankenHand.GU.getHandName() +":" + JankenHand.GU.getHandNum() +"  "+ JankenHand.CYOKI.getHandName()+ ":"
						+ JankenHand.CYOKI.getHandNum() +"  "+ JankenHand.PA.getHandName()+":"
						+ JankenHand.PA.getHandNum() + "のどれかの数字を入力してください。");
				return;
			}

			JankenPlayer cpu = JankenPlayer.getInstance(this.strategy.execute());

			out.outputString("あなたの手は：\t" + user.getHand().getHandName());

			// strategyで実装する必要あり
			out.outputString("CPUの手は：\t" + cpu.getHand().getHandName());
			WinLoseType winLoseType = battleResult(user, cpu);

			out.outputString(winLoseType.getMessage());
		} catch (NullPointerException | NoSuchElementException e) {
			((Throwable) e).printStackTrace();
		}
	}

}