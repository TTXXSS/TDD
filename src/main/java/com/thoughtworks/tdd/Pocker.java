package com.thoughtworks.tdd;

import java.util.Arrays;

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
        int[] firstCharcterGroup1 = getFirstCharacterThenCombineToArray(s1);
        int[] firstCharcterGroup2 = getFirstCharacterThenCombineToArray(s2);

        int[] sortFirstCharcterGroup1 = sortMyArray(firstCharcterGroup1);
        int[] sortFirstCharcterGroup2 = sortMyArray(firstCharcterGroup2);

        int length1 = sortFirstCharcterGroup1.length;
        int length2 = sortFirstCharcterGroup2.length;

        for(int i=0;i<length1;i++){
        }
        return sortFirstCharcterGroup1[length1-1]>sortFirstCharcterGroup2[length2-1]?s1:s2;
    }

    public int[] getFirstCharacterThenCombineToArray(String s){
        String[] str = s.split(" ");
        int length = s.split(" ").length;
        int[] myFirstCharacterArray = new int[length];
        for(int i=0;i<length;i++){
            if(str[i].substring(0,1).equals("a")){
                myFirstCharacterArray[i] = 14;
            }else if(str[i].substring(0,1).equals("k")){
                myFirstCharacterArray[i] = 13;
            }else if(str[i].substring(0,1).equals("q")){
                myFirstCharacterArray[i] = 12;
            }else if(str[i].substring(0,1).equals("j")){
                myFirstCharacterArray[i] = 11;
            }else {
                myFirstCharacterArray[i] = Integer.parseInt(str[i].substring(0, 1));
            }
        }
        return myFirstCharacterArray;
    }
    public int[] sortMyArray(int []myFirstCharacterArray){
        Arrays.sort(myFirstCharacterArray);
        return myFirstCharacterArray;
    }
}
