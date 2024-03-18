package Servlet.practice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {

    private Long id;
    private String product;
    private int count;

    public Order() {

    }

    public Order(String product, int count){
        this.product = product;
        this.count = count;
    }
}
