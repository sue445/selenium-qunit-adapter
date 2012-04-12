package jp.secret.sideroad;

/**
 * Supprt browsers
 * @author sue445
 *
 */
public enum Browser {
	FIREFOX("firefox"),
	CHROME("chrome"),
	OPERA("opera"),
	IE("ie"),
	;

	private final String name;

	private Browser(String name) {
		this.name = name;
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
