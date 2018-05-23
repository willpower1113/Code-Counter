package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 *
 */
public interface IFileReader {

	/**
	 * @param path
	 */
	void readFile(File file);

	/**
	 * @param path
	 * @return
	 */
	List<File> getFilesList(String path);
}
