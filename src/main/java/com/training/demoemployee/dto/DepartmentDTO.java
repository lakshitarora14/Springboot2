package com.training.demoemployee.dto;

public class DepartmentDTO {
    private int id;
    private String name;
    private String code;
    private int parentDepartment;
    private int organizationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(int parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
