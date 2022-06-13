package io.enfuse.Travis.demo.greeting;

public interface GreetingService {

    Greeting getGreetingById(Long id);

    Greeting createOrUpdateGreeting(Greeting greeting);

    void deleteGreeting(Greeting greeting);
}
