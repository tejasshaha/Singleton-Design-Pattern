public class Main {
    public static void main(String[] args){
//        TVSet tvSet1 = TVSet.getInstance();
//        TVSet tvSet2 = TVSet.getInstance();
//        System.out.println(tvSet1);
//        System.out.println(tvSet2);

        new Thread(()->{
            try {
                TVSet tvSet3 = TVSet.getInstance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread1").start();

        new Thread(()->{
            try {
                TVSet tvSet4=TVSet.getInstance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread2").start();
    }
}

/*
    Singleton Design Pattern

    - It restricts instantiation of class to single object.
    - In above example we need to create single object of TVSet.
    - If we write TVSet tvSet1 = new TVSet()
                  TVSet tvSet2 = new TVSet()
      then it will invoke constructor twice and two different objects will be created.
    - To avoid this we need to make constructor private and need to invoke constructor once from TVSet.java class
    - After making constructor private , initially we will initialize TVSetInstance=null
    - create 1 static method to return instance.
    *why static object and method ?
    - Static method belongs to the class not object so from main class we can call static method.

    *How to make it thread safe ?
    - We can use synchronize keyword to method but what if there are some heavy transactions before returning
      object so we can make synchronize only while invoking constructor
    - Now we have sleep in constructor.
    - So at that time 2nd thread will invoke and create the 2nd object.
    - To avoid this we'll use double lock means we'll check TVSetInstance=null twice.
    - Now it is thread safe :)
 */