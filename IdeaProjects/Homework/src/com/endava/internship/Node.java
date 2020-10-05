package com.endava.internship;

class Node {
    private Student student;
    private Node leftChild;
    private Node rightChild;

    public Node(Student student, Node leftChild,Node rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.student = student;
    }
    public Node getLeftChild(){
        return  this.leftChild;
    }
    public Node getRightChild(){
        return this.rightChild;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Student getStudent(){
        return  this.student;
    }
}
