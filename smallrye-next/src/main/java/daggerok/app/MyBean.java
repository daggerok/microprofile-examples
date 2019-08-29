package daggerok.app;

import io.vavr.control.Try;
import lombok.Getter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MyBean {

    @Getter
    private final CopyOnWriteArrayList<String> messages = new CopyOnWriteArrayList<>();

    @Outgoing("source")
    public PublisherBuilder<String> source() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        return ReactiveStreams.generate(System::currentTimeMillis)
                              .map(aLong -> "ololo trololo " + aLong)
                              .takeWhile(s -> {
                                  countDownLatch.countDown();
                                  Try.run(() -> TimeUnit.SECONDS.sleep(1));
                                  return countDownLatch.getCount() > 0;
                              });
    }

    // @Outgoing("source")
    // public PublisherBuilder<String> publish() {
    //     String[] strings = messages.toArray(new String[0]);
    //     return ReactiveStreams.of(strings);
    // }

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
        System.out.println(">> " + word);
    }
}
