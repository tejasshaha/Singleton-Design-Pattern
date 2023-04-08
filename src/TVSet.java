public class TVSet {

    private static volatile TVSet TVSetInstance=null;

    private TVSet() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Inside constructor");
    }

    public static TVSet getInstance() throws InterruptedException {

            if(TVSetInstance==null){
                synchronized (TVSet.class){
                    if(TVSetInstance==null){ // Double locking
                        TVSetInstance= new TVSet();
                    }
            }
        }
        // some heavy transactions
        return TVSetInstance;
    }
}
