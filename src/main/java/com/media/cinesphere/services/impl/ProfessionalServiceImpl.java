package com.media.cinesphere.services.impl;

import com.media.cinesphere.repositories.ProfessionalRepository;
import com.media.cinesphere.services.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {
    private final ProfessionalRepository professionalRepository;

    @Autowired
    public ProfessionalServiceImpl(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }


}
