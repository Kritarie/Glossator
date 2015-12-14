package com.kritarie.glossator.binder;

import com.kritarie.glossator.TimedTest;

import org.junit.Test;

/**
 * Created by Sean on 12/13/2015.
 */
public abstract class GlossaryBinderTest extends TimedTest {

    @Test
    public abstract void testCreate() throws Exception;

    @Test
    public abstract void testHandlesViewType() throws Exception;
}
