package com.kritarie.glossator;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Sean on 12/13/2015.
 */
public class TimedTest {

    private static final Logger logger = Logger.getLogger("TimedTestLogger");

    private static void logInfo(Description description, String status, long nanos) {
        String testName = description.getMethodName();
        logger.info(String.format("Test %s %s, spent %d microseconds", testName, status, TimeUnit.NANOSECONDS.toMicros(nanos)));
    }

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void succeeded(long nanos, Description description) {
            logInfo(description, "succeeded", nanos);
        }

        @Override
        protected void failed(long nanos, Throwable e, Description description) {
            logInfo(description, "failed", nanos);
        }

        @Override
        protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
            logInfo(description, "skipped", nanos);
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, "finished", nanos);
        }
    };

}
