package com.processingFIle;

import com.emad.exception.FooRuntimeException;

public class MyFileUtils {

    public int subract10FromLargeNumber(int number) throws Exception{
           if(number < 10){
               throw new FooRuntimeException("The passed was smaller than 10 ");
           }
            return  number - 10;
    }


}
