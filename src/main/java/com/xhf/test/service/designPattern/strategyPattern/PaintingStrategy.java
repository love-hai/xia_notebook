package com.xhf.test.service.designPattern.strategyPattern;

public class PaintingStrategy {
    private Painting painting;

    public PaintingStrategy(Painting painting) {
        this.painting = painting;
    }

    public void make() {
        painting.make();
    }
}
