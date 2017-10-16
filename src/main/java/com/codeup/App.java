package com.codeup;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        boolean isBlank = StringUtils.isBlank("    ");
        System.out.println(isBlank);

    }
}