package jp.secret.sideroad;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;

import jp.secret.sideroad.rules.TemporaryFiles;

import org.junit.Rule;
import org.junit.Test;

public class FileSearchTest {
	private FileSearch fileSearch = new FileSearch();

	@Rule
	public TemporaryFiles tempFiles = new TemporaryFiles("a.txt", "b.java");


	@Test
	public void exists() throws Exception{
		tempFiles.assertExistsFile("a.txt");
	}

	@Test
	public void listFiles() throws Exception {
		File[] actual = fileSearch.listFiles(tempFiles.getRootDirectory(), "*.java");

		assertThat(actual.length, is(1));
		assertThat(actual[0].getName(), is("b.java"));
	}

}
