package internetbanking.infra;

import internetbanking.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/bankAccounts")
@Transactional
public class BankAccountController {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @RequestMapping(
        value = "bankAccounts/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public BankAccount transferRequest(
        @PathVariable(value = "id") UUID id,
        @RequestBody TransferRequestCommand transferRequestCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /bankAccount/transferRequest  called #####");
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(
            id
        );

        optionalBankAccount.orElseThrow(() -> new Exception("No Entity Found"));
        BankAccount bankAccount = optionalBankAccount.get();
        bankAccount.transferRequest(transferRequestCommand);

        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }

    @RequestMapping(
        value = "bankAccounts/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public BankAccount processTransfer(
        @PathVariable(value = "id") UUID id,
        @RequestBody ProcessTransferCommand processTransferCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /bankAccount/processTransfer  called #####");
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(
            id
        );

        optionalBankAccount.orElseThrow(() -> new Exception("No Entity Found"));
        BankAccount bankAccount = optionalBankAccount.get();
        bankAccount.processTransfer(processTransferCommand);

        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }
}
//>>> Clean Arch / Inbound Adaptor
