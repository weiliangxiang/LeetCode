package suanfa;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WriteText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator+"ReadText.txt";
		File file=new File(path);
		FileUtils.write(file, "weiliangxiang","utf-8",true);//true´ú±í×·¼Ó
	}

}
