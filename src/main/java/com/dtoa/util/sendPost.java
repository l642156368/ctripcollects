package com.dtoa.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class sendPost {

    public static void main(String[] args) {
        RequestUtil r = new RequestUtil();
        try {
            System.out.println( "111111111111111111111" );
            String resultString = r.load(
                    "http://dtoa.zhangwin.com:11117/universal/personnel",
                    "018530" );
            System.out.println( "ssssssssss" + resultString );
        } catch (Exception e) {

            // TODO: handle exception

            System.out.print( "aaaa" + e.getMessage() );

        }
        System.out.println( "2222222222222" );

    }


}
