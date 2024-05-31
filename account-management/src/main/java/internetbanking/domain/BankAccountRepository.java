package internetbanking.domain;

import internetbanking.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "bankAccounts",
    path = "bankAccounts"
)
public interface BankAccountRepository
    extends PagingAndSortingRepository<BankAccount, UUID> {}
