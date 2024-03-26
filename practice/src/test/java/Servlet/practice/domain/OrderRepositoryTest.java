package Servlet.practice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    OrderRepository repository = OrderRepository.getInstance();

    @AfterEach
    void afterEach(){
        repository.clear();
    }

    @Test
    public void saveTest(){
        Order order1 = new Order("Speaker",1);
        Order order2 = new Order("cup",2);

        repository.save(order1);
        repository.save(order2);

        List<Order> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}