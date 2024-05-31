package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TransactionHistoryChecked extends AbstractEvent {

    private UUID accountId;

    public TransactionHistoryChecked(BankAccount aggregate) {
        super(aggregate);
    }

    public TransactionHistoryChecked() {
        super();
    }
}
//>>> DDD / Domain Event
