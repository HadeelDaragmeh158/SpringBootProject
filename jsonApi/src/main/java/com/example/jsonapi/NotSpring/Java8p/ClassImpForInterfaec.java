package com.example.jsonapi.NotSpring.Java8p;

public  class ClassImpForInterfaec implements DefaulteStaticMethodInterfaceJava8 , Interface2{

    public ClassImpForInterfaec() {
    }

    @Override
    public void method1(String str) {
        for (String s:
             str.split(" ")) {
            System.out.println(s);
        }
    }

    @Override
    public void method2() {
        System.out.println("YOU ARE IN METHOD TWO");
    }

    @Override
    public void log(String str) {
//        DefaulteStaticMethodInterfaceJava8.super.log(str); //it will go to interface 1
        System.out.println("MyClass logging::"+str);
        DefaulteStaticMethodInterfaceJava8.print("Hadeel");
    }

    @Override
    public void normalMethod(String[] str) {
        DefaulteStaticMethodInterfaceJava8.super.forEachTryDefault(str);
    }

    @Override
    public void forEachTryDefault(String[] str) {
        DefaulteStaticMethodInterfaceJava8.super.forEachTryDefault(str);
    }

    public static void forEachTryStatic(String[] str){
        for (String s : str) {
            System.out.println( s );
        }
    }
}
