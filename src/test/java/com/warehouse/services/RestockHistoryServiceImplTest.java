package com.warehouse.services;

import com.warehouse.WarehouseApplication;
import com.warehouse.model.Restock;
import com.warehouse.repository.RestockHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WarehouseApplication.class)
class RestockHistoryServiceImplTest {
    @TestConfiguration
    static class RestockHistoryServiceImplContextConfiguration{
        @Bean
        public RestockHistoryService restockHistoryService(){
            return new RestockHistoryServiceImpl();
        }
    }
    @Autowired
    RestockHistoryService restockHistoryService;
    @MockBean
    RestockHistoryRepository restockHistoryRepository;

    @BeforeEach
    void setUp() {
    Restock restock1=new Restock(1,1,LocalDateTime.of(2021, Month.JANUARY, 1, 10, 10, 30),23);
    restock1.setEntryID(1);
    Restock restock2=new Restock(2,1, LocalDateTime.of(2021, Month.JANUARY, 1, 10, 10, 30),24);
    restock2.setEntryID(2);
        List<Restock>restocks=new ArrayList<>();
        restocks.add(restock1);
        restocks.add(restock2);
        Mockito.when(restockHistoryRepository.findAll()).thenReturn(restocks);
        Mockito.when(restockHistoryRepository.save(Mockito.any(Restock.class))).thenAnswer(i -> i.getArguments()[0]);
    }
    @Test
    void getAllRestocks() {
        Restock restock1=new Restock(1,1, LocalDateTime.of(2021, Month.JANUARY, 1, 10, 10, 30),23);
        restock1.setEntryID(1);
        Restock restock2=new Restock(2,1, LocalDateTime.of(2021, Month.JANUARY, 1, 10, 10, 30),24);
        restock2.setEntryID(2);
        List<Restock>restocks=new ArrayList<>();
        restocks.add(restock1);
        restocks.add(restock2);
        List<Restock>found=restockHistoryService.getAllRestocks();
        assertThat(restocks).isEqualTo(found);
    }

    @Test
    void restockProduct() {
        Restock restock1=new Restock(1,1, LocalDateTime.of(2021, Month.JANUARY, 1, 10, 10, 30),23);
        restock1.setEntryID(1);
        Restock restock2=restockHistoryService.restockProduct(1,1,23);
        restock2.setEntryID(1);
        assertThat(restock1.getEntryID()).isEqualTo(restock2.getEntryID());
        assertThat(restock1.getRestockDate()).isNotEqualTo(restock2.getRestockDate());
    }
}