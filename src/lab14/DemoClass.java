package lab14;

import java.util.Random;
public class DemoClass {
    public static void main(String[] args) {
        final Random random = new Random();
        Bank b = new Bank();
        for(int i=0;i<5;i++) {
            String ac = String.format("%d", i);
            b.getAccounts().put(ac, new Account(ac, 1000000));
        }
        for(int i=0;i<5;i++)
        {
            String ac = String.format("%d",i);
            new Thread(() ->{
                for(int j=0;j<10;j++)
                {
                    String s1= String.format("%d",random.nextInt(5));
                    if(s1.compareTo(ac)==0) continue;
                    int amount=random.nextInt(90000);
                    System.out.println(String.format("prepare trans %d from %s to %s amount of %d",j,ac,s1,amount)+
                            String.format("\n \t account balance %s: %d ,blocked status: %s",
                                    ac,b.getBalance(ac),b.getAccounts().get(ac).getIsBlocked().toString())+
                            String.format("\n \taccount balance %s: %d ,blocked status: %s",
                                    s1,b.getBalance(s1),b.getAccounts().get(s1).getIsBlocked().toString()));
                    try {
                        b.transfer(ac,s1,amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format("after trans %d from %s to %s amount of %d",j,ac,s1,amount)+
                            String.format("\n\t account balance %s: %d ,blocked status: %s",
                                    ac,b.getBalance(ac),b.getAccounts().get(ac).getIsBlocked().toString())+
                            String.format("\n\t account balance %s: %d ,blocked status: %s",
                                    s1,b.getBalance(s1),b.getAccounts().get(s1).getIsBlocked().toString()));
                }
            }).start();

        }

    }
}
