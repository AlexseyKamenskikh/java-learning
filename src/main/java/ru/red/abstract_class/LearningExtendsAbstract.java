package ru.red.abstract_class;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LearningExtendsAbstract extends LearningAbstract {
    private static final Logger log = LoggerFactory.getLogger(LearningExtendsAbstract.class);

    @Override
    void listen(String event) {
        log.info(event);
    }
}
