package com.nnf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomainTransferObjectTemplate implements Comparable<DomainTransferObjectTemplate>{

    @JsonProperty("id")
    private Integer id;

    @NotNull
    @JsonProperty("field_name")
    private String fieldName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "DomainTransferObjectTemplate{" +
                "fieldName='" + fieldName + '\'' +
                '}';
    }

    @Override
    public int compareTo(DomainTransferObjectTemplate o) {
        int result = this.toString().compareTo(o.toString());
        return result;
    }
}
