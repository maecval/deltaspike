/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.test.core.api.invocationhandler.uc002;

import org.apache.deltaspike.test.core.api.invocationhandler.shared.PartialBeanBinding;
import org.apache.deltaspike.test.core.api.invocationhandler.shared.TestBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@PartialBeanBinding
@RequestScoped
public abstract class PartialBean
{
    private String value;

    @Inject
    private TestBean testBean;

    public abstract String getResult();

    @PostConstruct
    protected void onCreate()
    {
        this.value = "manual";
    }

    @PreDestroy
    protected void onDestroy()
    {
        //TODO check in a test
    }

    public String getManualResult()
    {
        return this.value + "-" + this.testBean.getValue();
    }
}