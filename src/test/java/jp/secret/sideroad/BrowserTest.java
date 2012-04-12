package jp.secret.sideroad;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

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

	public static class GetBundleStringTest{
		private ResourceBundle bundle = ResourceBundle.getBundle("application");

		@Test
		public void found() throws Exception {
			String actual = Browser.getBundleString(bundle, "test.port");

			assertThat(actual, is(notNullValue()));
			assertThat(actual, is(not("")));
		}

		@Test
		public void notFound() throws Exception {
			String actual = Browser.getBundleString(bundle, "aaaaaaaa");

			assertThat(actual, is(""));
		}
	}

	public static class NewWebDriverTest{
		private ResourceBundle bundle = ResourceBundle.getBundle("application");

		@Test
		public void firefox() throws Exception {
			WebDriver actual = Browser.FIREFOX.newWebDriver(bundle);
			assertThat(actual, is(instanceOf(FirefoxDriver.class)));
		}

		@Test
		public void chrome() throws Exception {
			WebDriver actual = Browser.CHROME.newWebDriver(bundle);
			assertThat(actual, is(instanceOf(ChromeDriver.class)));
		}

		@Test
		public void opera() throws Exception {
			WebDriver actual = Browser.OPERA.newWebDriver(bundle);
			assertThat(actual, is(instanceOf(OperaDriver.class)));
		}

		@Test
		public void ie() throws Exception {
			WebDriver actual = Browser.IE.newWebDriver(bundle);
			assertThat(actual, is(instanceOf(InternetExplorerDriver.class)));
		}
	}

}
