package ru.red.inheritance;

class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box box) {
        this.width = box.width;
        this.height = box.height;
        this.depth = box.depth;
    }

    Box() {
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    Box(double len) {
        this.width = len;
        this.height = len;
        this.depth = len;
    }

    public Box(double weight, double height, double depth) {
        this.width = weight;
        this.height = height;
        this.depth = depth;
    }

    double volume() {
        return width * height * depth;
    }


    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double getHeight() {
        return height;
    }

    void setHeight(double height) {
        this.height = height;
    }

    double getDepth() {
        return depth;
    }

    void setDepth(double depth) {
        this.depth = depth;
    }
}
