package jp.secret.sideroad;

import jp.secret.sideroad.rules.TemporaryFile;

import org.junit.Rule;
import org.junit.Test;

public class FileSearchTest {
	private FileSearch fileSearch = new FileSearch();

	@Rule
	public TemporaryFile tempFile = new TemporaryFile("a.txt");


	@Test
	public void exists() throws Exception{
		tempFile.assertExistsFile("a.txt");
	}

}
