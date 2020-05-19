package entity;

import commom.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private Integer account_id;
    private String account_name;
    private Date create_time;
    private Date finish_time;
    private Integer actual_amount;
    private Integer  total_money;
    private OrderStatus order_status;
}
