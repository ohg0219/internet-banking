package internetbanking.infra;

import internetbanking.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CustomerAccount>> {

    @Override
    public EntityModel<CustomerAccount> process(
        EntityModel<CustomerAccount> model
    ) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
