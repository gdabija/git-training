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

    private void nodeInsert(Node node, Node root){

        if (root==null){
            setRoot(node);
            return;
        }
        if(node.getStudent().getName().compareTo(root.getStudent().getName())<0){ //Comparing the names of the student
            if(root.getLeftChild()!=null){ //Look if we are not on a leaf
                nodeInsert(node, root.getLeftChild()); // If this is not a laf,go further
            }
            else{

                root.setLeftChild(node);
            }
        }
        else{
            if(root.getRightChild()!=null){
                nodeInsert(node, root.getRightChild());
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

        if (o == null || getClass() != o.getClass()) return false;

        Node currentNode = root;
        Student student = (Student) o;

        while(currentNode!=null || !currentNode.getStudent().equals(student)) { // Searching until it finds the node or null
            if (currentNode.getStudent().getName().compareTo(student.getName()) < 0) {

                currentNode = currentNode.getLeftChild(); // Updates the currentNode to continue searching
            } else {
                currentNode = currentNode.getRightChild();
            }


        }
        if(currentNode == null){
            return false;
        }
        else{
            return true;
        }

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
        Node node = new Node(student, null, null); //Creates a new node
      /*  if(this.contains(node)) { // Search if it doesn't contain the node
            return false;
        }*/
        this.nodeInsert(node,root);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node currentNode=root;
        Node parentNode = root;
        Student student = (Student) o;
        while(currentNode!=null || !currentNode.getStudent().equals(student)){ // Searching till it finds the node or null
            if(currentNode.getStudent().getName().compareTo(student.getName())<0){
                parentNode = currentNode; // Updates the parentNode
                currentNode = currentNode.getLeftChild(); // Updates the currentNode to continue searching
            }else {
                parentNode = currentNode;
                currentNode = currentNode.getRightChild();
            }


        }
        if(currentNode == null){

            return false;
        }
        else {

        }


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
