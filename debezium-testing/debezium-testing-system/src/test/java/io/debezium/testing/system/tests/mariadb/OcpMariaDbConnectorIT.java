/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.testing.system.tests.mariadb;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import io.debezium.testing.system.assertions.KafkaAssertions;
import io.debezium.testing.system.fixtures.OcpClient;
import io.debezium.testing.system.fixtures.connectors.MariaDbConnector;
import io.debezium.testing.system.fixtures.databases.ocp.OcpMariaDb;
import io.debezium.testing.system.fixtures.kafka.OcpKafka;
import io.debezium.testing.system.fixtures.operator.OcpStrimziOperator;
import io.debezium.testing.system.tools.databases.mariadb.MariaDbController;
import io.debezium.testing.system.tools.kafka.ConnectorConfigBuilder;
import io.debezium.testing.system.tools.kafka.KafkaConnectController;
import io.debezium.testing.system.tools.kafka.KafkaController;

import fixture5.FixtureExtension;
import fixture5.annotations.Fixture;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("acceptance")
@Tag("mariadb")
@Tag("openshift")
@Fixture(OcpClient.class)
@Fixture(OcpStrimziOperator.class)
@Fixture(OcpKafka.class)
@Fixture(OcpMariaDb.class)
@Fixture(MariaDbConnector.class)
@ExtendWith(FixtureExtension.class)
public class OcpMariaDbConnectorIT extends MariaDBTests {

    public OcpMariaDbConnectorIT(KafkaController kafkaController,
                                 KafkaConnectController connectController,
                                 ConnectorConfigBuilder connectorConfig,
                                 KafkaAssertions<?, ?> assertions,
                                 MariaDbController dbController) {
        super(kafkaController, connectController, connectorConfig, assertions, dbController);
    }
}
