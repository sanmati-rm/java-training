package com.target.training.programs;

import com.target.training.model.Book;

public class PrintBookDetails {

    public static void main(String[] args) {

        Book b1; //a reference occupies 8 bytes in stack

        b1 = new Book(); //is a object in heap; occupies 36 bytes in heap(sum of all variables in Book)
    }
}
