package internetbanking.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ChangePasswordCommand {

    private UUID accountId;
    private Password newPassword;
}
