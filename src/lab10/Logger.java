package lab10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Logger {
    private static final String fileName="log.txt";
    private static final String directName="logs";
    public static void log(String message){
        File folder = new File(directName);
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File log = new File(directName+ "/"+fileName);
        try {
            if (!log.exists()) {
                log.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileOutputStream(log,true));
            writer.println(message);
            writer.flush();//очищает буфер
            writer.close();
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }

    }
}
