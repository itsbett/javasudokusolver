package com.brettdoes;

import org.jetbrains.annotations.Contract;

public class Position<X, Y> {
    private X x;
    private Y y;

    public Position (X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other) {
        if (other instanceof Position) {
            Position otherPair = (Position) other;
            return ((  this.x == otherPair.x || ( this.x != null && otherPair.x != null
                    && this.x.equals(otherPair.x))) && (  this.y == otherPair.y ||
                    ( this.y != null && otherPair.y != null && this.y.equals(otherPair.y))) );
        }
        return false;
    }
    public X getX() {
        return x;
    }
    public void setX (X x) {
        this.x = x;
    }
    public Y getY() {
        return y;
    }
    public void setY(Y y) {
        this.y = y;
    }
}
