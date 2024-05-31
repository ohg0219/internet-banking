package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PasswordSaved extends AbstractEvent {

    private UUID accountId;

    public PasswordSaved(CustomerAccount aggregate) {
        super(aggregate);
    }

    public PasswordSaved() {
        super();
    }
}
//>>> DDD / Domain Event
