package enums;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WinLoseTypeTest {

	@Test
	public void LOSEのgetWinLoseNumで0が返却されること() {
		// Exercise
		int actual = WinLoseType.LOSE.getWinLoseNum();
		// Verify
		assertThat(actual, is(0));
	}

	@Test
	public void DRAWのgetWinLoseNumで1が返却されること() {
		// Exercise
		int actual = WinLoseType.DRAW.getWinLoseNum();
		// Verify
		assertThat(actual, is(1));
	}

	@Test
	public void WINのgetMessageで2が返却されること() {
		// Exercise
		int actual = WinLoseType.WIN.getWinLoseNum();
		// Verify
		assertThat(actual, is(2));
	}

	@Test
	public void LOSEのgetMessageであなたの負けですが返却されること() {
		// Exercise
		String actual = WinLoseType.LOSE.getMessage();
		// Verify
		assertThat(actual, is("あなたの負けです。"));
	}

	@Test
	public void DRAWのgetMessageで引き分けですが返却されること() {
		// Exercise
		String actual = WinLoseType.DRAW.getMessage();
		// Verify
		assertThat(actual, is("引き分けです。"));
	}

	@Test
	public void WINのgetMessageであなたの勝ちですが返却されること() {
		// Exercise
		String actual = WinLoseType.WIN.getMessage();
		// Verify
		assertThat(actual, is("あなたの勝ちです。"));
	}

	@Test
	public void getWinLoseの引数に数字0を渡すとLOSEのインスタンスが返却されること() {

		// Setup
		int winLoseNum = 0;
		// Exercise
		WinLoseType actual = WinLoseType.getWinLose(winLoseNum);
		// Verify
		assertThat(actual, is(WinLoseType.LOSE));
	}

	@Test
	public void getWinLoseの引数に数字1を渡すとDRAWのインスタンスが返却されること() {

		// Setup
		int winLoseNum = 1;
		// Exercise
		WinLoseType actual = WinLoseType.getWinLose(winLoseNum);
		// Verify
		assertThat(actual, is(WinLoseType.DRAW));
	}

	@Test
	public void getWinLoseの引数に数字2を渡すとWINのインスタンスが返却されること() {

		// Setup
		int winLoseNum = 2;
		// Exercise
		WinLoseType actual = WinLoseType.getWinLose(winLoseNum);
		// Verify
		assertThat(actual, is(WinLoseType.WIN));
	}

}
