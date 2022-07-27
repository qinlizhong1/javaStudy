package annotation;

class DoSomthing{
    @Deprecated
    public void showV1(){
        System.out.println("showV1");
    }

    public void showV2(String message){
        System.out.println("入参:" + message);
        System.out.println("showV2");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        DoSomthing doSomthing = new DoSomthing();
        doSomthing.showV1();
    }
}
