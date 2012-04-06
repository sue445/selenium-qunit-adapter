package jp.secret.sideroad.rules;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.rules.TemporaryFolder;

/**
 * create dummy files in tempirary folder
 * @author sue445
 *
 */
public class TemporaryFile extends TemporaryFolder{
	private final String[] files;

	public TemporaryFile(String... files){
		this.files = files;
	}

	@Override
	protected void before() throws Throwable {
		super.before();

		for(String filename : files){
			createTempFile(filename);
		}
	}

	private void createTempFile(String filename) throws FileNotFoundException, IOException {
		OutputStream stream = new FileOutputStream(getRoot().getAbsolutePath() + "/" + filename);
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
}
