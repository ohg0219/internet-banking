package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TransactionHistoryProvided extends AbstractEvent {

    private UUID accountId;

    public TransactionHistoryProvided(BankAccount aggregate) {
        super(aggregate);
    }

    public TransactionHistoryProvided() {
        super();
    }
}
//>>> DDD / Domain Event
