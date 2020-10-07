package com.endava.internship;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class StudentSet implements Set<Student> {
    private Node root;
    private Integer MAX_VALUE_TREE = 0;

    private Node getSuccesor(Node delNode) {
        Node succesorParent = delNode;
        Node succesor = delNode;
        Node current = delNode.getRightChild();
        while (current != null) {
            succesorParent = succesor;
            succesor = current;
            current = current.getLeftChild();

        }
        if (succesor != delNode.getRightChild()) {
            succesorParent.setLeftChild(succesor.getRightChild());
            succesor.setRightChild(delNode.getRightChild());
        }
        return succesor;
    }

    private void setRoot(Node node) {

        this.root = node;
    }

    private void treePath(Node root) {
        if (root == null) {
            return;
        } else {
            MAX_VALUE_TREE++;
            treePath(root.getLeftChild());
            treePath(root.getRightChild());
        }

    }

    private void nodeInsert(Node node, Node parent) {

        if (root == null) {
            setRoot(node);
            return;
        }
        if (node.getStudent().compareTo(parent.getStudent()) < 0) { //Comparing the names of the student
            if (parent.getLeftChild() != null) { //Look if we are not on a leaf
                nodeInsert(node, parent.getLeftChild()); // If this is not a laf,go further
            } else {
                parent.setLeftChild(node);
            }
        } else {
            if (parent.getRightChild() != null) {
                nodeInsert(node, parent.getRightChild());
            } else {
                parent.setRightChild(node);
            }
        }

    }

    @Override
    public int size() {
        MAX_VALUE_TREE = 0;
        this.treePath(root);
        return MAX_VALUE_TREE;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {

        if (o == null) return false;
        if (root == null) return false;

        Node currentNode = root;
        Student student = (Student) o;

        while ((currentNode != null) && (!currentNode.getStudent().equals(o))) { // Searching until it finds the node or null
            if (currentNode.getStudent().compareTo(student) > 0) {
                currentNode = currentNode.getLeftChild(); // Updates the currentNode to continue searching
            } else {
                currentNode = currentNode.getRightChild();
            }

        }
        if (currentNode == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Iterator<Student> iterator() {

        return new ListIterator<Student>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Student next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Student previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Student student) {

            }

            @Override
            public void add(Student student) {

            }
        };
    }


    @Override
    public Object[] toArray() {


        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Student student) {
        Node node = new Node(student, null, null); //Creates a new node

        if (this.contains(student)) { // Search if it doesn't contain the node
            return false;
        }
        this.nodeInsert(node, root);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        Student student = (Student) o;
        while (currentNode != null || !currentNode.getStudent().equals(student)) { // Searching till it finds the node or null
            parentNode = currentNode; // Updates the parentNode
            if (currentNode.getStudent().compareTo(student) < 0) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild(); // Updates the currentNode to continue searching
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }

        }
        if (currentNode == null) {
            return false;
        }
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == root) {
                root = currentNode.getLeftChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getLeftChild());
            } else {
                parentNode.setRightChild(currentNode.getLeftChild());
            }

        } else if (currentNode.getLeftChild() == null) {
            if (currentNode == root) {
                root = currentNode.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getRightChild());
            } else {
                parentNode.setRightChild(currentNode.getRightChild());
            }

        } else {
            Node succesor = getSuccesor(currentNode);

            if (currentNode == root) {
                root = succesor;
            } else if (isLeftChild) {
                parentNode.setLeftChild(succesor);
            } else {
                parentNode.setRightChild(succesor);
            }

            succesor.setLeftChild(currentNode.getLeftChild());
        }

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Student> c) {

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        return false;
    }

    private void clearTree(Node current) {
        if (current == null) {
            return;
        }
        clearTree(current.getLeftChild());
        clearTree(current.getRightChild());
        current = null;

        return;
    }

    @Override
    public void clear() {

        clearTree(root);
    }
}
