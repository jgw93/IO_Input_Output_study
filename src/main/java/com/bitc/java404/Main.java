package com.bitc.java404;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("자바 input/output stream 사용하기");

        JavaInputStream jis = new JavaInputStream();
        try {
            System.out.println("\n--------read()---------\n");
            jis.read1();
            System.out.println("\n--------read(byte[] buff)---------\n");
            jis.read2();
            System.out.println("\n--------read(byte[] buff, int offset, int length)---------\n");
            jis.read3();
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류 발생");
            e.printStackTrace();
        }

        JavaOutputStream jos = new JavaOutputStream();
        try {
            System.out.println("\n----------write()---------\n");
            jos.write1("C:\\java404\\testwrite1.txt");
            System.out.println("\n----------write(byte[] buff)---------\n");
            jos.write2("C:\\java404\\testwrite2.txt");
            System.out.println("\n----------write(byte[] buff, int off, int len)---------\n");
            jos.write3("C:\\java404\\testwrite3.txt");
            System.out.println("\n-----------ex1-----------\n");
            jos.quiz1();
            System.out.println("\n-----------ex2-----------\n");
            jos.quiz2();
            System.out.println("\n-----------ex3-----------\n");
            jos.quiz3();
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류 발생");
            e.printStackTrace();
        }

        JavaReader jr = new JavaReader();
        try {
            System.out.println("\n--------read1()---------\n");
            jr.read1();
            System.out.println("\n--------read2()---------\n");
            jr.read2("C:\\java404\\test2.txt");
            System.out.println("\n--------read3()---------\n");
            jr.read3("C:\\java404\\test2.txt");
        } catch (Exception e) {
            System.out.println("파일을 읽는 도중 오류 발생");
        }

        JavaWriter jw = new JavaWriter();
        try {
            System.out.println("\n----------write1()----------\n");
            jw.write1("C:\\java404\\test3write1.txt");
            System.out.println("\n----------write2()----------\n");
            jw.write2("C:\\java404\\test3write2.txt");
            System.out.println("\n----------write3()----------\n");
            jw.write3("C:\\java404\\test3write3.txt");
            System.out.println("\n----------write4()----------\n");
            jw.write3("C:\\java404\\test3write4.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            File file = new File("C:\\java404\\testFile3.txt");

            if (file.exists()) {
                System.out.println("기존의 파일이 존재합니다.");
            } else {
                System.out.println("새 파일을 생성합니다.");
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File file = new File("C:\\java404");
            String[] fileList = file.list();

            for (int i = 0; i < fileList.length; i++) {
                System.out.println("이름 : " + fileList[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Buffered buf = new Buffered();
        try {
            System.out.println("\n------------버퍼 없이 실행--------------\n");
            buf.inputStreamEx();
            System.out.println("\n------------버퍼로 실행--------------\n");
            buf.bufInputStreamEx();
            System.out.println("\n------------키보드 입력을 버퍼로 실행--------------\n");
            buf.buffReaderEx();
        } catch (Exception e) {
        }
    }
}