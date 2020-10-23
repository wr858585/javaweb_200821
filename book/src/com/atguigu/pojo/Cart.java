package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author oono
 * @date 2020 10 23
 */
public class Cart {

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                "totalCount=" + getTotalCount() +
                "totalPrice=" + getTotalPrice() +
                '}';
    }

    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        //遍历
        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    /**
     * cart一共多少件商品
     * @return
     */
    public Integer getTotalCount(){
        Integer totalCount = 0;
        //遍历
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }

    public void clear(){
        items.clear();//map接口的内置方法
    }

    public void updateCount(Integer id, Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            //别忘记要更改总价
//            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void addItem(CartItem cartItem){
        //查看要添加的商品是否已经存在于cart中
        CartItem item = items.get(cartItem.getId());
        //如果已存在，只需修改该商品的数量和总价
        if(item != null){
            item.setCount(item.getCount() + 1);//设置数量
//            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//设置总价
        } else{
            //如果之前没有加过此商品，则需要添加到items集合中
            items.put(cartItem.getId(),cartItem);
        }
    }

    /**购物车中的商品
     * key是商品编号，value是商品信息
     */
    private Map<Integer, CartItem> items = new HashMap<>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
