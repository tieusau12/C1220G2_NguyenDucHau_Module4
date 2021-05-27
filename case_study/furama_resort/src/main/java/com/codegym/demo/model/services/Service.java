package com.codegym.demo.model.services;

import com.codegym.demo.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    private String serviceId;
    @Column(nullable = false)
    private String serviceName;
    private String standardRoom;
    private Double area;
    private Double poolArea;
    private Integer floor;
    private Integer maxPeople;
    private String descriptionOther;
    @Column(nullable = false)
    private Integer cost;
    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private TypeService typeService;
    @ManyToOne
    @JoinColumn(name = "service_rent_type_id", referencedColumnName = "rentTypeId")
    private RentTypeService rentTypeService;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<Contract> contracts;

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public RentTypeService getRentTypeService() {
        return rentTypeService;
    }

    public void setRentTypeService(RentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
