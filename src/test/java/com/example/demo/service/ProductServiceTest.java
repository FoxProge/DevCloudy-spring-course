package com.example.demo.service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.product.ProductCreateDto;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
class ProductServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    private ProductService underTest;


    @BeforeEach
    void setUp(){
        underTest = new ProductService(productRepository, productMapper);
    }

    @Test
    void canGetProducts(){
        underTest.getProducts();
        verify(productRepository).findAll();
    }

    @Test
    void getProducts() throws Exception{
        mockMvc.perform(get("/product/20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("20"))
                .andExpect(jsonPath("$.product").value("Шиповник сушенный 2 кг"));
    }
}