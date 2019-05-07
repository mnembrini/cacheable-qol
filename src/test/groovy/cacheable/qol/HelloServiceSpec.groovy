package cacheable.qol

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Subject

import javax.inject.Inject

@MicronautTest
class HelloServiceSpec extends Specification {

  @Inject
  @Subject
  HelloService helloService

  void "test caching with configured name"() {

    when:
    helloService.setCounter(0)
    helloService.sayHello()
    helloService.sayHello()

    then:
    helloService.getCounter() == 1

  }

  void "test caching without name"() {

    when:
    helloService.setCounter(0)
    helloService.sayHelloWithoutCacheName()
    helloService.sayHelloWithoutCacheName()

    then:
    helloService.getCounter() == 1

  }

  void "test caching with name but no config"() {

    when:
    helloService.setCounter(0)
    helloService.sayHelloWithoutConfiguredCache()
    helloService.sayHelloWithoutConfiguredCache()

    then:
    helloService.getCounter() == 1

  }
}
