package com.farzoom.lime.ehd.config;

import com.farzoom.common.business.genparam.GenParamService;
import com.farzoom.common.business.genparam.impl.GenParamServiceImpl;
import com.farzoom.common.business.ref.RefService;
import com.farzoom.common.business.ref.impl.RefServiceImpl;
import com.farzoom.common.persistence.es.repositories.AddressRepository;
import com.farzoom.common.persistence.es.repositories.AttributeRepository;
import com.farzoom.common.persistence.es.repositories.GroupRepository;
import com.farzoom.common.persistence.es.repositories.ParamRepository;
import com.farzoom.common.persistence.es.repositories.base.EsRepository;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    RefService refService(EsRepository esRepository) {
        return new RefServiceImpl(esRepository);
    }

    @Bean
    GenParamService genParamService(AttributeRepository attributeRepository,
                                    GroupRepository groupRepository,
                                    ParamRepository paramRepository,
                                    RefService refService,
                                    AddressRepository addressRepository) {
        return new GenParamServiceImpl(attributeRepository, groupRepository, paramRepository, refService, addressRepository);
    }
}
