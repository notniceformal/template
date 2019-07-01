package com.nnf.repository;

import com.nnf.domain.DomainObjectTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTemplate extends CrudRepository<DomainObjectTemplate, Integer> {

    DomainObjectTemplate findByColumnName(String columnName);

}
