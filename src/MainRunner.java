import java.lang.reflect.Method;
import java.util.Date;

public class MainRunner {

	public static void main(String args[]) throws Exception {
		String progClass = "com.my.sngltn.SingleTonScore";

		CustomClazzLoader ccl = new CustomClazzLoader(MainRunner.class.getClassLoader());
		Class clas = ccl.loadClass(progClass);
		System.out.println("P:" + progClass);
		Class argType[] = { Date.class };
		Method getSingleton = clas.getMethod("getSingleTonScore", argType);
		Object obj = getSingleton.invoke(null, new Date());

		CustomClazzLoader ccl1 = new CustomClazzLoader(MainRunner.class.getClassLoader());
		Class clas1 = ccl1.loadClass(progClass);
		System.out.println("P:" + progClass);
		Method getSingleton1 = clas1.getMethod("getSingleTonScore", argType);
		Object obj1 = getSingleton1.invoke(null, new Date());
		//Class reloadclas2 = ccl1.loadClass(progClass);
		
		System.out.println(obj);
		System.out.println(obj1);
		System.out.println(obj==obj1);//check singleton obj

	}

}
