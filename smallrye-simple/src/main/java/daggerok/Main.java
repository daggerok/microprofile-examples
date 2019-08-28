package daggerok;

import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.TimeUnit;

@Log4j2
@ApplicationScoped
public class Main {

    public static void main(String[] args) {

        Try.run(() -> SeContainerInitializer.newInstance()
                                            .initialize())
           .andThenTry(() -> TimeUnit.SECONDS.sleep(3))
           .onSuccess(aVoid -> log.info("Hey!"))
           .onFailure(throwable -> log.error("oops {}", throwable.getLocalizedMessage()));
    }
}
