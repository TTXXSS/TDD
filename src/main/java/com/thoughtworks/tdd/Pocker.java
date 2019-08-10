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

        boolean isStraight1 =isStraight(sortFirstCharcterGroup1);
        boolean isStraight2 =isStraight(sortFirstCharcterGroup2);

        boolean isThreeWithTwo1 = isContainThreeSameElementsAndTwoElements(countSameElement1);
        boolean isThreeWithTwo2 = isContainThreeSameElementsAndTwoElements(countSameElement2);

        boolean isFourWithOne1 = isFourWithOne(countSameElement1);
        boolean isFourWithOne2 = isFourWithOne(countSameElement2);

        if(isFourWithOne1&&isFourWithOne2){    //判断两者是否都是四带一
            int elementFromFourSameElements1 = getElementFromFourSameElements(countSameElement1
                    ,sortFirstCharcterGroup1);
            int elementFromFourSameElements2 = getElementFromFourSameElements(countSameElement2
                    ,sortFirstCharcterGroup2);
            if(elementFromFourSameElements1>elementFromFourSameElements2)
                return s1;
            else
                return s2;
        }

        if(isFourWithOne1&&!isFourWithOne2){
            return s1;
        }
        if(!isFourWithOne1&&isFourWithOne2){
            return s2;
        }

        if(isThreeWithTwo1&&isThreeWithTwo2){   //判断两者是否都是三带二
            int ElementFromThreeSameElements1 = getElementFromThreeSameElements(countSameElement1
                    ,sortFirstCharcterGroup1);
            int ElementFromThreeSameElements2 = getElementFromThreeSameElements(countSameElement2
                    ,sortFirstCharcterGroup2);
            if(ElementFromThreeSameElements1>ElementFromThreeSameElements2)
                return s1;
            else
                return s2;
        }


        if(isStraight1&&!isStraight2){     //判断是否是顺子
            if(isThreeWithTwo2)    //判断是否含有3带2的字符串
                return s2;
            else
                return s1;
        }
        if(!isStraight1&&isStraight2){
            if(isThreeWithTwo1)
                return s1;
            else
                return s2;
        }

        if(countSameElement1[indexOfMaxLengthOfSameElement1]>countSameElement2[indexOfMaxLengthOfSameElement2]) //判断相同元素长度大小
            return s1;
        if(countSameElement1[indexOfMaxLengthOfSameElement1]<countSameElement2[indexOfMaxLengthOfSameElement2])
            return s2;

        for(int i=length1-1;i>=0;i--){   //单纯判断两组数据最大元素的大小
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
        for(int i=0;i<countSameElement1.length;i++){
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
        for(int i=0;i<myElementArray.length;i+=countSameElement[i]){
            for(int j=i+1;j<myElementArray.length;j++)
            if(myElementArray[i]==myElementArray[j]){
                countSameElement[i]++;
            }
        }
        return countSameElement;
    }

    public boolean isStraight(int[] sortFirstCharcterGroup){
        if(sortFirstCharcterGroup[sortFirstCharcterGroup.length-1]-sortFirstCharcterGroup[0]==4)
            return true;
        return false;
    }

    public boolean isContainThreeSameElementsAndTwoElements(int[] countSameElement){
        boolean isWithThree = false;
        boolean isWithTwo = false;
        boolean isThreeWithTwo = false;
        for(int i=0;i<countSameElement.length;i++){
            if(countSameElement[i]==3){
                isWithThree =true;
            }
            if(countSameElement[i]==2){
                isWithTwo = true;
            }
        }
        if(isWithThree&&isWithTwo)
            isThreeWithTwo = true;
        return isThreeWithTwo;
    }

    public boolean isFourWithOne(int[] countSameElement){
        boolean isFourWithOne = false;
        for (int i=0;i<countSameElement.length;i++){
            if(countSameElement[i]==4){
                isFourWithOne=true;
            }
        }
        return isFourWithOne;
    }

    public int getElementFromThreeSameElements(int[] countSameElement,int[] sortFirstCharcterGroup){
        for(int i=0;i<countSameElement.length;i++){
            if(countSameElement[i]==3){
                return sortFirstCharcterGroup[i];
            }
        }
        return -1;
    }

    public int getElementFromFourSameElements(int[] countSameElement,int[] sortFirstCharcterGroup){
        for(int i=0;i<countSameElement.length;i++){
            if(countSameElement[i]==4){
                return  sortFirstCharcterGroup[i];
            }
        }
        return -1;
    }
}
