package demo20171210;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.animation.PathTransition;

public class KeyToXml {
	public static void main(String[] args) throws JAXBException {
		 ToXml();
		
	}
	public static void ToXml() throws JAXBException {
		
		//JAXBContext jaxbContext=JAXBContext.newInstance(person.class);
		 JAXBContext jc = JAXBContext.newInstance(person.class);  
	     Marshaller ms = jc.createMarshaller();
	     person person=new person("wlx", "boy", 18, "p1", "p2", "p3", "p4", "p5");
	     ms.marshal(person, System.out);
	     String path= System.getProperty("user.dir")+File.separator+"data"+File.separator;
	    //新建一个文件夹
	     File file=new File(path+"test.xml");
	     ms.marshal(person, file);
	     
	     
	}
	public static void ReadXml() throws JAXBException {
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><age>18</age><name>wlx</name><p1>p1</p1><p2>p2</p2><p3>p3</p3><p4>p4</p4><hello>p5</hello><sex>boy</sex></person>";
		 JAXBContext jc = JAXBContext.newInstance(person.class); 
		 Unmarshaller unmarshaller=jc.createUnmarshaller();
		 person p=(person) unmarshaller.unmarshal(new StringReader(xml));
		 
	}

}
