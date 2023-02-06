package com.shq.demoCollection.jvm.classLoader;

public class TestJDKClassLoader {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();

        System.out.println("the bootstrapLoader：" + bootstrapLoader);
        System.out.println("the extClassLoader：" + extClassLoader);
        System.out.println("the applicationLoader：" + appClassLoader);

        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));

    }
}
