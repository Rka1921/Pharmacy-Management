package com.cg.OrderService.controller;

import com.cg.OrderService.exception.NoOrderPresentException;
import com.cg.OrderService.model.DoctorsData;
import com.cg.OrderService.model.DrugsData;
import com.cg.OrderService.model.Order;
import com.cg.OrderService.service.OrderService;
import com.cg.OrderService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    RestTemplate restTemplate;
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
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        order.setId(sequenceGeneratorService.getSequenceNumber(Order.SEQUENCE_NAME));
//        if()
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByid(@PathVariable int id) throws NoOrderPresentException {
        Optional<Order> order = orderService.findOrderById(id);
        if (order.isEmpty()) {
            throw new NoOrderPresentException("No order found with id: " + id);
        }
        orderService.deleteOrderById(id);
    }

    @PostMapping("/{orderId}/assign-medicine/{drugsname}")
    private ResponseEntity<Order> assignMedicineToOrder(@PathVariable("orderId") int orderId, @PathVariable("drugsname") String drugsname ) throws NoOrderPresentException {
        Optional<Order> orderOptional = orderService.findOrderById(orderId);
        if (orderOptional.isEmpty()) {
            throw new NoOrderPresentException("No order found with id: " + orderId);
        }
        ResponseEntity<DrugsData> drugs=restTemplate.getForEntity("http://Drugs-Info-Service/drugs/drugsname/" + drugsname, DrugsData.class);
        if (!drugs.hasBody()) {
            throw new NoOrderPresentException("No medicine found with id: " + drugsname);
        }
        Order order=orderOptional.get();

        DrugsData drugsData=drugs.getBody();
        order.setDrugsData(drugsData);
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
//       }

    }
    @PostMapping("/{orderId}/assign-doctor/{doctoremail}")
    private ResponseEntity<Order> assignDoctorToOrder(@PathVariable("orderId") int orderId, @PathVariable("doctoremail")
    String doctoremail) throws NoOrderPresentException {
        Optional<Order> orderOptional = orderService.findOrderById(orderId);
        if (orderOptional.isEmpty()) {
            throw new NoOrderPresentException("No order found with id: " + orderId);
        }
        ResponseEntity<DoctorsData> doctors=restTemplate.getForEntity("http://User-Service/doctors/username/" + doctoremail, DoctorsData.class);
        if (!doctors.hasBody()) {
            throw new NoOrderPresentException("No medicine found with id: " + doctoremail);
        }
        Order order=orderOptional.get();

       DoctorsData doctorsData=doctors.getBody();
        order.setDoctorsData(doctorsData);
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
//       }

    }

}