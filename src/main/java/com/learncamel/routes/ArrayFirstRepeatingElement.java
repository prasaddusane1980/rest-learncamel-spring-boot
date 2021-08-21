package com.learncamel.routes;

import java.util.LinkedHashMap;

public class ArrayFirstRepeatingElement {


    public static void main(String[] args) {
        Integer [] arr= new Integer[]{5,3,4,5,1,4,3};
        LinkedHashMap<Integer,Integer> lhmp=new LinkedHashMap<Integer,Integer>();
        for (int num:arr)
        {
            if(!lhmp.containsKey(num))
            {
                lhmp.put(num,1);
            }else
            {
                lhmp.put(num,lhmp.get(num)+1);
            }
        }

        for (Integer key:lhmp.keySet()){
            System.out.println("Key :"+key +"count :"+lhmp.get(key));
        }
    }

}
