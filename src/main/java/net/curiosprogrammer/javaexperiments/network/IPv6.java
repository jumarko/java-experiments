package net.curiosprogrammer.javaexperiments.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * IPv5 demo.
 * See https://docs.oracle.com/javase/8/docs/technotes/guides/net/ipv6_guide/index.html
 * Also https://stackoverflow.com/questions/19273348/creating-a-client-socket-in-java-with-remote-address-is-in-inet4address-format-a
 */
public class IPv6 {


    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("google.sk", 80
                // doesn't work for some reasons :( 
//                ,InetAddress.getByName("2a00:1028:c400:d1:2def:5c7a:65c5:cf1d"), 0
                );


    }
}
