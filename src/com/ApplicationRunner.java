package com;

import com.service.DmdevCafe;

public class ApplicationRunner {

    public static void main(String[] args) {
        new DmdevCafe(10, 5).start();
    }
}
