package com.whut.study.classLoader;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import org.apdplat.word.vector.F;

import java.io.File;
import java.io.FileInputStream;
import java.security.SecureClassLoader;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/15 8:57
 * @desription
 */
public class SalaryClassLoader extends SecureClassLoader {


    private String classPath;

    public SalaryClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] buff;

        ByteArrayBuffer ba = new ByteArrayBuffer();

        FileInputStream fis;

//        fis = new FileInputStream(new File());

//        fis.read()

        int cide;

        return super.findClass(name);
    }
}
