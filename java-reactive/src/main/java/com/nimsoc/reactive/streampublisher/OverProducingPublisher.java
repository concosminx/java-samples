package com.nimsoc.reactive.streampublisher;

import com.nimsoc.reactive.crypto.Crypto;

import java.util.UUID;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class OverProducingPublisher extends SubmissionPublisher<Crypto> {

  public void start() {
    Stream<Crypto> cryptoStream = Stream
            .generate(()
                    -> new Crypto(
                    UUID.randomUUID().toString(),
                    ThreadLocalRandom.current().nextFloat()
            )
            );

    cryptoStream.limit(100_000).forEach(this::submit);
  }

}
