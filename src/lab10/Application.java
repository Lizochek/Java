package lab10;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {

    public static void main(String[] args) {
        printFolderSize();
        duplicateFolder();
    }
    public static void printFolderSize(){
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        Logger.log("Введен путь: " + path);
        File f = new File(path);
        if(!f.exists() || !f.isDirectory()) {
            Logger.log("Введеный путь некорректный");
            System.err.println("Введеный путь некорректный");
            return;
        }
        long size=0;
        Queue<File> q = new PriorityQueue<File>();
        q.add(f);
        while(!q.isEmpty()){
            File fl= q.poll();
            for(File i: fl.listFiles())
            {
                if(i.isDirectory()) {q.add(i);}
                else size+=i.length();
            }
        }
        System.out.println(size);
        Logger.log("Размер папки D:\\Games составляет 56,6 Гб");
    }
    public static void duplicateFolder(){
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        Logger.log("Введен путь1: " + path);
        File f1 = new File(path);
        if(!f1.exists() || !f1.isDirectory()) {
            Logger.log("Введеный путь некорректный");
            System.err.println("Введеный путь некорректный");
            return;
        }
         path = sc.nextLine();
        Logger.log("Введен путь2: " + path);
        File f2 = new File(path);
        if(!f2.exists() || !f2.isDirectory()) {
            Logger.log("Введеный путь некорректный");
            System.err.println("Введеный путь некорректный");
            return;
        }
       long filesCount = 0;
        Queue<File> q = new PriorityQueue<File>();
        q.add(f1);
        while(!q.isEmpty()){
            File fl= q.poll();
            for(File i: fl.listFiles())
            {
                File f = new File(f2.getPath() + i.getPath().substring(f1.getPath().length()));
                //
                if(i.isDirectory()) {
                    q.add(i);
                    f.mkdir();
                }
                else{
                    try {
                        Files.copy(Paths.get(i.getPath()),
                                Paths.get(f.getPath()),
                                StandardCopyOption.REPLACE_EXISTING);
                        filesCount++;
                    }catch (IOException ex)
                    {
                        System.err.println("Ошибка при копировании файла: "+ ex.getMessage());
                        Logger.log("Ошибка при копировании файла: "+ ex.getMessage());
                    }
                }
            }
        }
        System.out.println("Копирование завершено,скопированно: "+ filesCount);
        Logger.log("Копирование завершено,скопированно: "+ filesCount);
    }
}
