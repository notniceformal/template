package com.nnf.adapter;

import com.nnf.domain.AppUser;
import com.nnf.dto.AppUserDTO;
import org.springframework.stereotype.Component;

@Component
public class AppUserAdapter {

    public AppUser toDo(AppUserDTO dto) {

        AppUser domainObj = new AppUser();
        domainObj.setCitizenCountryCode(dto.getCitizenCountryCode());
        domainObj.setFirstName(dto.getFirstName());
        domainObj.setLastName(dto.getLastName());
        domainObj.setEmail(dto.getEmail());
        domainObj.setPassword(dto.getPassword());
        domainObj.setPhoneCountryCode(dto.getPhoneCountryCode());
        domainObj.setPhoneNumber(dto.getPhoneNumber());
        domainObj.setYearOfBirth(dto.getYearOfBirth());
        domainObj.setRoles(dto.getRoles());

        return domainObj;
    }

    public AppUserDTO toDTO(AppUser domainObj) {

        AppUserDTO dto = new AppUserDTO();
        dto.setEmail(domainObj.getEmail());
        dto.setCitizenCountryCode(domainObj.getCitizenCountryCode());
        dto.setFirstName(domainObj.getFirstName());
        dto.setLastName(domainObj.getLastName());
        dto.setPassword(domainObj.getPassword());
        dto.setPhoneCountryCode(domainObj.getPhoneCountryCode());
        dto.setPhoneNumber(domainObj.getPhoneNumber());
        dto.setYearOfBirth(domainObj.getYearOfBirth());
        dto.setRoles(domainObj.getRoles());

        return dto;
    }

}
