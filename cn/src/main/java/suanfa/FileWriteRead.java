package suanfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//createFile();//写文件
		 ReadText();//读文件，一个字符一个字符的读

	}
	public static void createFile()  {
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		FileWriter fw = null;
		try {
			fw = new FileWriter(path+"Demo.txt");
			fw.write("writeDemo");//追加
			fw.flush();
			fw.write("wei");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fw!=null) {
					fw.close();
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void ReadText() throws IOException {
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		
		try {
			FileReader fr=new FileReader(path+"Demo.txt");
			int ch=0;
			while((ch=fr.read())!=-1) {
				System.out.print((char)ch); 
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
