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
    CustomerAccountRepository customerAccountRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TransferProcessed'"
    )
    public void wheneverTransferProcessed_TransferProcessedPolicy(
        @Payload TransferProcessed transferProcessed
    ) {
        TransferProcessed event = transferProcessed;
        System.out.println(
            "\n\n##### listener TransferProcessedPolicy : " +
            transferProcessed +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
