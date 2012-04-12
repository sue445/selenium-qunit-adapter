package jp.secret.sideroad;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ResourceBundle;

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

	public static class GetStringTest{
		private ResourceBundle bundle = ResourceBundle.getBundle("application");

		@Test
		public void found() throws Exception {
			String actual = Browser.getString(bundle, "test.port");

			assertThat(actual, is(notNullValue()));
			assertThat(actual, is(not("")));
		}

		@Test
		public void notFound() throws Exception {
			String actual = Browser.getString(bundle, "aaaaaaaa");

			assertThat(actual, is(""));
		}
	}

}
