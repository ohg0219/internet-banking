package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AccountChecked extends AbstractEvent {

    private UUID accountId;

    public AccountChecked(CustomerAccount aggregate) {
        super(aggregate);
    }

    public AccountChecked() {
        super();
    }
}
//>>> DDD / Domain Event
