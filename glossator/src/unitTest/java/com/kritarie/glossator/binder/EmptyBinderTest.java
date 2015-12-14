package com.kritarie.glossator.binder;

import com.kritarie.glossator.model.PersonModel;
import com.kritarie.glossator.model.PlaceModel;
import com.kritarie.glossator.model.TestModel;
import com.kritarie.glossator.model.ThingModel;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by Sean on 12/13/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(resourceDir = "src/test/java/res")
public class EmptyBinderTest extends GlossaryBinderTest {

    private EmptyBinder<TestModel, PersonModel> emptyPersonBinder;
    private EmptyBinder<TestModel, PlaceModel> emptyPlaceBinder;
    private EmptyBinder<TestModel, ThingModel> emptyThingBinder;

    @Before
    public void setUp() throws Exception {
        emptyPersonBinder = new EmptyBinder<>(, PersonModel.class);
    }

    @Override
    public void testCreate() throws Exception {

    }

    @Override
    public void testHandlesViewType() throws Exception {

    }
}
