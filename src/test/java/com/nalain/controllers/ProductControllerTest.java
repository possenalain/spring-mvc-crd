package com.nalain.controllers;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.Product;
import com.nalain.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
@Getter
@Setter
class ProductControllerTest {

    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;

    private static final String BASE_PATH="/products";

    //@Autowired
   // private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
       //mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

    }


    @Test
    void ShouldlistAllProducts() throws Exception {
        List<Product> products=new ArrayList<>();
        products.add(mock(Product.class));
        products.add(mock(Product.class));

        when(productService.listAll()).thenReturn((List) products);

        mockMvc.perform(get(BASE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("product/products"))
                .andExpect(model().attribute("products", hasSize(2)));
    }

    @Test
    void getProduct() throws Exception {

        Product product = mock(Product.class);

        when(productService.getById(any())).thenReturn(product);

        mockMvc.perform(get(BASE_PATH+"/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/product"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    void editProduct() throws Exception {
        when(productService.getById(any())).thenReturn(new Product());
        mockMvc.perform(get(BASE_PATH+"/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productform"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    void deleteProduct() throws Exception {
        Integer id = 1;

        mockMvc.perform(get(BASE_PATH+"/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products"));

        verify(productService, times(1)).delete(id);
    }

    @Test
    void newProduct() throws Exception {
        verifyNoInteractions(productService);

        mockMvc.perform(get(BASE_PATH+"/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productform"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));

    }

    @Test
    void saveOrUpdateProduct() {
    }

}