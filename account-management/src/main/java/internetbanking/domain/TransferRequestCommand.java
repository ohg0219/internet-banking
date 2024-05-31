package internetbanking.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class TransferRequestCommand {

    private UUID fromAccountId;
    private UUID toAccountId;
    private Money amount;
}
