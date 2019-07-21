package suanfa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// WriterBufferDemo();
		BufferReadDemo();

	}

	/*
	 * 缓冲区的出现是为了提高流的读写效率，所以在创建缓冲区之前必须要有流对象 该缓冲区提供了一次读一行的方法，方便对于文本的获取
	 * 
	 */
	public static void WriterBufferDemo() {
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		try {
			// 创建一个字符写入流对象
			FileWriter fw = new FileWriter(path + "buf.txt");
			// 为了提高读写效率，加入缓冲区技术，只需要将提高效率的流对象作为参数传递给缓冲区的构造函数即可
			BufferedWriter bw = new BufferedWriter(fw);
			for (int x = 0; x < 5; x++) {
				bw.write("这是buffer写入" + x);
				// 跨平台的换行符就是我们说的newline
				bw.newLine();

			}
			// 只要用到缓冲区，就要记得刷新
			bw.flush();
			// 其实关闭缓冲区就是在关闭缓冲区的流对象，就不用fw.close
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void BufferReadDemo() {
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		try {
			// 创建一个读取对象和文件关联
			FileReader fw = new FileReader(path + "buf.txt");
			// 为了提高效率，加入缓冲技术，将字符读取流对象作为参数传递给缓冲对象的构造参数
			BufferedReader br = new BufferedReader(fw);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
