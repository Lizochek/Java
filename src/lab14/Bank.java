package lab14;

import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException
    {
        Account from,to;
        from = getAccounts().get(fromAccountNum);
        to = getAccounts().get(toAccountNum);
        if(from.getAccNumber().compareTo(to.getAccNumber())>0) {
            from.available.acquire();
            to.available.acquire();
        }
        else {
            to.available.acquire();
            from.available.acquire();
        }
        if(!from.getIsBlocked() && !to.getIsBlocked() && from.getMoney()>=amount )
        {
            if(amount>50000 && isFraud(fromAccountNum,toAccountNum,amount)){
                from.blockAccount();
                to.blockAccount();
            }
            else {
                from.deductMoney(amount);
                to.addMoney(amount);
            }
        }

        if(from.getAccNumber().compareTo(to.getAccNumber())<=0) {
            from.available.release();
            to.available.release();
        }
        else {
            to.available.release();
            from.available.release();
        }


    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return getAccounts().get(accountNum).getMoney();
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }
}