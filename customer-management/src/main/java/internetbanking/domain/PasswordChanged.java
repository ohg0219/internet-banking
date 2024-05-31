package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PasswordChanged extends AbstractEvent {

    private UUID accountId;

    public PasswordChanged(CustomerAccount aggregate) {
        super(aggregate);
    }

    public PasswordChanged() {
        super();
    }
}
//>>> DDD / Domain Event
