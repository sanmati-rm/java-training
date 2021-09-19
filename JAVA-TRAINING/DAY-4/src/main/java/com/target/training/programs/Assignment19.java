package com.target.training.programs;

import com.target.training.dao.ContactsDao;
import com.target.training.dao.HashMapContactsDao;

import java.util.Scanner;

public class Assignment19 {

    static Scanner sc = new Scanner(System.in);
    ContactsDao dao;

    public static void main(String[] args) {
        new Assignment19().start();
    }

    private void start() {
        dao = new HashMapContactsDao();
    }
}
