package io;

public class IOTest {

    //Input Output

    // IO는 byte와 char단위의 입출력 클래스로 나뉘어진다.

    // Byte단위 클래스는 inputStream과 OutputStream 추상클래스를 상속받아서 만들어진다.
    // char단위 클래스는 Reader와 Writer 추상클래스를 상속받아서 만들어진다.

    // 자바 IO는 데코레이터 패턴으로 만들어져있다.
    // 하나의 클래스를 장식하는 것처럼 생성자에서 감싸서 새로운 기능을 계속 추가 할 수 있도록 클래스를 만드는 방식

    //                              Decorator Pattern
    // 하나의 클래스를 장식하는 것처럼 생성자에서 감싸서 새로운 기능을 계속 추가 할 수 있도록 클래스를 만드는 방식
    //--------------byte--------------------   --------------char------------------
    // InputStream          OutputStream            Reader          Writer
    //-----------------------------   장식대상클래스   ------------------------------
    // FileInputStream      FileOutputStream        FileReader      FileWriter
    // ByteArrayInputStream ByteArrayOutputStream   CharReader      CharWriter
    //-----------------------------   장식하는클래스   ------------------------------
    // DateInputStream      DateOutputStream        BufferedReader  PrintWriter

    // 그래서 클래스가 하나만 생성되어서 사용하는게 아니다.
    // 여러개 클래스를 생성하여 생성자에 넣고 넣고 사용한다.


}
