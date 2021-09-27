package com.cbearindustries.abstractclasschallenge;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(new Node("Bananasaurus"));

        System.out.println("List after instantiation: ");
        list.traverse(list.getRoot());
        System.out.println();

        list.addItem(new Node("Chimichanga"));
        list.addItem(new Node("Quetzal"));
        list.addItem(new Node("Trash Panda"));
        list.addItem(new Node("Bacon"));
        list.addItem(new Node("Apply Crisps"));
        list.addItem(new Node("Winona"));

        System.out.println("List after adding remaining test nodes: ");
        list.traverse(list.getRoot());
        System.out.println();

        list.addItem(new Node("Trash Panda"));
        list.addItem(new Node("Winona"));

        System.out.println("List following attempted addition of duplicate 'Trash Panda' and 'Winona' nodes:");
        list.traverse(list.getRoot());
        System.out.println();

        list.removeItem(new Node("Quetzal"));
        list.removeItem(new Node("Chimichanga"));
        list.removeItem(new Node("Winona"));

        System.out.println("List following removal of Quezal, Chimichanga, and Winona: ");
        list.traverse(list.getRoot());
    }
}
