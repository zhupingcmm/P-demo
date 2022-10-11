package com.mf.io.bio.file;

import org.junit.Test;

import java.io.*;

public class TestBIO {

    @Test
    public void testWrite() throws FileNotFoundException {

        try (FileOutputStream os = new FileOutputStream(new File("basic.txt"))){
            for(int i = 0; i<10000000; i++) {
                os.write("hello".getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRead() {
        try (FileInputStream in = new FileInputStream(new File("basic.txt")); FileOutputStream os = new FileOutputStream("basic1.txt") ){
            byte [] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes))!=-1){
                os.write(bytes, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
