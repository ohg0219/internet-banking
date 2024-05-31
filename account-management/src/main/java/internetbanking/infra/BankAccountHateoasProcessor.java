package internetbanking.infra;

import internetbanking.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BankAccountHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<BankAccount>> {

    @Override
    public EntityModel<BankAccount> process(EntityModel<BankAccount> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
