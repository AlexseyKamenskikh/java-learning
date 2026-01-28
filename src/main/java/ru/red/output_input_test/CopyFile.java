package ru.red.output_input_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1.Создайте файл с именем first.txt в корне проекте.
 * 2.В терминале введите java A:\Learning\java-learning\src\main\java\ru\red\output_input_test\CopyFile.java first.txt second.txt
 */
public class CopyFile {
//    private static final Logger log = LoggerFactory.getLogger(CopyFile.class);

    public static void main(String[] args) {
        int i;
        if (args.length != 2) {
//            log.error("Не указаны исходный и целевой файл");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {


            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);

        } catch (IOException e) {
//            log.error("Ошибка ввода-вывода " + e.getMessage());
        }
    }
}
