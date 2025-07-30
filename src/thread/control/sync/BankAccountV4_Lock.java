package thread.control.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4_Lock implements BankAccount{

    private int balance;    //잔액

    private final Lock lock = new ReentrantLock();

    public BankAccountV4_Lock(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdrow(int amount) {
        log("거래 시작 : "+getClass().getSimpleName());

        lock.lock(); //ReentrantLock 이용하여  lock을 걸기
        try{
            log("[검증 시작] 출금액 : "+amount + ", 잔액 : "+balance);
            // 잔고가 출금액 보다 적으면, return false
            if( balance < amount ){
                log("[검증 실패]");
                return false;
            }

            // 잔고가 출금액보다 많으면 진행
            log("[검증 완료] 출금액 : "+amount + ", 잔액 : "+balance);
            sleep(1000);
            balance = balance - amount;
            log("[출금 완료] 출금액 : "+amount + ", 잔액 : "+balance);

        } finally {
            lock.unlock();//ReentrantLock 이용하여  lock을 해제
        }
        log("거래 종료");
        return false;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try{
            return balance;
        }finally {
            lock.unlock();
        }

    }
}
