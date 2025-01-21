package com.xinwen.example.node03;

/**
 * @author shenlx
 * @description
 * @date 2025/1/16 11:45
 */
public class OtherServcice {
    public static void main(String[]args){
        //int s= 757500;
        int s= 756100;

        int count =0;
        int count1=0;
        while(count<271){
            s++;
            String s1 = String.valueOf(s);
            //System.out.println(s1);
            if(!s1.contains("4")){
                count++;
                System.out.println("运行次数:"+count+"结果:"+s);
            }else {
                count1++;
                System.out.println("----运行次数:"+count1+"结果:"+s);
            }
        }
    }

}
