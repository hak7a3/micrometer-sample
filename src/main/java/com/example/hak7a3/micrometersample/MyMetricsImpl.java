package com.example.hak7a3.micrometersample;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

@Component
public class MyMetricsImpl implements MyMetrics, MeterBinder {

    private Counter hogeCounter;
    private Counter fugaCounter;

    @Override
    public void bindTo(MeterRegistry registry) {
        hogeCounter = Counter.builder("sample")
            .tag("name", "hoge")
            .register(registry);
        fugaCounter = Counter.builder("sample")
            .tag("name", "fuga")
            .register(registry);
    }

    @Override
    public void countHoge(int increment) {
        hogeCounter.increment(increment);
    }

    @Override
    public void countFuga(int increment) {
        fugaCounter.increment(increment);
    }
    
}