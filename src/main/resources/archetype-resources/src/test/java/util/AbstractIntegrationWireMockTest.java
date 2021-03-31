package ${package}.util;

import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

/**
 * Class responsible to create integration tests with wiremock server. The server is going to start
 * with host http://localhost:9999.
 *
 * To register stubs automatically add stub files in /test/resources/mappings folder
 */
@AutoConfigureWireMock(port = 9999)
public abstract class AbstractIntegrationWireMockTest extends AbstractIntegrationTest {
}
