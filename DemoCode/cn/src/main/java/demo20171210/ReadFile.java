package demo20171210;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ReadXml();
		//ReadXml_ToString();
		//copyFileDemo();
		
		//System.out.println(compareFile());
		writeFile();

	}

	// 读取文件第一种方法
	public static void ReadXml() throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		File file = new File(path + "test.xml");
		List<String> list = FileUtils.readLines(file, "utf-8");
		for (String line : list) {
			System.out.println(line);
		}
	}

	// 读取文件第二种方法
	public static void ReadXml_ToString() throws IOException {
		String path2 = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		File file2 = new File(path2 + "ReadXml_ToString.txt");
		String content = FileUtils.readFileToString(file2, "utf-8");
		System.out.println(content);

	}

	// copyFile文件
	public static void copyFileDemo() {
		String path3 = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		File SourceFile = new File(path3 + "SourceFile.txt");
		File DestFile = new File(path3 + "DestFile.txt");
		try {
			FileUtils.copyFile(SourceFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//比较两个文件的内容
	public static Boolean compareFile() {
		String path4=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File compare1=new File(path4+"compare1.txt");
		File compare2=new File(path4+"compare2.txt");
		Boolean flag=null;
		try {
			 flag=FileUtils.contentEquals(compare1,compare2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return flag;
	}
	//写文件
	public static void writeFile() throws IOException {
		String path5=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File writerfile= new File(path5+"writeFile.txt");
		//FileUtils.write(writerfile, "123456", "utf-8");//覆盖
		FileUtils.write(writerfile, "wei", "utf-8", true) ;//追加
		FileUtils.write(writerfile, "liang", "utf-8", true) ;
		FileUtils.write(writerfile, "xiang", "utf-8", true) ;
		
	}
	
}
