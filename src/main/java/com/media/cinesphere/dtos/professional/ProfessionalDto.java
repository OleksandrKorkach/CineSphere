package com.media.cinesphere.dtos.professional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.entities.Professional;

import javax.persistence.Column;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessionalDto {
    private Long id;
    private Set<String> roles;
    private String name;
    private String biography;

    public static ProfessionalDto fromProfessional(Professional professional){
        ProfessionalDto dto = new ProfessionalDto();
        dto.setId(professional.getId());
        dto.setRoles(professional.getRoles());
        dto.setName(professional.getName());
        dto.setBiography(professional.getBiography());
        return dto;
    }

    public Professional toProfessional(ProfessionalDto dto){
        Professional professional = new Professional();
        professional.setName(dto.getName());
        professional.setRoles(dto.getRoles());
        professional.setBiography(dto.getBiography());
        return professional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
