package com.shq.demoCollection.jvm.classLoader;

public class MyClassLoaderTest extends ClassLoader {

    private String classPath;

    public MyClassLoaderTest(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
