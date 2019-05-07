package cacheable.qol;

import io.micronaut.cache.annotation.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    private static final Logger log = LoggerFactory.getLogger(HelloService.class);

    private int counter = 0;

    @Cacheable("my-cache")
    public String sayHello() {
        counter++;
        return "Hello";
    }

    @Cacheable
    public String sayHelloWithoutCacheName() {
        counter++;
        return "Hello";
    }

    @Cacheable("my-cache-not-configured")
    public String sayHelloWithoutConfiguredCache() {
        counter++;
        return "Hello";
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
