/*
 * Copyright 2013  Séven Le Mesle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package fr.xebia.extras.selma.it;

import fr.xebia.extras.selma.Selma;
import fr.xebia.extras.selma.beans.*;
import fr.xebia.extras.selma.it.mappers.BeanMapper;
import fr.xebia.extras.selma.it.mappers.CustomMapper;
import fr.xebia.extras.selma.it.mappers.CustomMapperSupport;
import fr.xebia.extras.selma.it.mappers.SourcedBeanMapper;
import fr.xebia.extras.selma.it.utils.Compile;
import fr.xebia.extras.selma.it.utils.IntegrationTestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test selma uses the factory
 */
@Compile(withClasses = {BeanMapper.class, CustomMapperSupport.class, CustomMapper.class, SourcedBeanMapper.class})
public class FactoredBeanMapperIT extends IntegrationTestBase {


    @Test
    public void should_use_source_for_bean_instantiation(){

        AddressIn in = new AddressIn();

        in.setCity(new CityIn());
        in.setExtras(Arrays.asList("one", "two", null, "three"));
        in.setNumber(1337);
        in.setStreet("HtwoGTwo");
        in.setPrincipal(false);
        in.getCity().setCapital(true);
        in.getCity().setName("Paris");
        in.getCity().setPopulation(13371337);
        DataSource dataSource = new DataSource();

        SourcedBeanMapper mapper = Selma.getMapper(SourcedBeanMapper.class, dataSource);

        AddressOutWithDataSource res = mapper.asAddressOut(in);

        Assert.assertNotNull(res);
        Assert.assertNotNull(res.dataSource);
        Assert.assertNotNull(res.getCity());
        Assert.assertNotNull(res.getCity().dataSource);
    }

}
