package internetbanking.domain;

import internetbanking.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "customerAccounts",
    path = "customerAccounts"
)
public interface CustomerAccountRepository
    extends PagingAndSortingRepository<CustomerAccount, UUID> {}
