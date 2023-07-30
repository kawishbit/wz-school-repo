package com.example.mobileprogramming.helpers;

public class Tiles {
    private final int drawable;
    private final int order;

    public Tiles(Integer drawable, int order) {
        this.drawable = drawable;
        this.order = order;
    }

    public int getDrawable() {
        return this.drawable;
    }

    public int getOrder() {
        return this.order;
    }

}
