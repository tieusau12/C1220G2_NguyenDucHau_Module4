package com.codegym.demo.model.contract;

import javax.persistence.*;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAttachService;
    @Column(nullable = false)
    String nameAttachService;
    @Column(nullable = false)
    Integer costAttachService;

    public AttachService() {

    }

    public Integer getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(Integer idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    public Integer getCostAttachService() {
        return costAttachService;
    }

    public void setCostAttachService(Integer costAttachService) {
        this.costAttachService = costAttachService;
    }
}
