package entity;

import lombok.Data;

@Data
public class Goods {
    private Integer id;
    private String name;
    private String introduce;
    private Integer stock;
    private String unit;
    private Integer price;
    private Integer discount;
    private Integer buyGoodsNum;

    //原来默认拿到的是分数，以元为单位
    public double getPrice(){
        return price*1.0/100;
    }
    //返回价格为整数，以分为单位
    public int getPriceInt(){
        return price;
    }

}
