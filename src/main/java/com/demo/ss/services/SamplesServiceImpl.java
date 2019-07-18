package com.demo.ss.services;

import com.demo.ss.services.domains.SampleDomain;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Stateless
public class SamplesServiceImpl implements SamplesService {

    private static final Logger logger = Logger.getLogger(SamplesServiceImpl.class);

    public SampleDomain get(final int id) {
        logger.info(String.format("Getting sample for id: %d", id));
        return getSample(id);
    }

    private SampleDomain getSample(final int id) {
        return SampleDomain.builder().id(id).name(String.format("Sample %d", id)).build();
    }

    public List<SampleDomain> get() {
        final Random random = new Random();

        final List<SampleDomain> samples = new ArrayList<SampleDomain>();
        final int randomNumber = random.nextInt(3) + 2;
        logger.info(String.format("Getting %d samples", randomNumber));
        for (int i = 0; i < randomNumber; i++) {
            samples.add(getSample(i));
        }

        return samples;
    }
}
