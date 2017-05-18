package com.gcd.utility;

import com.gcd.dao.DatabaseService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class QueueUtilityTest {

    QueueUtility utility;

    @Mock
    DatabaseService databaseService;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testGetSum(){
        when(databaseService.getGCDSum()).thenReturn(156);
        utility = new QueueUtility(databaseService);
        assertThat(utility.gcdSum(),is(156));
    }

}