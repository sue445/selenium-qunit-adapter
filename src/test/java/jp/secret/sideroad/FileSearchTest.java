package jp.secret.sideroad;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import jp.secret.sideroad.rules.TemporaryFile;

import org.junit.Rule;
import org.junit.Test;

public class FileSearchTest {
	private FileSearch fileSearch = new FileSearch();

	@Rule
	public TemporaryFile tempFile = new TemporaryFile("a.txt");


	@Test
	public void exists() throws Exception{
		String filePath = tempFile.getRoot().getAbsolutePath() + "/" + "a.txt";
		File file = new File(filePath);
		assertThat(file.exists(), is(true));
	}

}
