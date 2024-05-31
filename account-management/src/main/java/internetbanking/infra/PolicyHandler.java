package internetbanking.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import internetbanking.config.kafka.KafkaProcessor;
import internetbanking.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AccountChecked'"
    )
    public void wheneverAccountChecked_AccountCheckedPolicy(
        @Payload AccountChecked accountChecked
    ) {
        AccountChecked event = accountChecked;
        System.out.println(
            "\n\n##### listener AccountCheckedPolicy : " +
            accountChecked +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
