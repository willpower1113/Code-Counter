package entry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import impl.LocalJavaFileReader;

public class Entry {

	public static void main(String[] args) {
	}

	@Test
	public void test() {
		LocalJavaFileReader reader = new LocalJavaFileReader();
		List<File> files = reader.getFilesList("xxxx");
		System.out.println("共有"+files.size()+"个java文件");
		for (File file : files) {
			reader.readFile(file);
		}
		System.out.println("共有"+reader.getCount()+"行代码");
	}

}
