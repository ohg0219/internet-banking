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
// @RequestMapping(value="/customerAccounts")
@Transactional
public class CustomerAccountController {

    @Autowired
    CustomerAccountRepository customerAccountRepository;

    @RequestMapping(
        value = "customerAccounts/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public CustomerAccount changePassword(
        @PathVariable(value = "id") UUID id,
        @RequestBody ChangePasswordCommand changePasswordCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /customerAccount/changePassword  called #####"
        );
        Optional<CustomerAccount> optionalCustomerAccount = customerAccountRepository.findById(
            id
        );

        optionalCustomerAccount.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        CustomerAccount customerAccount = optionalCustomerAccount.get();
        customerAccount.changePassword(changePasswordCommand);

        customerAccountRepository.save(customerAccount);
        return customerAccount;
    }
}
//>>> Clean Arch / Inbound Adaptor
