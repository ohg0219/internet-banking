package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class AccountChecked extends AbstractEvent {

    private Object accountId;
}
