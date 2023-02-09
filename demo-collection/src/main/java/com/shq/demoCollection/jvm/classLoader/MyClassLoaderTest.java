package com.shq.demoCollection.jvm.classLoader;

import java.io.FileInputStream;

public class MyClassLoaderTest extends ClassLoader {

    private String classPath;

    public MyClassLoaderTest(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = loadByte(name);
            // defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终字节数组。
            return defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.","/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    /**
     * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // first,check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                // if still not found,then invoke findClass in order to find the class
                long t1 = System.nanoTime();
                c = findClass(name);
                // this is the defining class loader, record the stats
                sun.misc.PerfCounter.getFindClassTime().set(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    public static void main(String[] args) throws Exception {
        // 初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的
        // 父加载器设置为应用程序类加载器AppClassLoader
        // /Users/wayz/myClassLoadTest/com/shq/demoCollection/jvm/classLoader
        // /Users/wayz/myClassLoadTest/com/shq/demoCollection/jvm/classLoader/User1.class
        MyClassLoaderTest myClassLoader = new MyClassLoaderTest("/Users/wayz/myClassLoadTest");
        Class<?> clazz = myClassLoader.loadClass("com.shq.demoCollection.jvm.classLoader.User1");
        System.out.println(clazz.getClassLoader().getClass().getName());
    }


}
