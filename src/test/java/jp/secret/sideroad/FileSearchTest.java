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
	public TemporaryFile tempFile = new TemporaryFile("a.txt", "b.java");


	@Test
	public void exists() throws Exception{
		tempFile.assertExistsFile("a.txt");
	}

	@Test
	public void listFiles() throws Exception {
		File[] actual = fileSearch.listFiles(tempFile.getRootPath(), "*.java");

		assertThat(actual.length, is(1));
		assertThat(actual[0].getName(), is("b.java"));
	}

}
