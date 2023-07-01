import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


 class Myclass implements Comparator<String>
{


    @Override
    public int compare(String o1, String o2) {

      if(o1.length()>o2.length())
          return 1;
      else
          return -1;

    }
}

public class Main {


    public static void main(String[] args) {
    HashMap h1=new HashMap<Integer,String>();
    h1.put(1,"Tanim");
    h1.put(2,"Ibrahim");
    h1.put(3,"Adnan");

        System.out.println(h1.get(2));



    }


}
