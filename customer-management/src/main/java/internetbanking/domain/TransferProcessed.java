package internetbanking.domain;

import internetbanking.domain.*;
import internetbanking.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class TransferProcessed extends AbstractEvent {

    private Object fromAccountId;
    private Object toAccountId;
    private Object amount;
}
