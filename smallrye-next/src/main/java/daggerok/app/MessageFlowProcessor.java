package daggerok.app;

import lombok.extern.log4j.Log4j2;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@Log4j2
@ApplicationScoped
public class MessageFlowProcessor {

    @Incoming("source")
    @Outgoing("processed-a")
    public String toUpperCase(@Observes String payload) {
        return payload.toUpperCase();
    }

    @Incoming("processed-a")
    @Outgoing("processed-b")
    public PublisherBuilder<String> filter(PublisherBuilder<String> input) {
        return input.filter(item -> item.length() > 4);
    }

    @Incoming("processed-b")
    public void sink(@Observes String word) {
        log.info(">> {}", word);
    }
}
