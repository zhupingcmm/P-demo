package com.mf.io.nio.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {

    @Test
    public void testWrite () {
        try (FileOutputStream os = new FileOutputStream(new File("basic.txt")); FileChannel fileChannel = os.getChannel()) {


            for (int i = 0; i < 1000000; i++) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                buffer.put("zp".getBytes());
                buffer.flip();
                fileChannel.write(buffer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRead() {
        try (FileInputStream in = new FileInputStream(new File("basic.txt"));
             FileOutputStream os = new FileOutputStream("basic1.txt");
             FileChannel fin = in.getChannel();
             FileChannel fos = os.getChannel();
             ) {

            fos.transferFrom(fin, 0, fos.size());

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
