package ru.red.inheritance;

class BoxWeight extends Box {
    double weight;

    BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    BoxWeight() {

    }

    double getWeight() {
        return weight;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }
}
