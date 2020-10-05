package com.endava.internship;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class StudentSet implements Set<Student> {
    private LinkedList<Node> list = new LinkedList<>();
    private Node root;
    private Integer MAX_VALUE_TREE = 0;



    private void setRoot(Node node){

        this.root=node;
    }

    private void treePath (Node root){
        if (root==null){
            return;
        }
        else{
            MAX_VALUE_TREE++;
            treePath(root.getLeftChild());
            treePath(root.getRightChild());
        }

    }

    private void nodeInsert(Node node){

        if (root==null){
            setRoot(node);
            return;
        }
        if(node.getStudent().getName().compareTo(root.getStudent().getName())<0){ //Comparing the names of the student
            if(root.getLeftChild()!=null){ //Look if we are not on a leaf
                nodeInsert(root.getLeftChild()); // If this is not a laf,go further
            }
            else{

                root.setLeftChild(node);
            }
        }
        else{
            if(root.getRightChild()!=null){
                nodeInsert(root.getRightChild());
            }else{
                root.setRightChild(node);
            }
        }

    }

    @Override
    public int size() {
        MAX_VALUE_TREE =0;
        this.treePath(root);
        return MAX_VALUE_TREE;
    }

    @Override
    public boolean isEmpty() {
    if(this.size()==0){
        return true;
    }else{
        return false;
        }
    }

    @Override
    public boolean contains(Object o) {


        return false;
    }

    @Override
    public Iterator<Student> iterator() {
        return null;
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
        Node node = new Node(student, null, null);
        if(this.contains(node)) {
            return false;
        }
        this.nodeInsert(node);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current=root;
        Node parent = root;


        return false;
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

    @Override
    public void clear() {

    }
}
