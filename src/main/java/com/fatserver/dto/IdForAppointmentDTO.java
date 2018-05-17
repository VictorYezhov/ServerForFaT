package com.fatserver.dto;

public class IdForAppointmentDTO {
    private Long id_employ;
    private Long id_employer;

    public IdForAppointmentDTO() {
    }

    public IdForAppointmentDTO(Long id_employ, Long id_employer) {
        this.id_employ = id_employ;
        this.id_employer = id_employer;
    }

    public Long getId_employ() {
        return id_employ;
    }

    public void setId_employ(Long id_employ) {
        this.id_employ = id_employ;
    }

    public Long getId_employer() {
        return id_employer;
    }

    public void setId_employer(Long id_employer) {
        this.id_employer = id_employer;
    }
}
