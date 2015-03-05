package strategy;

import static org.junit.Assert.fail;

import org.junit.Test;

public class RandomStrategyTest {

	@Test
	public void ランダム戦略で例外が発生しないこと() {
		// Setup
		JankenStrategy randomStrategy = new RandomStrategy();

		// Exercise
		// Verify
		for (int i = 0; i < 100; ++i) {
			try {
				randomStrategy.execute();
			} catch (Exception e) {
				fail("例外が発生しました。");
			}
		}
	}

}
