package suit;

import io.SystemOutputStringTest;

import org.gradle.JankenPlayerTest;
import org.gradle.OneUserOneCpuJankenTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import strategy.RandomStrategyTest;
import enums.JankenHandTest;
import enums.WinLoseTypeTest;

@RunWith(Suite.class)
@SuiteClasses({ RandomStrategyTest.class, OneUserOneCpuJankenTest.class,
		JankenPlayerTest.class, SystemOutputStringTest.class,
		JankenHandTest.class, WinLoseTypeTest.class })
public class AllTests {

}
