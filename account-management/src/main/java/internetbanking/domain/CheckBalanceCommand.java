package internetbanking.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CheckBalanceCommand {

    private UUID accountId;
}
