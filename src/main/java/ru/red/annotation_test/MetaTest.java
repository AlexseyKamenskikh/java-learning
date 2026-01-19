package ru.red.annotation_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class MetaTest {
    private static final Logger log = LoggerFactory.getLogger(MetaTest.class);

    @MyAnnotation(str = "Два параметра", val = 19)
    public static void myMeth(String str, int i) {
        MetaTest metaTest = new MetaTest();

        try {
            Class<?> c = metaTest.getClass();
            Method method = c.getMethod("myMeth", String.class, int.class);
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            log.info(myAnnotation.str() + " " + myAnnotation.val());
        } catch (NoSuchMethodException e) {
            log.error("Метод не найден");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
