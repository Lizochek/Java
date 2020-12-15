package lab11_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class BankStatement {
    public String Organization;
    public double Receipt;
    public double Expense;
public BankStatement(String st,double r,double e){
    Organization =st;
    Receipt=r;
    Expense =e;
}
    //Парсинг CSV файла по указанному пути и получение продуктов из него
    public static Map<String,BankStatement> ParseProductCsv(String filePath) throws IOException {
        HashMap<String,BankStatement> data = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        br.readLine();
        while(br.ready()){
            String[] sc = br.readLine().split(",");
            /*Parse org*/
            String org;
            String d[]=sc[5].split(" ");
            org= d[d.length-1];
            /*Parse sell*/
            double rc,ex;
            String src=sc[sc.length-1];
            if(src.charAt(src.length()-1)=='"')
            {
                src=sc[sc.length-2]+"."+sc[sc.length-1];
                src=src.replace("\"","");
                ex=Double.parseDouble(sc[6]);
            }
            else{
                String src1;
                src1=sc[sc.length-2];
                if(src1.charAt(src1.length()-1)=='"')
                {
                    src1=sc[sc.length-3]+"."+sc[sc.length-2];
                    src1=src1.replaceAll("\"","");
                }
                ex=Double.parseDouble(src1);
            }
            rc=Double.parseDouble(src);

            if(data.containsKey(org)){
                data.get(org).Receipt+=rc;
                data.get(org).Expense+=ex;
            }
            else {
                String fullOrgName=sc[5];
                //Распарсить полное название из fullOrgName ,используя регулярные выражения

                data.put(org, new BankStatement(fullOrgName, rc, ex));
            }
        }
        return data;

      /*  //Загружаем строки из файла
        List<BankStatement> products = new ArrayList<BankStatement>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<String>();
            for (int i = 0; i < splitedText.length; i++) {
                //Если колонка начинается на кавычки или заканчиваеться на кавычки
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + ","+ splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }
            }
            BankStatement product = new BankStatement();
            product.AccountType = columnList.get(0);
            product.AccountNumber = columnList.get(1);
            product.Currency = columnList.get(2);
            product.TransactionDate = columnList.get(3);
            product.TransactionReference = columnList.get(4);
            product.TransactionDescription = columnList.get(5);
            product.Receipt= columnList.get(6);
            product.Expense = columnList.get(7);
            products.add(product);
        }
        return products;*/
    }
 @Override
 public String toString(){
    return String.format("%s: \n\tПриход: %f \n\tРасход: %f",Organization,Receipt,Expense);
 }
    //Проверка является ли колонка частью предыдущей колонки
   /* private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf(",") == trimText.lastIndexOf(",") && trimText.endsWith(",");
    }*/
}
