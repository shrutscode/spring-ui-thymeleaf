package com.exercise.uidemo.web;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WebControllerTest {
	
	@InjectMocks private WebController webController;

    private MockMvc mockMvc;
   
    
    @Before
    public void setUp() throws Exception {
    	
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(webController).build();       
    	
    }
    
    @Test
    public void testIndexPageInvalidRange() throws Exception {
    	
    	DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate startDate = LocalDate.parse("20/10/2010", pattern);
    	LocalDate endDate = LocalDate.parse("16/10/2010", pattern);
    	
    	
    	
    	mockMvc.perform(post("/")
    			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			.param("startDate", startDate.toString())
    			.param("endDate", endDate.toString()))
    	.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andExpect(view().name("index"))
    	.andExpect(content().string(contains("Start date cannot be after end date")));
                
    }
    
    @Test
    public void testIndexPageValidRange() throws Exception {
    	
    	DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate startDate = LocalDate.parse("20/10/2010", pattern);
    	LocalDate endDate = LocalDate.parse("26/10/2010", pattern);
    	
    	
    	
    	mockMvc.perform(post("/")
    			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			.param("startDate", startDate.toString())
    			.param("endDate", endDate.toString()))
    	.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andExpect(view().name("index"));
    	//.andExpect(content().string(contains("Start date cannot be after end date")));
                
    }
    
}
