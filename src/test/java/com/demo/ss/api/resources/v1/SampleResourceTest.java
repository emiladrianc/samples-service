package com.demo.ss.api.resources.v1;

import com.demo.ss.api.models.SampleModel;
import com.demo.ss.api.resources.SampleResource;
import com.demo.ss.services.SamplesService;
import com.demo.ss.services.domains.SampleDomain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class SampleResourceTest {

    @InjectMocks
    private SampleResource sampleResource;

    @Mock
    private SamplesService samplesService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void get_success() {
        final List<SampleDomain> sampleDomains = new ArrayList<>();
        sampleDomains.add(SampleDomain.builder().id(1).name("name").build());
        when(samplesService.get()).thenReturn(sampleDomains);

        final Response response = sampleResource.get();
        Assert.assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());

        final List<SampleModel> sampleModels = (List<SampleModel>) response.getEntity();
        Assert.assertNotNull(sampleModels);
        Assert.assertFalse(sampleModels.isEmpty());
    }

    @Test
    public void getById_ok() {

        final SampleDomain sampleDomain = SampleDomain.builder().id(1).name("name").build();
        when(samplesService.get(anyInt())).thenReturn(sampleDomain);

        final Response response = sampleResource.getById(1);
        Assert.assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
        final SampleModel sampleModel = (SampleModel) response.getEntity();
        Assert.assertNotNull(sampleModel);
    }
}