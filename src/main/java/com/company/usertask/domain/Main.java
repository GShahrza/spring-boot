package com.company.usertask.domain;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String regex = "\\d{8,}$";

        String x = null;

        System.out.println(x.matches(regex));
    }
}
