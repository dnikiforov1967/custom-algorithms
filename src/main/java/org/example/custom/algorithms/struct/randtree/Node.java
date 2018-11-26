/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct.randtree;

import java.util.Objects;

/**
 *
 * @author dima
 */
final class Node<T extends Comparable<T>> {
    private T value;
    private double random;

    public Node(T value, double random) {
        this.value = value;
        this.random = random;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public double getRandom() {
        return random;
    }

    public void setRandom(double random) {
        this.random = random;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node<?> other = (Node<?>) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

}
