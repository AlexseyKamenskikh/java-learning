package ru.red.inheritance;

class Box {
    private Double width;
    private Double height;
    private Double depth;

    Box(Box box) {
        this.width = box.width;
        this.height = box.height;
        this.depth = box.depth;
    }

    Box() {
        this.width = -1.0;
        this.height = -1.0;
        this.depth = -1.0;
    }

    Box(Double len) {
        this.width = len;
        this.height = len;
        this.depth = len;
    }

    public Box(Double weight, Double height, Double depth) {
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

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + (height != null ? "'*****'" : "null") +
                ", depth=" + depth +
                '}';
    }
}
