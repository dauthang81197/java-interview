package com.example.javaex.senior.t01_jvm;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Bai35SrByteArrayClassLoaderTest {

    private static byte[] bytesOf(Class<?> c) throws Exception {
        try (InputStream in = c.getResourceAsStream(c.getSimpleName() + ".class")) {
            assertNotNull(in);
            return in.readAllBytes();
        }
    }

    @Test
    void definesClassFromBytes() throws Exception {
        String name = Greeter.class.getName();
        Bai35SrByteArrayClassLoader loader = new Bai35SrByteArrayClassLoader(
                ClassLoader.getPlatformClassLoader(), Map.of(name, bytesOf(Greeter.class)));
        Class<?> loaded = loader.loadClass(name);
        assertEquals(name, loaded.getName());
        assertSame(loader, loaded.getClassLoader());
        assertNotSame(Greeter.class, loaded);
        Object o = loaded.getDeclaredConstructor().newInstance();
        assertEquals("xin chao", loaded.getMethod("hello").invoke(o));
        assertFalse(Greeter.class.isInstance(o), "cùng tên nhưng khác loader thì là hai kiểu khác nhau");
    }

    @Test
    void sameLoaderReturnsSameClass() throws Exception {
        String name = Greeter.class.getName();
        Bai35SrByteArrayClassLoader loader = new Bai35SrByteArrayClassLoader(
                ClassLoader.getPlatformClassLoader(), Map.of(name, bytesOf(Greeter.class)));
        assertSame(loader.loadClass(name), loader.loadClass(name));
    }

    @Test
    void unknownClassThrows() {
        Bai35SrByteArrayClassLoader loader = new Bai35SrByteArrayClassLoader(ClassLoader.getPlatformClassLoader(), Map.of());
        assertThrows(ClassNotFoundException.class, () -> loader.loadClass("does.not.Exist"));
    }

    @Test
    void parentDelegationStillWorksForJdkClasses() throws Exception {
        Bai35SrByteArrayClassLoader loader = new Bai35SrByteArrayClassLoader(ClassLoader.getPlatformClassLoader(), Map.of());
        assertSame(String.class, loader.loadClass("java.lang.String"));
    }
}
