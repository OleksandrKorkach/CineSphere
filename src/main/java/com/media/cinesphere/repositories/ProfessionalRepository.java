package com.media.cinesphere.repositories;

import com.media.cinesphere.entities.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Professional findProfessionalByName(String name);
}
