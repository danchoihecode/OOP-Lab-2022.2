package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

	public static void main(String[] args) throws IOException {

		String filename = "C:\\Users\\pc\\Documents\\c_c++\\snake.exe";
		byte[] inputBytes = { 0 };
		long startTime, endTime;

		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuffer outputStringBuffer = new StringBuffer();
		for (byte b : inputBytes) {
			outputStringBuffer.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

}
