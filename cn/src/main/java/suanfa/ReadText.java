package suanfa;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator+"ReadText.txt";
		File file=new File(path);
		List<String> lines=FileUtils.readLines(file,"utf-8");
		for (String line : lines) {
			System.out.println(line);
		}
		

	}

}
