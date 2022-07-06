package com.nalain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.Address;
import com.nalain.domain.Customer;
import com.nalain.services.CustomerService;
import lombok.Getter;
import lombok.Setter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
@Getter
@Setter
class CustomerControllerTest {
    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CustomerController customerController;

    private static final String BASE_PATH="/customers";
    private  ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    }
    @Test
    void listAllCustomers() throws Exception {

        when(customerService.listAll()).thenReturn((List) List.of(mock(Customer.class),mock(Customer.class)));
        mockMvc.perform(get(BASE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customers"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    void findById() {
    }

    @Test
    void newCustomer() throws Exception {
        verifyNoInteractions(customerService);

        mockMvc.perform(get(BASE_PATH+"/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    void editCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void getCustomerService() {
    }

    @Test
    void setCustomerService() {
    }
    @Test
    void saveOrUpdateCustomer() throws Exception {

        Customer returnCustomer = new Customer();

        returnCustomer.setId(1);
        returnCustomer.setFirstName("Micheal");
        returnCustomer.setLastName("Weston");
        returnCustomer.setBillingAddress(new Address());
        returnCustomer.getBillingAddress().setAddressLineOne("1 Main St");
        returnCustomer.getBillingAddress().setAddressLineTwo("Apt 301");
        returnCustomer.getBillingAddress().setCity("Miami");
        returnCustomer.getBillingAddress().setState("Florida");
        returnCustomer.getBillingAddress().setZipCode("33101");
        returnCustomer.setEmail( "micheal@burnnotice.com");
        returnCustomer.setShippingAddress(returnCustomer.getBillingAddress());
        returnCustomer.setPhoneNumber("305.333.0101");

        String customer = objectMapper.writeValueAsString(returnCustomer);

        when(customerService.save(any())).thenReturn(returnCustomer);

        mockMvc.perform(post(BASE_PATH).content(customer).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:customers/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(("Micheal")))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is("Weston"))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress",instanceOf(Address.class))));

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).save(customerCaptor.capture());

        Customer boundCustomer = customerCaptor.getValue();

        assertEquals(1, boundCustomer.getId());
        assertEquals("Micheal", boundCustomer.getFirstName());
        assertEquals("1 Main St", boundCustomer.getShippingAddress().getAddressLineOne());


    }

}