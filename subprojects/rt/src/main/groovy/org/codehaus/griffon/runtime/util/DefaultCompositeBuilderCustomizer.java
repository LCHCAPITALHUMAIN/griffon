/*
 * Copyright 2008-2011 the original author or authors.
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
package org.codehaus.griffon.runtime.util;

import groovy.lang.Closure;
import groovy.util.Factory;
import org.codehaus.griffon.runtime.builder.UberBuilder;

/**
 * Default implementation of the <code>CompositeBuilderCustomizer</code> interface.
 *
 * @author Andres Almiray
 * @since 0.9.3
 */
public class DefaultCompositeBuilderCustomizer implements CompositeBuilderCustomizer{
    public void registerFactory(UberBuilder uberBuilder, String name, String groupName, Factory factory) {
        uberBuilder.registerFactory(name, groupName, factory);
    }

    public void registerBeanFactory(UberBuilder uberBuilder, String name, String groupName, Class<?> beanClass) {
        uberBuilder.registerBeanFactory(name, groupName, beanClass);
    }

    public void registerExplicitMethod(UberBuilder uberBuilder, String name, String groupName, Closure method) {
        uberBuilder.registerExplicitMethod(name, groupName, method);
    }

    public void registerExplicitProperty(UberBuilder uberBuilder, String name, String groupName, Closure getter, Closure setter) {
        uberBuilder.registerExplicitProperty(name, groupName, getter, setter);
    }
}
