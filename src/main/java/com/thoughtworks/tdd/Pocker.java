package com.thoughtworks.tdd;

public class Pocker {
    private String pocker1;
    private String pocker2;

    public Pocker(String pocker1, String pocker2) {
        this.pocker1 = pocker1;
        this.pocker2 = pocker2;
    }

    public String getPocker1() {
        return pocker1;
    }

    public void setPocker1(String pocker1) {
        this.pocker1 = pocker1;
    }

    public String getPocker2() {
        return pocker2;
    }

    public void setPocker2(String pocker2) {
        this.pocker2 = pocker2;
    }

    public String compareLager(String s1,String s2){
        return s1.charAt(0)>s2.charAt(0)?s1:s2;
    }
}
