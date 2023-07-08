package com.test.bobi.ahmad.rival.dans.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class BeanMapper {
    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private static MapperFacade mapper = mapperFactory.getMapperFacade();

    public static <S, C> C map(S source, Class<C> clazz) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, clazz);
    }
}
