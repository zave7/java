import java.io.*;
import java.util.Date;

import com.kitri.dto.Child;
import com.kitri.dto.Product;

public class SerializeTest {
	public static void main(String[] args) {
		//file name : a.ser
		//byte단위 출력 스트림 : FileOutputStream 
		//객체출력 스트림 : ObjectOoutputStream
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("a.ser"));
			Date now = new Date();
			Product p = new Product();
			p.setProd_no("001");
			p.setProd_name("아메리카노");
			p.setProd_price(2500);
			Child child = new Child();
			child.setC("Child Instance Variable");
			oos.writeObject(now);//객체 내용이 파일에 채워진거다
			oos.writeObject(p);
			oos.writeObject(child);
			//객체의 그상태 그대로를 jvm하고 관계없는 파일에 저장한 것이다. (그상태 그대로 얼려서)
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null)
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//file name : a.ser
		//Byte InputStream : FileInputStream
		//ObjectInputStream 
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("a.ser"));
			Object obj = ois.readObject();
			System.out.println((obj instanceof Date));
			System.out.println(obj);
			
			obj = ois.readObject();
//			System.out.println((obj instanceof Date));
			System.out.println(obj);
			
			obj = ois.readObject();
			Child c1 = (Child)obj;
			System.out.println(c1.getC());
			System.out.println(c1.getP());//serializable 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
				try {
					if(ois != null)
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
}
