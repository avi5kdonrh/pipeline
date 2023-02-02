/**
 *  Copyright 2005-2016 Red Hat, Inc.
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
package io.fabric8.quickstarts.camel.amq;

import org.apache.activemq.artemis.jms.client.ActiveMQJMSConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.messaginghub.pooled.jms.JmsPoolConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * The Spring-boot main class.
 */
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application {

    Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    CoreConfiguration coreConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "jms")
    JmsComponent jms(CoreConfiguration config) {


        String remoteURI = config.getUrl();

        ActiveMQJMSConnectionFactory activeMQConnectionFactory = new ActiveMQJMSConnectionFactory(remoteURI, config.getUser(), config.getPassword());
        JmsPoolConnectionFactory jmsPoolConnectionFactory = new JmsPoolConnectionFactory();
        jmsPoolConnectionFactory.setMaxConnections(coreConfiguration.getMaxConnections());
        jmsPoolConnectionFactory.setMaxSessionsPerConnection(coreConfiguration.getMaxSessionsPerConnection());
        JmsComponent jmsComponent = new JmsComponent();
        jmsComponent.setConnectionFactory(jmsPoolConnectionFactory);
        return jmsComponent;
    }

}
