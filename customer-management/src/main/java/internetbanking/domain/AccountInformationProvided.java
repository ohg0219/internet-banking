package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AccountInformationProvided extends AbstractEvent {

    private UUID accountId;

    public AccountInformationProvided(CustomerAccount aggregate) {
        super(aggregate);
    }

    public AccountInformationProvided() {
        super();
    }
}
//>>> DDD / Domain Event
