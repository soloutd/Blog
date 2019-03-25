package blog.Blog;

import java.util.HashMap;
import java.util.Hashtable;

public class exampleString {
    public static void main(String [] a){
        String s1 ="Solomon";
        String s2 ="Solomon";
        String s3 = new String("Solomon");
        String s4 = new String("Solomon");

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s2==s1);
        System.out.println(s1==s3);
        System.out.println(s4==s3);

        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"Solmon");
        hashMap.put(1,"Solomon");
        System.out.println(hashMap.get(1));

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1,"solo");
        hashtable.put(1,"solomon");
        System.out.println(hashtable.get(1));
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("New thread created");
            }
        });
        thread.start();
        //System.out.println(Thread.currentThread().getName()+" solo");
        thread.run();
        thread.run();
    }

}
