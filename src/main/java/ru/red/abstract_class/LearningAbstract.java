package ru.red.abstract_class;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class LearningAbstract {
    private static final Logger log = LoggerFactory.getLogger(LearningAbstract.class);

    abstract void listen(String event);

    public void run() {
        log.info("--> Start LearningAbstract");
    }
}
