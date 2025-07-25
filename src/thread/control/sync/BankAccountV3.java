package thread.control.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount{

    private int balance;    //잔액

    public BankAccountV3(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdrow(int amount) {
        log("거래 시작 : "+getClass().getSimpleName());

        // 임계영역 시작
        synchronized (this){
            log("[검증 시작] 출금액 : "+amount + ", 잔액 : "+balance);
            // 잔고가 출금액 보다 적으면, return false
            if( balance < amount ){
                log("[검증 실패]");
                return false;
            }
        }

        synchronized (this){
            // 잔고가 출금액보다 많으면 진행
            log("[검증 완료] 출금액 : "+amount + ", 잔액 : "+balance);
            sleep(1000);
            balance = balance - amount;
            log("[출금 완료] 출금액 : "+amount + ", 잔액 : "+balance);
        }
        // 임계영역 종료

        log("거래 종료");
        return false;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
