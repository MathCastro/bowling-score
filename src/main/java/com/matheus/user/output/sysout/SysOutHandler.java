package com.matheus.user.output.sysout;

import com.matheus.user.output.UserOutput;

public class SysOutHandler implements UserOutput {
    @Override
    public void readFileNameMessage() {
        System.out.println("Write the name of the file:");
    }
}
