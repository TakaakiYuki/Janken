package org.gradle;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import io.Output;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import strategy.JankenStrategy;
import enums.JankenHand;

public class OneUserOneCpuJankenTest {

	private InputStream origReader;

	@Before
	public void setUp() {
		this.origReader = System.in;

	}

	@After
	public void tearDown() {
		// TearDown
		System.setIn(this.origReader);
	}

	@Test
	public void グーとグーでじゃんけんを行い引き分けとなること() {

		// setup
		// ユーザの設定
		byte[] input = "0".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(0);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tグー");
		expect.add("CPUの手は：\tグー");
		expect.add("引き分けです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void グーとチョキでじゃんけんを行い引き分けとなること() {

		// setup

		// ユーザの設定
		byte[] input = "0".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand("1");
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tグー");
		expect.add("CPUの手は：\tチョキ");
		expect.add("あなたの勝ちです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void グーとパーでじゃんけんを行い負けとなること() {

		// setup
		// GUだけを出すじゃんけん戦略の生成
		JankenStrategy strategy = () -> JankenHand.getJankenHand(2);
		List<String> actual = new ArrayList<String>();
		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tグー");
		expect.add("CPUの手は：\tパー");
		expect.add("あなたの負けです。");

		// ユーザからの入力を設定
		byte[] input = "0".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void チョキとグーでじゃんけんを行い負けとなること() {

		// setup

		// ユーザの設定
		byte[] input = "1".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(0);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tチョキ");
		expect.add("CPUの手は：\tグー");
		expect.add("あなたの負けです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void チョキとチョキでじゃんけんを行い引き分けとなること() {

		// setup

		// ユーザの設定
		byte[] input = "1".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(1);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tチョキ");
		expect.add("CPUの手は：\tチョキ");
		expect.add("引き分けです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void チョキとパーでじゃんけんを行い勝ちとなること() {

		// setup

		// ユーザの設定
		byte[] input = "1".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(2);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tチョキ");
		expect.add("CPUの手は：\tパー");
		expect.add("あなたの勝ちです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void パーとグーでじゃんけんを行い勝ちとなること() {

		// setup

		// ユーザの設定
		byte[] input = "2".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(0);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tパー");
		expect.add("CPUの手は：\tグー");
		expect.add("あなたの勝ちです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void パーとチョキでじゃんけんを行い負けとなること() {

		// setup

		// ユーザの設定
		byte[] input = "2".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(1);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tパー");
		expect.add("CPUの手は：\tチョキ");
		expect.add("あなたの負けです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

	@Test
	public void パーとパーでじゃんけんを行い引き分けとなること() {

		// setup

		// ユーザの設定
		byte[] input = "2".getBytes();
		ByteArrayInputStream is = new ByteArrayInputStream(input);
		System.setIn(is);

		// CPUの設定
		JankenStrategy strategy = () -> JankenHand.getJankenHand(2);
		List<String> actual = new ArrayList<String>();

		// 出力文字列の設定
		List<String> expect = new ArrayList<String>();
		expect.add("グー:0  チョキ:1  パー:2のどれかの数字を入力してください。");
		expect.add("あなたの手は：\tパー");
		expect.add("CPUの手は：\tパー");
		expect.add("引き分けです。");

		// 出力先のスタブの作成
		Output out = (outString) -> actual.add(outString);

		// Exercise
		OneUserOneCpuJanken janken = new OneUserOneCpuJanken(out, strategy);
		janken.playGame();

		// Verify
		assertThat(actual, is(expect));
	}

}
