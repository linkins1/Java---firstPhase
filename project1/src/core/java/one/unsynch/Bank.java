package core.java.one.unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * The type Bank.
 * 本类中给出了三种实现同步的方式
 * 1.采用ReentrantLock(锁)与Condition(条件对象)来实现同步
 * 2.采用synchronized关键字，使用类对象内部锁和条件来实现同步
 * 3.采用ReentrantReadWriteLock和Condition来实现同步
 */
//public class Bank {
//    private final double[] accounts;
//    private Lock bankLock ;
//    private Condition sufficientFunds;
//    public Bank(int n, double initialBalance) {
//        accounts = new double[n];
//        Arrays.fill(accounts, initialBalance);
//        bankLock = new ReentrantLock();
//        sufficientFunds = bankLock.newCondition();
//    }
//
//    public void transfer(int from, int to, double amount) throws InterruptedException {
//        bankLock.lock();
//        try{
//            while(accounts[from] < amount)
//                sufficientFunds.await();
//            System.out.println(Thread.currentThread());
//            accounts[from] -= amount;
//            System.out.printf("%10.2f from %d to %d", amount, from, to);
//            accounts[to] += amount;
//            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
//            sufficientFunds.signalAll();
//        }
//        finally {
//            bankLock.unlock();
//        }
//
//    }
//
//    public double getTotalBalance() {
//        bankLock.lock();
//        try{
//            double sum = 0;
//            for (double a : accounts)
//                sum += a;
//            return sum;
//        }finally {
//            bankLock.unlock();
//        }
//
//    }
//
//    public int size() {
//        return accounts.length;
//    }
//
//}

//public class Bank {
//    private final double[] accounts;
//    public Bank(int n, double initialBalance) {
//        accounts = new double[n];
//        Arrays.fill(accounts, initialBalance);
//    }
//
//    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
//            while(accounts[from] < amount)
//                wait();
//            System.out.println(Thread.currentThread());
//            accounts[from] -= amount;
//            System.out.printf("%10.2f from %d to %d", amount, from, to);
//            accounts[to] += amount;
//            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
//            notifyAll();
//    }
//
//    public synchronized double getTotalBalance() {
//            double sum = 0;
//            for (double a : accounts)
//                sum += a;
//            return sum;
//    }
//
//    public int size() {
//        return accounts.length;
//    }
//
//}
public class Bank {
    private final double[] accounts;
    private Condition sufficientFunds;
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();

    /**
     * Instantiates a new Bank.
     *
     * @param n              the n
     * @param initialBalance the initial balance
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        sufficientFunds=writeLock.newCondition();
    }

    /**
     * Transfer.
     *
     * @param from   the from
     * @param to     the to
     * @param amount the amount
     * @throws InterruptedException the interrupted exception
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        writeLock.lock();
        try
        {
            while(accounts[from] < amount)
                sufficientFunds.await();
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }finally {
            writeLock.unlock();
        }

    }

    /**
     * Gets total balance.
     *
     * @return the total balance
     */
    public double getTotalBalance() {
        readLock.lock();
        try{
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        }finally {
            readLock.unlock();
        }

    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return accounts.length;
    }

}
