package com.interview.stripe;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Jerry Wang on 03/10/2018.
 */
public class test {

    public static void main(String args[]){
        String url = "amount=1000&merchant=123456789&destination[account]=111111&destination[" +
                "amount]=877";
        List<NameValuePair> xixi = URLEncodedUtils.parse(url, Charset.defaultCharset());
        for(NameValuePair ss : xixi){
            System.out.print(ss.getName());
            System.out.println(ss.getValue());
        }
    }

}
