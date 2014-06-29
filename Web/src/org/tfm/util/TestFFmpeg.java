//package org.tfm.util;
//
//import it.sauronsoftware.jave.DefaultFFMPEGLocator;
//
//import java.lang.reflect.Field;
//
///**
// * Created by christ on 14-6-21.
// * Make move.
// */
//public class TestFFmpeg {
//    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("java.io.tmpdir"));
//        System.out.println(System.getProperty("os.name"));
//        Class<?> ffmpeg =new DefaultFFMPEGLocator().getClass();
//        Object obj = ffmpeg.newInstance();
//        Field f = ffmpeg.getDeclaredField("path");
//        f.setAccessible(true);
//        System.out.println(f.get(obj));
//
//    }
//}
