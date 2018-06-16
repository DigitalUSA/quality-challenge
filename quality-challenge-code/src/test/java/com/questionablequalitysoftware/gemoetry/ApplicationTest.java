package com.questionablequalitysoftware.gemoetry;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.questionablequalitysoftware.gemoetry.Application.ExitException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Test
	public void test46() throws Exception {
		Application app = new Application();
		final String [] args = { "exitcode" };
		try {
			app.run(args);
			fail();
		} catch (ExitException e) {
			System.out.println("Exit code is: " + e.getExitCode());
		}
	}

	@Test
	public void test47() throws Exception {
		Application app = new Application();
		final String[] args = { "banans" };
		app.run(args);
	}
}
