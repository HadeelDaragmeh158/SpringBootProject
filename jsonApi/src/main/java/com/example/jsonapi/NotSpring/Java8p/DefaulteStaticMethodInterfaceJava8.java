package com.example.jsonapi.NotSpring.Java8p;

public interface DefaulteStaticMethodInterfaceJava8 {

    void method1(String str);

    default void log(String str){
        System.out.println("Interface 1 logging :"+str);
    }

    static void print(String str){
        System.out.println("Printing "+str);
    }

    void normalMethod(String[] str);

    default void forEachTryDefault (String[] str){
        for (String s : str) {
            System.out.println( s );
        }
    }

     static void forEachTryStatic(String[] str){
        for (String s : str) {
            System.out.println( s );
        }
    }

}
