package internetbanking.domain;

import internetbanking.AccountManagementApplication;
import internetbanking.domain.TransactionHistoryChecked;
import internetbanking.domain.TransactionHistoryProvided;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BankAccount_table")
@Data
//<<< DDD / Aggregate Root
public class BankAccount {

    @Id
    private UUID accountId;

    private Money accountBalance;

    private List<Transaction> transactionHistory;

    @PostPersist
    public void onPostPersist() {
        TransactionHistoryChecked transactionHistoryChecked = new TransactionHistoryChecked(
            this
        );
        transactionHistoryChecked.publishAfterCommit();

        TransactionHistoryProvided transactionHistoryProvided = new TransactionHistoryProvided(
            this
        );
        transactionHistoryProvided.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static BankAccountRepository repository() {
        BankAccountRepository bankAccountRepository = AccountManagementApplication.applicationContext.getBean(
            BankAccountRepository.class
        );
        return bankAccountRepository;
    }

    //<<< Clean Arch / Port Method
    public void transferRequest(TransferRequestCommand transferRequestCommand) {
        //implement business logic here:

        TransferRequested transferRequested = new TransferRequested(this);
        transferRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void processTransfer(ProcessTransferCommand processTransferCommand) {
        //implement business logic here:

        TransferProcessed transferProcessed = new TransferProcessed(this);
        transferProcessed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
