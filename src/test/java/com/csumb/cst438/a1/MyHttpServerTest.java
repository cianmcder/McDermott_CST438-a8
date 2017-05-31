/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csumb.cst438.a1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.sun.net.httpserver.Headers;
import java.io.File;

/**
 *
 * @author david wisneski
 * @version 1.0
 * last update 3-21-2017
 */

public class MyHttpServerTest {
    
    public MyHttpServerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class MyHttpServer.
     */
    @Test
    public void testHandle() {
        String expectedBody = "<!DOCTYPE html><html><head><title>MyHttpServer</title></head>" + 
                "<body><h2>Hangman</h2><img src=\"h1.gif\"><h2 style=\"font-family:'Lucida Console', monospace\">" +
                " _ _ _ _ _ _ _ _</h2><form action=\"/\" method=\"get\"> Guess a character <input type=\"text\" name=\"guess\"><br>" +
                "<input type=\"submit\" value=\"Submit\"></form></body></html>";



    Headers header = new Headers();
    try {
        TestHttpExchange t = new TestHttpExchange("/", header);
        MyHttpServer.MyHandler handler = new MyHttpServer.MyHandler();
        handler.handle(t);
        // check response for cookie returned, response code=200, and expected response body 
        Headers response = t.getResponseHeaders();
        String cookie1 = response.getFirst("Set-cookie");
        assertEquals("Bad content type", "text/html", response.getFirst("Content-type"));
        assertNotNull("No cookie returned", cookie1);
        assertEquals("Bad response code.",200, t.getResponseCode());
        assertEquals("Bad response body.",expectedBody, t.getOstream().toString());
    } catch (Exception e) {
        fail("unexpected exception in testHandle "+e.getMessage());
    }
    }
    
    /*
     * Test for successfully downloading h1.gif
     */
    @Test
    public void testH1() {
        String path = "src/main/resources/h1.gif";
        File h1 = new File(path);
        try {
            //Checks if h1.gif exists in the directory using File h1
            assertTrue(h1.exists() == true);
        }
        catch (Exception e) {
            fail("404 - File not found "+e.getMessage());
        }
    }
    
    /*
     * Test that non-existing h9.gif is not downloaded, and error message is printed
     */
    @Test
    public void testH9() {
        String path = "src/main/resources/h9.gif";
        File h9 = new File(path);
        try {
            //Checks if h9.gif exists using File h9
            assertTrue(h9.exists() == true);
        }
        catch (Exception e) {
            fail("404 - File not found "+e.getMessage());
        }
    }
}
