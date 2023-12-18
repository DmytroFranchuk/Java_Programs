package org.example.task2;

public class ComplexNumber {
    private final double realPart;
    private final double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public String toString() {
        if (imaginaryPart >= 0) {
            return realPart + " + j" + imaginaryPart;
        } else {
            return realPart + " - j" + (-imaginaryPart);
        }
    }
}
