package ru.red.annotation_test;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@What(description = "Аннотация класса")
@MyAnnotation(str = "Meta2Test", val = 99)
public class Meta2Test {
    private static final Logger log = LoggerFactory.getLogger(Meta2Test.class);

    @What(description = "Аннотация метода")
    @MyAnnotation(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2Test meta2Test = new Meta2Test();

        try {
            Annotation[] annotations = meta2Test.getClass().getAnnotations();
            //Отобразить все аннотации для Meta2Test
            log.info("Все аннотации для класса Meta2Test");
            for (Annotation annotation: annotations) {
                log.info(StringEscapeUtils.unescapeJava(annotation.toString()));
            }

            //Отобразить все аннотации для  myMeth
            Method method =  meta2Test.getClass().getMethod("myMeth");
            annotations = method.getAnnotations();
            log.info("Все аннотации для класса myMeth");
            for (Annotation annotation: annotations) {
                log.info(StringEscapeUtils.unescapeJava(annotation.toString()));
            }
        } catch (NoSuchMethodException e) {
            log.error("Метод не найден");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
