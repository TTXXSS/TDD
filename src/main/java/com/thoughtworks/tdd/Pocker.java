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

        int[] initCountSameElement1 = getInitCountSameElement();
        int[] initCountSameElement2 = getInitCountSameElement();

        int[] countSameElement1 = getCountSameElement(initCountSameElement1,sortFirstCharcterGroup1);
        int[] countSameElement2 = getCountSameElement(initCountSameElement2,sortFirstCharcterGroup2);

        int indexOfMaxLengthOfSameElement1 = getIndexOfMaxLengthOfSameElement(countSameElement1);
        int indexOfMaxLengthOfSameElement2 = getIndexOfMaxLengthOfSameElement(countSameElement2);
        if(countSameElement1[indexOfMaxLengthOfSameElement1]>countSameElement2[indexOfMaxLengthOfSameElement2])
            return s1;
        if(countSameElement1[indexOfMaxLengthOfSameElement1]<countSameElement2[indexOfMaxLengthOfSameElement2])
            return s2;
        for(int i=length1-1;i>=0;i--){
                if(i==0&&sortFirstCharcterGroup1[i]==sortFirstCharcterGroup2[i]){
                    return "平局";
                }else if(sortFirstCharcterGroup1[i]==sortFirstCharcterGroup2[i]){
                    continue;
                }else if(sortFirstCharcterGroup1[i]>sortFirstCharcterGroup2[i]){
                    return s1;
                }else{
                    return s2;
                }
            }
        return null;
    }

    private int getIndexOfMaxLengthOfSameElement(int[] countSameElement1) {
        int index =0;
        int max = countSameElement1[0];
        for(int i=0;i<countSameElement1.length-1;i++){
            if(countSameElement1[i]>max){
                max =countSameElement1[i];
                index=i;
            }
        }
        return index;
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
    public int[] getInitCountSameElement(){
        int[] countSameElement = new int[5];
        for(int i=0;i<5;i++)
            countSameElement[i]=1;
        return countSameElement;
    }

    public int[] getCountSameElement(int[] initCountSameElement,int[] myElementArray){
        int[] countSameElement =initCountSameElement;
        for(int i=0;i<myElementArray.length;i++){
            for(int j=i+1;j<myElementArray.length;j++)
            if(myElementArray[i]==myElementArray[j]){
                countSameElement[i]++;
                i+=countSameElement[i]-1;
            }
        }
        return countSameElement;
    }
}
