package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TransferRequested extends AbstractEvent {

    private UUID fromAccountId;
    private UUID toAccountId;
    private Money amount;

    public TransferRequested(BankAccount aggregate) {
        super(aggregate);
    }

    public TransferRequested() {
        super();
    }
}
//>>> DDD / Domain Event
