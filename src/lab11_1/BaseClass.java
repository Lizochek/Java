package lab11_1;

import java.io.IOException;
import java.util.Map;

public class BaseClass {
    public static void main(String[] args) throws IOException {
       final String filePath = "movementList.csv";
        Map<String,BankStatement> m = BankStatement.ParseProductCsv(filePath);
       for(String org: m.keySet()){
           System.out.println(m.get(org));
       }
    }

}
