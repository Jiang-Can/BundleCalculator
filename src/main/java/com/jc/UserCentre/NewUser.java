package com.jc.UserCentre;

import com.jc.bean.Invoice;
import com.jc.bean.Order;
import com.jc.utils.Utils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@ToString
public class NewUser {

    private String userId=Utils.idGenerator();
    private String orderId=Utils.idGenerator();
    private String invoiceId=Utils.idGenerator();
    private BigDecimal total= new BigDecimal(0);

    private List<Order> orderList=new ArrayList<>();
    private List<Invoice> invoiceList =new ArrayList<>();



    public void handleUserInput(HashMap<String,Integer> inputs){
        orderList=new ArrayList<>();
        for(Map.Entry<String,Integer> input:inputs.entrySet()){
            orderList.add(new Order(orderId,input.getKey(),input.getValue()));
        }
    }

    public void buildInvoiceList(int quantity,BigDecimal subtotal){
        invoiceList.add(new Invoice(invoiceId,quantity,subtotal));
    }

}
