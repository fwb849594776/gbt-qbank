package com.fitt.gbt.qbank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionBankApplicationTests {

	@Test
	public void contextLoads() {
		for (int b = Integer.parseInt("0101",2); b <= Integer.parseInt("1111",2); b++) {
			System.out.println(b);
		}
	}

}
