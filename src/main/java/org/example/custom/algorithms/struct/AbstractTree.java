/*
 * Copyright 2018
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.custom.algorithms.struct;

import java.util.Deque;

/**
 *
 * @author dnikiforov
 */
public abstract class AbstractTree<K extends Comparable<K>, V> {

    protected AbstractNode<K, V> head;

    /**
     *
     * @param a Turn-around node
     * @return new Top-node
     */
    protected AbstractNode<K, V> smallRightTurn(AbstractNode<K, V> a) {
        if (a == null) {
            throw new IllegalStateException("Root is null");
        }
        final AbstractNode<K, V> b = a.getLeft();
        if (b == null) {
            throw new IllegalStateException("Left subtree is null");
        }
        //Keep b.left;
        //Keep a.right;
        final AbstractNode<K, V> bright = b.getRight();
        a.setLeft(bright);
        b.setRight(a);
        return b;
    }

    /**
     *
     * @param a Turn-around node
     * @return new Top-node
     */
    protected AbstractNode<K, V> smallLeftTurn(AbstractNode<K, V> a) {
        if (a == null) {
            throw new IllegalStateException("Root is null");
        }
        final AbstractNode<K, V> b = a.getRight();
        if (b == null) {
            throw new IllegalStateException("Right subtree is null");
        }
        //Keep a.left;
        //Keep b.right;
        final AbstractNode<K, V> bleft = b.getLeft();
        a.setRight(bleft);
        b.setLeft(a);
        return b;
    }

    /**
     *
     * @param a Turn-around node
     * @return new Top-node
     */
    protected AbstractNode<K, V> bigRightTurn(AbstractNode<K, V> a) {
        if (a == null) {
            throw new IllegalStateException("Root is null");
        }
        AbstractNode<K, V> b = a.getLeft();
        final AbstractNode<K, V> c = smallLeftTurn(b);
        a.setLeft(c);
        return smallRightTurn(a);
    }

    protected abstract AbstractNode<K, V> balance(AbstractNode<K, V> node);

    protected abstract int fixheight(AbstractNode<K, V> node);

    protected abstract int diffLeftAndRight(AbstractNode<K, V> node);

    protected final void rebalance(AbstractNode<K, V> assigned, Deque<AbstractNode<K, V>> path) {
        balance(assigned);
        AbstractNode<K, V> last = path.poll();
        while (last != null) {
            final AbstractNode<K, V> balanced = balance(last);
            if (last.equals(balanced)) {
                break;
            }
            last = path.poll();
            if (last == null) {
                head = balanced;
            }
        }
    }

    /**
     *
     * @param a Turn-around node
     * @return new Top-node
     */
    protected AbstractNode<K, V> bigLeftTurn(AbstractNode<K, V> a) {
        if (a == null) {
            throw new IllegalStateException("Root is null");
        }
        AbstractNode<K, V> b = a.getRight();
        final AbstractNode<K, V> c = smallRightTurn(b);
        a.setRight(c);
        return smallLeftTurn(a);
    }

    protected AbstractNode<K, V> appendNode(AbstractNode<K, V> node, Deque<AbstractNode<K, V>> path) {
        AbstractNode<K, V> ret = node;
        if (head == null) {
            head = node;
        } else {
            ret = appendNode(head, node, path);
        }
        return ret;
    }

    private AbstractNode<K, V> appendNode(AbstractNode<K, V> parent, AbstractNode<K, V> node, Deque<AbstractNode<K, V>> path) {
        AbstractNode<K, V> ret = node;
        path.push(parent);
        if (parent.getKey().compareTo(node.getKey()) == -1) { //parent < node
            //Right branch
            final AbstractNode<K, V> right = parent.getRight();
            if (right == null || right.getKey().compareTo(node.getKey()) == 1) { //node < right
                parent.setRight(node);
                node.setRight(right);
            } else { //node >= right
                ret = appendNode(right, node, path);
            }
        } else if (parent.getKey().compareTo(node.getKey()) == 1) { //parent > node
            //Left branch
            final AbstractNode<K, V> left = parent.getLeft();
            if (left == null || left.getKey().compareTo(node.getKey()) == -1) { //left < node
                parent.setLeft(node);
                node.setLeft(left);
            } else { //left >= node
                ret = appendNode(left, node, path);
            }
        } else {
            //Replace value
            parent.setValue(node.getValue());
            ret = parent;
        }
        return ret;
    }

    public abstract AbstractNode<K, V> put(K key, V value);

    public final AbstractNode<K, V> get(K key) {
        return find(head, key);
    }

    private AbstractNode<K, V> find(AbstractNode<K, V> parent, K key) {
        AbstractNode<K, V> res;
        if (parent == null || parent.getKey().compareTo(key) == 0) {
            res = parent;
        } else {
            if (parent.getKey().compareTo(key) == -1) {
                parent = parent.getRight();
            } else {
                parent = parent.getLeft();
            }
            res = find(parent, key);
        }
        return res;
    }

}
