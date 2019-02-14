package com.interview.stripe;

import java.util.HashMap;

/**
 * Created by Jerry Wang on 2018/12/16.
 */
public class Interview {

    public void test(){
        HashMap<Integer,String> map = new HashMap<>();

        map.entrySet().stream().min((e1 ,e2)->(e1.getKey() - e2.getKey())).get();
    }

}
