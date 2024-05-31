package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TransferProcessed extends AbstractEvent {

    private UUID fromAccountId;
    private UUID toAccountId;
    private Money amount;

    public TransferProcessed(BankAccount aggregate) {
        super(aggregate);
    }

    public TransferProcessed() {
        super();
    }
}
//>>> DDD / Domain Event
