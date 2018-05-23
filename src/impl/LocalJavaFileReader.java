package impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import manager.IFileReader;

/**
 * @author Administrator
 */
public class LocalJavaFileReader implements IFileReader {

	private List<File> files;

	private TestCounter counter;

	public LocalJavaFileReader() {
		super();
		this.files = new ArrayList<>();
		this.counter = new TestCounter();
	}

	@Override
	public void readFile(File file) {
		// TODO Auto-generated method stub
		FileReader reader = null;
		BufferedReader bfReader = null;
		String fileName = "";
		if (file != null && file.exists()) {
			fileName = file.getAbsolutePath();
		}
		try {
			reader = new FileReader(file);
			bfReader = new BufferedReader(reader);
			long lines = 0;
			String temp;
			while ((temp = bfReader.readLine()) != null) {
				System.out.println("第" + lines + "行:" + temp);
				lines++;
			}
			counter.counter(lines);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(fileName + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(fileName + e.getMessage());
		} finally {
			try {
				if (bfReader != null) {
					bfReader.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(fileName + e.getMessage());
			}
		}

	}

	@Override
	public List<File> getFilesList(String path) {
		// TODO Auto-generated method stub
		File file = new File(path);
		return checkPath(file.listFiles());
	}

	private List<File> checkPath(File[] fileArray) {
		if (fileArray != null) {
			for (File file : fileArray) {
				if (file.isDirectory()) {
					checkPath(file.listFiles());
				} else {
					if (file.getName().endsWith(".java")) {
						files.add(file);
					}
				}
			}
		}
		return files;
	}

	public long getCount() {
		return counter.getValue();
	}

}
