package org.gradle;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Test;

import strategy.JankenStrategy;
import enums.JankenHand;

public class JankenPlayerTest {

	@Test
	public void getInstanceでJankenPlayerのインスタンスが生成されること() {

		JankenStrategy randomStrategy = () -> JankenHand
				.getJankenHand(new Random().nextInt(JankenHand.values().length));

		// setup
		JankenHand jankenHand = null;
		// Exercise
		JankenPlayer actual = JankenPlayer.getInstance(jankenHand);
		// Verify
		assertThat(actual, is(instanceOf(JankenPlayer.class)));
	}

}
