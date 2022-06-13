package io.enfuse.Travis.demo.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    @Override
    public Greeting createOrUpdateGreeting(Greeting greeting) {
        return null;
    }

    @Override
    public void deleteGreeting(Greeting greeting) {

    }
}
