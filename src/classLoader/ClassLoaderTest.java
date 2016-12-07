package classLoader;

import java.io.IOException;
import java.io.InputStream;

import com.alibaba.fastjson.JSON;

public class ClassLoaderTest{
	public static void main(String args[]) throws Exception{
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					fileName.getClass();
					Class<?> object = getClass();
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getClass()));
					System.out.println(JSON.toJSONString(object.getClassLoader()));
					System.out.println(JSON.toJSONString(object.getMethods()));
					System.out.println(JSON.toJSONString(object.getFields()));
					System.out.println(JSON.toJSONString(object.getModifiers()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					System.out.println(JSON.toJSONString(object.getName()));
					
					System.out.println("-----------------------------------------");
					InputStream iStream = object.getResourceAsStream(fileName);
					if (null == iStream) {
						return super.loadClass(name,true);
					}
					byte[] b = new byte[iStream.available()];
					iStream.read(b);
					return defineClass(name, b, 0,b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException("",e);
				}
			}
		}; 
//		
//		Object object = myLoader.loadClass("classLoader.ConstantClass").newInstance();
//		System.out.println(object.getClass());
//		System.out.println(object instanceof classLoader.ConstantClass);
		
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader);
			loader = loader.getParent();
			
		}
		
	}
}
