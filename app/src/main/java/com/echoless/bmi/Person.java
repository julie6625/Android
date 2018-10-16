package com.echoless.bmi;

public class Person {
    portal p = new wormportal() ;//必須再新增的class裡繼承load方法才可使用

    portal p2 = new wormportal(){
        @Override
        public void load() {
        }
    }; //方法2

}
