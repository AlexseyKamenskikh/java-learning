package ru.red.output_input_test;

import java.io.IOException;

class WriteDemo {
    public static void main(String[] args) throws IOException {

        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
        b = 'B';
        System.out.write(b);
        System.out.write('\n');
        b = 'C';
        System.out.write(b);
        System.out.write('\n');
        System.out.flush();
    }
}
