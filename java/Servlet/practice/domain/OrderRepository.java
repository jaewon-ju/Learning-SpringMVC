package Servlet.practice.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private static Map<Long, Order> repository = new HashMap<>();
    private static long sequence = 0L;

    private static final OrderRepository orderRepository = new OrderRepository();

    public static OrderRepository getInstance(){
        return orderRepository;
    }

    private OrderRepository(){}

    public Order save(Order order){
        order.setId(++sequence);
        repository.put(order.getId(), order);
        return order;
    }

    public Order findById(Long id){
        return repository.get(id);
    }

    public List<Order> findAll(){
        return new ArrayList<>(repository.values());
        // repository에 존재하는 주문 정보들로 리스트를 만들어서 리턴
    }

    public void clear(){
        repository.clear();
    }

}
