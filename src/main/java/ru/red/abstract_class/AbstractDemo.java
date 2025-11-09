package ru.red.abstract_class;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractDemo {
    private static final Logger log = LoggerFactory.getLogger(AbstractDemo.class);

    public static void main(String[] args) {
        LearningAbstract learningAbstract = new LearningExtendsAbstract();

        learningAbstract.run();
        learningAbstract.listen("--> New event");

        LearningAbstract learningAbstract1 = new LearningAbstract() {
            @Override
            void listen(String event) {
                log.info(event);
            }
        };

        learningAbstract1.listen("--> Implemented using an anonymous class");
    }
}
