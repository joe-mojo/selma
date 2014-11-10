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
package fr.xebia.extras.selma.codegen;

import com.squareup.javawriter.JavaWriter;
import fr.xebia.extras.selma.Mapper;

import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.List;

/**
 * Class used to wrap the Mapper Annotation
 */
public class MapperWrapper {
    public static final String WITH_IGNORE_FIELDS = "withIgnoreFields";
    public static final String WITH_ENUMS = "withEnums";
    private final FieldsWrapper fields;
    private final SourceConfiguration configuration;
    private final IgnoreFieldsWrapper ignoreFieldsWrapper;
    private final MappingRegistry mappingRegistry;
    private final CustomMapperWrapper customMappers;
    private final ImmutableTypesWrapper immutablesMapper;
    private final AnnotationWrapper mapper;
    private final EnumMappersWrapper enumMappers;

    public MapperWrapper(MapperGeneratorContext context, TypeElement element) {

        mappingRegistry = new MappingRegistry(context);


        mapper = AnnotationWrapper.buildFor(context, element, Mapper.class);

        List<String> ignoreFieldsParam = mapper.getAsStrings(WITH_IGNORE_FIELDS);

        ignoreFieldsWrapper = new IgnoreFieldsWrapper(context, element, ignoreFieldsParam);
        configuration = SourceConfiguration.buildFrom(mapper, ignoreFieldsWrapper);
        fields = new FieldsWrapper(context, element, mapper);

        mappingRegistry.fields(fields);

        // Here we collect custom mappers
        customMappers = new CustomMapperWrapper(element, context);
        mappingRegistry.customMappers(customMappers);

        enumMappers = new EnumMappersWrapper(withEnums(), context);
        mappingRegistry.enumMappers(enumMappers);

        immutablesMapper = new ImmutableTypesWrapper(mapper, context);
        mappingRegistry.immutableTypes(immutablesMapper);

    }


    public List<AnnotationWrapper> withEnums() {
        return mapper.getAsAnnotationWrapper(WITH_ENUMS);
    }

    public void buildEnumForMethod(MethodWrapper methodWrapper) {
        enumMappers.buildForMethod(methodWrapper);
    }

    public boolean isFinalMappers() {

        return configuration.isFinalMappers();
    }

    public MappingRegistry registry() {
        return mappingRegistry;
    }

    public SourceConfiguration configuration() {
        return configuration;
    }

    public void reportUnused() {

        // Report unused customMappers
        customMappers.reportUnused();

        // Report unused ignore fields
        ignoreFieldsWrapper.reportUnusedFields();

        // Report unused custom fields mapping
        fields.reportUnused();

        // Report unused enumMapper
        enumMappers.reportUnused();
        immutablesMapper.reportUnused();
    }

    public void emitCustomMappersFields(JavaWriter writer, boolean assign) throws IOException {
        customMappers.emitCustomMappersFields(writer, assign);
    }
}
