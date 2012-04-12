package jp.secret.sideroad;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BrowserTest {

	public static class ToEnumTest{
		@Test
		public void firefox() throws Exception {
			assertThat(Browser.toEnum("firefox"), is(Browser.FIREFOX));
		}

		@Test
		public void chrome() throws Exception {
			assertThat(Browser.toEnum("chrome"), is(Browser.CHROME));
		}

		@Test
		public void opera() throws Exception {
			assertThat(Browser.toEnum("opera"), is(Browser.OPERA));
		}

		@Test
		public void ie() throws Exception {
			assertThat(Browser.toEnum("ie"), is(Browser.IE));
		}

		@Test
		public void unknown() throws Exception {
			assertThat(Browser.toEnum("aaaaaa"), is(nullValue()));
		}
	}

}
