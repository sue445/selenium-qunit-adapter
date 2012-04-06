package jp.secret.sideroad;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileSearchTest {
	private FileSearch fileSearch = new FileSearch();

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();


	@Before
	public void setUp() throws Exception {
		File root = tempFolder.getRoot();
		String name = "a.txt";
		createTempFile(root, name);
	}

	private void createTempFile(File root, String name)
			throws FileNotFoundException, IOException {
		OutputStream stream = new FileOutputStream(root.getAbsolutePath() + "/" + name);
		try{
			stream.write(0);
			stream.flush();

		} finally{
			try {
				stream.close();
			} catch (IOException e) {
				// ignore exception
				e.printStackTrace();
			}
		}
	}

	@Test
	public void exists() throws Exception{
		String filePath = tempFolder.getRoot().getAbsolutePath() + "/" + "a.txt";
		File file = new File(filePath);
		assertThat(file.exists(), is(true));
	}

}
