package enums;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JankenHandTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// GU,CYOKI,PAそれぞれの値確認
	@Test
	public void GUのgetHandNumで0が返却されること() {

		// Exercise
		int actual = JankenHand.GU.getHandNum();
		// Verify
		assertThat(actual, is(0));
	}

	@Test
	public void CYOKIのgetHandNumで1が返却されること() {
		// Exercise
		int actual = JankenHand.CYOKI.getHandNum();
		// Verify
		assertThat(actual, is(1));
	}

	@Test
	public void PAのgetHandNumで2が返却されること() {
		// Exercise
		int actual = JankenHand.PA.getHandNum();
		// Verify
		assertThat(actual, is(2));

	}

	@Test
	public void GUのgetHandNameでグーが返却されること() {
		// Exercise
		String actual = JankenHand.GU.getHandName();
		// Verify
		assertThat(actual, is("グー"));
	}

	@Test
	public void CYOKIのgetHandNameでチョキが返却されること() {
		// Exercise
		String actual = JankenHand.CYOKI.getHandName();
		// Verify
		assertThat(actual, is("チョキ"));
	}

	@Test
	public void PAのgetHandNameでパーが返却されること() {
		// Exercise
		String actual = JankenHand.PA.getHandName();
		// Verify
		assertThat(actual, is("パー"));
	}

	@Test
	public void getJankenHandの引数に数字0を渡すとGUのインスタンスが返却されること() {
		// SetUp
		int handNum = 0;
		// Exercise
		JankenHand actual = JankenHand.getJankenHand(handNum);
		// Verify
		assertThat(actual, is(JankenHand.GU));

	}

	@Test
	public void getJankenHandの引数に数字1を渡すとCYOKIのインスタンスが返却されること() {
		// SetUp
		int handNum = 1;
		// Exercise
		JankenHand actual = JankenHand.getJankenHand(handNum);
		// Verify
		assertThat(actual, is(JankenHand.CYOKI));
	}

	@Test
	public void getJankenHandの引数に数字2を渡すとPAのインスタンスが返却されること() {
		// SetUp
		int handNum = 2;
		// Exercise
		JankenHand actual = JankenHand.getJankenHand(handNum);
		// Verify
		assertThat(actual, is(JankenHand.PA));
	}

	@Test
	public void getJankenHandの引数に文字0を渡すとGUのインスタンスが返却されること() {
		// SetUp
		String handNum = "0";
		// Exercise
		JankenHand actual = JankenHand.getJankenHand(handNum);
		// Verify
		assertThat(actual, is(JankenHand.GU));
	}

	@Test
	public void getJankenHandの引数に文字1を渡すとCYOKIのインスタンスが返却されること() {
		// SetUp
		String handNum = "1";
		// Exercise
		JankenHand actual = JankenHand.getJankenHand(handNum);
		// Verify
		assertThat(actual, is(JankenHand.CYOKI));
	}

	@Test
	public void getJankenHandの引数に文字2を渡すとPAのインスタンスが返却されること() {
		// SetUp
		String handNum = "2";
		// Exercise
		JankenHand actual = JankenHand.getJankenHand(handNum);
		// Verify
		assertThat(actual, is(JankenHand.PA));
	}

	@Test
	public void getJankenHandの引数に0_1_2以外の数字を渡すとNoSuchElementExceptionが発生すること() {
		// SetUp
		this.expectedException
				.expect(is(instanceOf(NoSuchElementException.class)));
		this.expectedException.expectMessage(is(equalTo("No value present")));
		int handNum = 3;
		// Exercise
		JankenHand.getJankenHand(handNum);
		// Verify
		fail("例外が発生しませんでした。");
	}

	@Test
	public void getJankenHandの引数にAを渡すとNoSuchElementExceptionが発生すること() {
		// SetUp
		this.expectedException
				.expect(is(instanceOf(NoSuchElementException.class)));
		this.expectedException.expectMessage(is(equalTo("No value present")));
		String handName = "A";
		// Exercise
		JankenHand.getJankenHand(handName);
		// Verify
		fail("例外が発生しませんでした。");
	}

	@Test
	public void getJankenHandの引数にnullを渡すとNoSuchElementExceptionが発生すること() {
		// SetUp
		this.expectedException
				.expect(is(instanceOf(NoSuchElementException.class)));
		this.expectedException.expectMessage(is(equalTo("No value present")));
		String handName = null;
		// Exercise
		JankenHand.getJankenHand(handName);
		// Verify
		fail("例外が発生しませんでした。");
	}

}
