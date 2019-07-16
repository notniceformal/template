/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nnf;

import com.nnf.adapter.AppUserAdapter;
import com.nnf.domain.AppUser;
import com.nnf.dto.AppUserDTO;
import com.nnf.repository.UserRepository;
import com.nnf.service.CustomUserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class AppUserTests {

    @Autowired
    CustomUserService service;

    @Autowired
    AppUserAdapter adapter;

    @Autowired
    UserRepository userRepository;

    private UserDetails userDetails;
    private AppUserDTO appUserDTO;

    @Ignore
    @Before
    public void setup() throws Exception {

        appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("email@nnf.com");
        appUserDTO.setPassword("password");
        appUserDTO.setYearOfBirth(1987);
        appUserDTO.setFirstName("Notnice");
        appUserDTO.setLastName("Formal");
        appUserDTO.setCitizenCountryCode("ZA");
        appUserDTO.setPhoneCountryCode("+27");
        appUserDTO.setPhoneNumber("0844299882");
        List<String> roles = new ArrayList<>();
        roles.add("TEST");
        appUserDTO.setRoles(roles);

    }

    @After
    public void clear() {
        userRepository.deleteAll();
    }

    @Test
    public void checkUserWhenNewCreateThenSuccess() throws Exception {

        // When
        userRepository.save(adapter.toDo(appUserDTO));
        AppUser userDO = userRepository.findByEmail(appUserDTO.getEmail());

        // Then
        Assert.assertNotNull(userDO);
        Assert.assertEquals(userDO.getCitizenCountryCode(), "ZA");
        Assert.assertEquals(userDO.getFirstName(), "Notnice");
        Assert.assertEquals(userDO.getLastName(), "Formal");
        Assert.assertEquals(userDO.getPhoneCountryCode(), "+27");
        Assert.assertEquals(userDO.getPhoneNumber(), "0844299882");
        Assert.assertEquals(userDO.getYearOfBirth().intValue(), 1987);
        Assert.assertTrue(userDO.getRoles().contains("TEST"));
        Assert.assertTrue(userDO.getRoles().size() == 1);
        Assert.assertEquals(userDO.getEmail(), "email@nnf.com");
        Assert.assertEquals(userDO.getPassword(), "password");

    }
}