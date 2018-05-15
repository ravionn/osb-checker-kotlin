package de.evoila.osb.checker.tests

import com.greghaskins.spectrum.Spectrum
import de.evoila.osb.checker.Application
import de.evoila.osb.checker.config.Configuration
import io.restassured.RestAssured
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestContextManager


@RunWith(Spectrum::class)
@AutoConfigureMockMvc
@SpringBootTest(classes = [Application::class])
abstract class TestBase {


  @Autowired
  lateinit var configuration: Configuration


  final fun wireAndUnwire() {

    val testContextManager = TestContextManager(this.javaClass)
//    val wire = this.javaClass.getMethod("wireAndUnwire", Boolean::class.java)

    testContextManager.beforeTestClass()
    testContextManager.prepareTestInstance(this)


    RestAssured.baseURI = configuration.url
    RestAssured.port = configuration.port
    RestAssured.authentication = RestAssured.basic("admin", "cloudfoundry")
  }


}