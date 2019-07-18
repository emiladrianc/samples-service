package com.demo.ss.services;

import com.demo.ss.services.domains.SampleDomain;

import java.util.List;

public interface SamplesService {

    SampleDomain get(int id);

    List<SampleDomain> get();
}
