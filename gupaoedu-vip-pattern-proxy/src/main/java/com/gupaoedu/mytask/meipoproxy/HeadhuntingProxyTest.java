package com.gupaoedu.mytask.meipoproxy;

public class HeadhuntingProxyTest {
    public static void main(String[] args) {
        Person person = (Person) new HeadhuntingProxy().getInstance(new Man());
        person.findJob();
    }
}
