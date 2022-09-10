package com.cg.OrderService.Controller;

import com.cg.OrderService.Exception.NoOrderPresentException;
import com.cg.OrderService.Exception.ResourceNotFoundException;
import com.cg.OrderService.Model.DoctorsData;
import com.cg.OrderService.Model.DrugsData;
import com.cg.OrderService.Model.Order;
import com.cg.OrderService.Service.OrderService;
import com.cg.OrderService.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    RestTemplate restTemplate;

    Order order = new Order();

    DrugsData drugsData = new DrugsData();

    DoctorsData doctorsData=new DoctorsData();
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() throws NoOrderPresentException {
        List<Order> list = orderService.getAllOrders();
        if (list.isEmpty()) {
            throw new NoOrderPresentException("There are no orders present in the database!");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable int id) throws NoOrderPresentException {
        Optional<Order> order = orderService.findOrderById(id);
        if (order.isEmpty()) {
            throw new NoOrderPresentException("No order found with id: " + id);
        }
        return ResponseEntity.ok(order.get());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveOrder(@RequestBody Order order) throws ResourceNotFoundException{
       String doctorsData=order.getDoctorsData().getEmail();
        String drugname = order.getDrugname();
        if(drugname == null||doctorsData==null){
            throw new ResourceNotFoundException("No Drug Found with name "+drugname+"for mail"+doctorsData);
        }
        else {
            DrugsData drugsData = restTemplate.getForObject("http://Drugs-Info-Service/drugs/drugsname/" +
                    drugname, DrugsData.class);
            DoctorsData doctorsData1=restTemplate.getForObject("http://User-Service/doctors/username/"+
                    doctorsData,DoctorsData.class);
            double cost = drugsData.getDrugPrice() * order.getQuantity();
            order.setCost(cost);
            order.setId(sequenceGeneratorService.getSequenceNumber(Order.SEQUENCE_NAME));
            String x = "Your order with order Id " + order.getId() + " with value " + cost + " is placed"
                    +order.getDoctorsData().getName();
            Order savedOrder = orderService.saveOrder(order);
            return ResponseEntity.ok(x);
        }

    }

    @DeleteMapping("/delete/{id}")
    public void deleteByid(@PathVariable int id) throws NoOrderPresentException {
        Optional<Order> order = orderService.findOrderById(id);
        if (order.isEmpty()) {
            throw new NoOrderPresentException("No order found with id: " + id);
        }
        orderService.deleteOrderById(id);
    }


}
