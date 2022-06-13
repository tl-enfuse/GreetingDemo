package io.enfuse.Travis.demo.greeting;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GreetingService greetingService;

    private ObjectMapper objectMapper;

    private Greeting greeting = new Greeting(1L, "This is a good Greeting");

    @BeforeEach()
    public void setup(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void when_givenId_returnGreeting() throws Exception {
        mockMvc.perform(get("/greeting/1L"))
                .andExpect(status().isOk());
        //fake call to endpoint
        //when
    }
    @Test
    public void when_givenGreeting_saveOrUpdate(){

    }
    @Test
    public void when_givenGreeting_delete(){

    }
}
