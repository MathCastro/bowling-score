package com.matheus.user.input.scanner;

import com.matheus.user.input.UserInput;

import java.util.Scanner;

public class ScannerHandler implements UserInput {

    @Override
    public String readFileName() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }
}
