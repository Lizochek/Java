package lab14;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Account

{
    private AtomicLong money =new AtomicLong();
    private String accNumber;
    private AtomicBoolean isBlocked= new AtomicBoolean(false);
    public final Semaphore available = new Semaphore(1, true);
    public Account(String s,long n){
        accNumber=s;
        money.set(n);
    }

    public long getMoney() {
        return money.get();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public Boolean getIsBlocked() {
        return isBlocked.get();
    }

    public void addMoney(long money) {
        this.money.set(this.money.get()+money) ;
    }
    public void deductMoney(long money) {
        this.money.set(this.money.get()-money) ;
    }
    public void blockAccount(){
        isBlocked.set(true);
    }
}