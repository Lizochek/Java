package laba9;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class DemoClass {
    public static void main(String[] args) {
        Generator g = new Generator();
        ArrayList<String> numbsList = g.generate();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        long startTime = System.nanoTime();
        boolean has = numbsList.contains(s);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("Поиск прямым перебором по ArrayList вернул %s," +
                " затраченно времени %dns",has,estimatedTime));

        Collections.sort(numbsList);
        startTime = System.nanoTime();
        int pos = Collections.binarySearch(numbsList,s);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("Поиск бинарным поиском по сортированному ArrayList вернул %d," +
                " затраченно времени %dns",pos,estimatedTime));

        HashSet<String > hs = new HashSet<>(g.generate());
        startTime = System.nanoTime();
        has = hs.contains(s);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("Поиск поиском в HashSet вернул %s," +
                " затраченно времени %dns",has,estimatedTime));

        TreeSet<String>  tr = new TreeSet<>(g.generate());
        startTime = System.nanoTime();
        has = tr.contains(s);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("Поиск в TreeSet вернул %s," +
                " затраченно времени %dns",has,estimatedTime));
    }

}

