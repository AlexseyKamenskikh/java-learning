package ru.red.annotation_test;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RepeatedAnno {

    private static final Logger log = LoggerFactory.getLogger(RepeatedAnno.class);

    //Повторить аннотацию MyAnnotation для метода myMeth()
    @MyAnnotation(str = "Первая аннотация", val = -1)
    @MyAnnotation(str = "Вторая аннотация", val = 100)
    public static void myMeth(String str, int i) {
        RepeatedAnno repeatedAnno = new RepeatedAnno();
        try {
            Class<?> c = repeatedAnno.getClass();

            //Получить аннотации для метода myMeth();
            Method method = c.getMethod("myMeth", String.class, int.class);

            //отобразить повторяющиеся аннотации MyAnnotation
            Annotation annotation = method.getAnnotation(MyRepeatedAnnos.class);
            log.info(StringEscapeUtils.unescapeJava(annotation.toString()));

            //отобразить повторяющиеся аннотации MyAnnotation
            Annotation[] annotations = method.getAnnotationsByType(MyAnnotation.class);
            for (Annotation a: annotations) {
                log.info(StringEscapeUtils.unescapeJava(a.toString()));
            }
        } catch (NoSuchMethodException e) {
            log.error("Метод не найден");
        }
    }

    public static void main(String[] args) {
        myMeth("тест", 10);
    }
}
