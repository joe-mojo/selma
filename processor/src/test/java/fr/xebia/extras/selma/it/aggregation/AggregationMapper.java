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
package fr.xebia.extras.selma.it.aggregation;

import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import fr.xebia.extras.selma.beans.AggregatedBean;
import fr.xebia.extras.selma.beans.FirstBean;
import fr.xebia.extras.selma.beans.SecondBean;

/**
 * This mapper interface demonstrate the use of Bean Aggregation.
 */
@Mapper(withIgnoreFields = "missingProperty")
public interface AggregationMapper {

    AggregatedBean mapFromAggregate(FirstBean first, SecondBean second);

    @Maps(withCustom = AggregatedInterceptor.class)
    AggregatedBean mapFromAggregateWithInterceptor(FirstBean first, SecondBean second);

    AggregatedBean mapFromAggregateInUpdate(FirstBean first, SecondBean second, AggregatedBean out);
}
