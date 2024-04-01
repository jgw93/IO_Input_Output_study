package com.bitc.java404;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JavaOutputStream {
    // write() 사용하기
    // 매개변수로 파일의 이름을 받아와서 사용
    public void write1(String filename) throws IOException {
        // OutputStream 은 모든 byte 타입 스트림의 최상위 클래스이며
        // 추상 클래스이므로 객체 생성 불가능
        // 부모 클래스인 OutputStream 클래스 타입의 변수에 자식 클래스인 FileOutputStream
        // 클래스 타입의 객체를 저장하여 사용함
        OutputStream os = new FileOutputStream(filename);
        // byte[] 배열 data 에 입력하고자 하는 문자열을 byte 타입으로 변환하여 저장함
        byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();

        // byte[] 배열에 저장된 테이터를 파일에 쓰기
        for (int i = 0; i < data.length; i++) {
            // write() 를 사용하여 실행 시 마다 1byte 씩 파일에 쓰기
            os.write(data[i]);
        }
        os.flush(); // 버퍼에 저장된 내용을 즉시 파일에 쓰기
        os.close(); // 파일 닫기
    }

    // write(byte[] buff) 사용하기
    public void write2(String fileName) throws IOException {
        // 파일 열기
        OutputStream os = new FileOutputStream(fileName);
        // byte[] 배열에 저장된 테이터를 파일에 쓰기
        byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
        // write(byte[] buff) 를 사용하여 byte[] 배열에 저장된 내용을 한번에 쓰기
        os.write(data);
        os.flush(); // 버퍼에 저장된 내용을 파일에 쓰기
        os.close(); // 파일 닫기
    }

    // write(byte[] buff, int off, int len) 사용하기
    public void write3(String filename) throws IOException {
        OutputStream os = new FileOutputStream(filename);
        byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
        // write(byte[] buff, int off, int len) 를 사용하여 byte[] 배열의 내용 중
        // 지정한 index 에서 부터 지정한 크기의 데이터를 파일에 옮김
        os.write(data, 5, 5);
        os.flush();
        os.close();
    }

    // 문제 1) 사용자 입력을 통해서 파일 이름을 입력받고 해당 파일의 내용을 화면에
    // 출력하는 프로그램을 작성하세요.
    // 파일명 : quiz1.txt
    // 원본 내용 : 영어로 아무거나
    public void quiz1() throws IOException {
        InputStream ex1 = new FileInputStream("C:\\java404\\quiz1.txt");
        int readByteNO;
        byte[] readBytes = new byte[5];
        String data = "";

        while (true) {
            readByteNO = ex1.read(readBytes);
            if (readByteNO == -1) {
                break;
            }
            data += new String(readBytes, 0, readByteNO);
        }
        System.out.println(data);
        ex1.close();
    }

    // 문제 2) 기존에 존재하는 파일을 열고 사용자 입력을 통해서 입력받은 내용을 기존 파일의
    // 뒤에 추가하는 프로그램을 작성하세요
    // 파일명 : quiz2.txt
    // 원본 내용 : network programing

    public void quiz2() throws IOException {

    }

    // 문제 3) 사용자 입력을 통해서 파일의 원본 파일의 이름과 사본 파일의 이름을 입력받고,
    // 원본 파일의 내용을 사본 파일에 저장하는 프로그램을 작성하세요.
    // 파일명 : quiz3.txt

    public void quiz3() throws IOException {
        OutputStream ex3 = new FileOutputStream("C:\\java404\\quiz3.txt");
        InputStream ex2 = new FileInputStream("C:\\java404\\quiz2.txt");

        byte[] readBytes = new byte[20];

        for (int i = 0; i < readBytes.length; i++) {
        }
        ex3.write(ex2.readAllBytes());
        ex3.flush();
        ex3.close();
        ex2.close();
    }


}
