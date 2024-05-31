package internetbanking.domain;

import internetbanking.CustomerManagementApplication;
import internetbanking.domain.AccountChecked;
import internetbanking.domain.AccountInformationProvided;
import internetbanking.domain.PasswordSaved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CustomerAccount_table")
@Data
//<<< DDD / Aggregate Root
public class CustomerAccount {

    @Id
    private UUID accountId;

    private Money accountBalance;

    private List<Transaction> transactionHistory;

    private Password password;

    @PostPersist
    public void onPostPersist() {
        AccountChecked accountChecked = new AccountChecked(this);
        accountChecked.publishAfterCommit();

        AccountInformationProvided accountInformationProvided = new AccountInformationProvided(
            this
        );
        accountInformationProvided.publishAfterCommit();

        PasswordSaved passwordSaved = new PasswordSaved(this);
        passwordSaved.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static CustomerAccountRepository repository() {
        CustomerAccountRepository customerAccountRepository = CustomerManagementApplication.applicationContext.getBean(
            CustomerAccountRepository.class
        );
        return customerAccountRepository;
    }

    //<<< Clean Arch / Port Method
    public void changePassword(ChangePasswordCommand changePasswordCommand) {
        //implement business logic here:

        PasswordChanged passwordChanged = new PasswordChanged(this);
        passwordChanged.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
