package jp.secret.sideroad;

import java.io.File;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

/**
 * Supprt browsers
 * @author sue445
 *
 */
public enum Browser {
	FIREFOX("firefox", WebDriverStrategy.FIREFOX),
	CHROME("chrome", WebDriverStrategy.CHROME),
	OPERA("opera", WebDriverStrategy.OPERA),
	IE("ie", WebDriverStrategy.IE),
	;

	private final String name;
	private final WebDriverStrategy webDriverStrategy;

	private Browser(String name, WebDriverStrategy webDriverStrategy) {
		this.name = name;
		this.webDriverStrategy = webDriverStrategy;
	}

	private enum WebDriverStrategy{
		FIREFOX {
			@Override
			WebDriver newWebDriver(ResourceBundle bundle) {
				if (bundle.containsKey("webdriver.firefox.profile") &&
						! bundle.getString("webdriver.firefox.profile").isEmpty()
						) {
					File profileDir = new File(
							bundle.getString("webdriver.firefox.profile"));
					FirefoxProfile profile = new FirefoxProfile(profileDir);
					return new FirefoxDriver(profile);
				} else {
					return new FirefoxDriver();
				}
			}
		},
		CHROME {
			@Override
			WebDriver newWebDriver(ResourceBundle bundle) {
				if (bundle.containsKey("webdriver.chrome.driver")) {
					System.setProperty("webdriver.chrome.driver",
							bundle.getString("webdriver.chrome.driver"));
				}
				return new ChromeDriver();
			}
		},
		OPERA {
			@Override
			WebDriver newWebDriver(ResourceBundle bundle) {
				return new OperaDriver();
			}
		},
		IE {
			@Override
			WebDriver newWebDriver(ResourceBundle bundle) {
				return new InternetExplorerDriver();
			}
		},
		;

		abstract WebDriver newWebDriver(ResourceBundle bundle);
	}

	/**
	 * get bundle string (ignore all exceptions)
	 * @param bundle
	 * @param key
	 * @return if not found, return empty string
	 */
	public static String getString(ResourceBundle bundle, String key){
		try {
			return bundle.getString(key);
		} catch (Exception e) {
			return "";
		}
	}

	public WebDriver newWebDriver(ResourceBundle bundle){
		return webDriverStrategy.newWebDriver(bundle);
	}

	/**
	 * name to enum
	 * @param name
	 * @return if unmatched, return null
	 */
	public static Browser toEnum(String name){
		for(Browser browser : values()){
			if(browser.name.equals(name)){
				return browser;
			}
		}
		return null;
	}


}
