package entity;

import commom.OrderStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private String id;
    private Integer account_id;
    private String account_name;
    private String create_time;
    private String finish_time;
    private Integer actual_amount;
    private Integer  total_money;
    private OrderStatus order_status;

    //一个订单有多个订单项，如何存储
    public List<OrderItem> orderItemList = new ArrayList<>();



}
