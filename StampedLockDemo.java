package session09;

import java . util . concurrent . locks . StampedLock;
public class StampedLockDemo {
    private final StampedLock stampedLock = new StampedLock();
    private double balance;

    public StampedLockDemo(double balance) {
        this.balance = balance;
        System.out.println("Available balance: " + balance);
    }

    public void deposit(double amount) {
        System.out.println(" \nAbout to deposit $ : " + amount);
        long stamp = stampedLock.writeLock();
        System.out.println("Applied read lock");
        try {
            balance += amount;
            System.out.println("Available balance : " + balance);
        } finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("Unlocked write lock");
        }
    }

    public void withdraw(double amount) {
        System.out.println(" \nAbout to withdraw $ : " + amount);
        long stamp = stampedLock.writeLock();
        System.out.println("Appliedwrite lock");
        try {
            balance -= amount;
            System.out.println("Available balance: " + balance);
        } finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("Unlocked write lock");
        }
    }

    public double checkBalance() {
        System.out.println(" \nAbout to check balance");
        long stamp = stampedLock.readLock();
        System.out.println("Applied read lock");
        try {
            System.out.println("Available balance : " + balance);
            return balance;
        } finally {
            stampedLock.unlockRead(stamp);
            System.out.println("Unlocked read lock");
        }
    }

    public double checkBalanceOptimisticRead() {
        System.out.println(" \nAbout to check balance with optimistic read lock");
        long stamp = stampedLock.tryOptimisticRead();
        System.out.println("Appliednon-blocking optimistic read lock");
        double balance = this.balance;
        if (!stampedLock.validate(stamp)) {
            System.out.println("Stamp have changed. Applying full-blown read lock. ");
            stamp = stampedLock.readLock();
            try {
                balance = this.balance;
            } finally {
                stampedLock.unlockRead(stamp);
                System.out.println("Unlocked read lock");
            }
        }
        System.out.println("Available balance: " + balance);
        return balance;
    }

    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo = new StampedLockDemo(4000);
        stampedLockDemo.withdraw(1000);
        stampedLockDemo.deposit(5000);
        stampedLockDemo.checkBalance();
        stampedLockDemo.checkBalanceOptimisticRead();
    }
}


