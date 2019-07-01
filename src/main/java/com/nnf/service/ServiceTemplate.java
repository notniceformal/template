package com.nnf.service;

import com.google.common.collect.Lists;
import com.nnf.adapter.AdapterTemplate;
import com.nnf.domain.DomainObjectTemplate;
import com.nnf.dto.DomainTransferObjectTemplate;
import com.nnf.repository.RepositoryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTemplate {

    @Autowired
    RepositoryTemplate repositoryTemplate;

    @Autowired
    AdapterTemplate adapterTemplate;

    public DomainObjectTemplate saveTemplate(DomainTransferObjectTemplate dto) {

        DomainObjectTemplate tableRow = adapterTemplate.toDo(dto);
        repositoryTemplate.save(tableRow);

        return tableRow;
    }

    public DomainTransferObjectTemplate findTemplate(DomainObjectTemplate domainObj) {
        DomainObjectTemplate resultRow = repositoryTemplate.findByColumnName(domainObj.getColumnName());
        DomainTransferObjectTemplate dto = adapterTemplate.toDTO(resultRow);
        return dto;
    }

    public List<DomainTransferObjectTemplate> allTemplates() {
        List<DomainObjectTemplate> allRows = Lists.newArrayList(repositoryTemplate.findAll());
        List<DomainTransferObjectTemplate> allDTOs = adapterTemplate.toDTOs(allRows);
        return allDTOs;
    }

    public DomainTransferObjectTemplate findDTOById(DomainTransferObjectTemplate dto) {
        DomainObjectTemplate domainObj = adapterTemplate.toDo(dto);
        Optional<DomainObjectTemplate> rowEntry = repositoryTemplate.findById(domainObj.getId());
        DomainTransferObjectTemplate convertedDTO = new DomainTransferObjectTemplate();
        if (rowEntry.isPresent()) {
            convertedDTO = adapterTemplate.toDTO(rowEntry.get());
        }

        return convertedDTO;
    }
}
