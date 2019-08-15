package com.practice.reactor.mono;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

public class CreateMonoTest {

    private Mono<Integer> monoForTest;

    @Test
    public void createMonoFromPojo()
    {
        Integer simplePojo = new Integer(42);
        givenAMonoFromAPojo(simplePojo);
        thenTheMonoShouldContain(simplePojo);
    }

    @Test
    public void createAnEmptyMono()
    {
        givenAnEmptyMono();
        thenTheMonoShouldCompleteWithoutEmitAnything();
    }

    @Test
    public void createMonoFromOptional()
    {
        Optional<Integer> optional = Optional.of(42);
        givenAMonoFromOptional(optional);
        thenTheMonoShouldContain(optional.get());
    }

    private void givenAMonoFromOptional(Optional<Integer> simplePojo) {
        monoForTest = null;
    }

    private void givenAnEmptyMono() {
        monoForTest = null;
    }

    private void givenAMonoFromAPojo(Integer simplePojo) {
        monoForTest = null;
    }


    private void thenTheMonoShouldCompleteWithoutEmitAnything() {
        createVerifier()
                .verifyComplete();
    }

    private StepVerifier.FirstStep<Integer> createVerifier() {
        return StepVerifier
                .create(monoForTest);
    }

    private void thenTheMonoShouldContain(Integer simplePojo) {
        createVerifier()
                .expectNext(simplePojo)
                .verifyComplete();
    }
}