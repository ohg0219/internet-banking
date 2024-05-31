package internetbanking.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CheckTransactionHistoryCommand {

    private UUID accountId;
    private Date startDate;
    private Date endDate;
}
