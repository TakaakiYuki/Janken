package io;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;

public class SystemOutputStringTest {

	@Test
	public void outputStringの引数に指定した文字列が標準出力に出力されること(){
		//Setup
		String output="確認用文字列abcde12345";
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		PrintStream origWriter = System.out;
		System.setOut(ps);

		//Exercise
		System.out.print(output);

		//Verify
		String actual = new String(os.toByteArray());
		assertThat(actual, is("確認用文字列abcde12345"));
		
		// TearDown
		System.setOut(origWriter);
	}

}
