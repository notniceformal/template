package com.nnf.adapter;

import com.nnf.domain.DomainObjectTemplate;
import com.nnf.dto.DomainTransferObjectTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdapterTemplate {


    public DomainObjectTemplate toDo(DomainTransferObjectTemplate dto) {
        DomainObjectTemplate domainObj = new DomainObjectTemplate();
        domainObj.setColumnName(dto.getFieldName());
        if (dto.getId() != null){
            domainObj.setId(dto.getId());
        }
        return domainObj;
    }

    public DomainTransferObjectTemplate toDTO(DomainObjectTemplate domainObj) {
        DomainTransferObjectTemplate dto = new DomainTransferObjectTemplate();
        dto.setFieldName(domainObj.getColumnName());
        dto.setId(domainObj.getId());
        return dto;
    }

    public List<DomainTransferObjectTemplate> toDTOs(List<DomainObjectTemplate> allDOs) {
        List<DomainTransferObjectTemplate> allDTOs = new ArrayList<>();
        for ( DomainObjectTemplate domainObj : allDOs ) {
            DomainTransferObjectTemplate dto = toDTO(domainObj);
            allDTOs.add(dto);
        }
        return allDTOs;
    }
}
