/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.spring.boot.converters;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.LinkedHashSet;
import java.util.Set;

public class KubernetesConverterServiceFactory extends ConversionServiceFactoryBean {

    private KubernetesClient kubernetesClient;

    public KubernetesConverterServiceFactory(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
        this.setConverters(createConverters());
    }

    private Set<Converter> createConverters() {
        Set<Converter> converters = new LinkedHashSet<>();
        ServiceToString serviceToString = new ServiceToString(kubernetesClient);
        ServiceToUrl serviceToUrl = new ServiceToUrl(serviceToString);
        converters.add(serviceToString);
        converters.add(serviceToUrl);
        return converters;
    }
}

