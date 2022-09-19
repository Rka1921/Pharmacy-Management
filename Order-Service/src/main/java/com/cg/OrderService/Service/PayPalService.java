package com.cg.OrderService.Service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PayPalService {
    @Autowired
    private APIContext apiContext;
    @Autowired
    private com.cg.OrderService.Model.Order order;


    public Payment createPayment(
            double total,
            String name,
            String email,
            String cancelUrl,
            String successUrl) throws PayPalRESTException {

        List<Order> orders;
        double subtotal =1;

//        for(int i = 0; i < orders.size(); i++) {
//            int id = cartGames.get(i).getId();
//            Game game = SQLiteDataBase.sellectById(id);
//            game.setQuantity(cartGames.get(i).getQuantity());
            subtotal = subtotal + ( order.getCost()* order.getQuantity());



        Amount amount = new Amount();
        amount.setCurrency("PLN");
        amount.setTotal(String.valueOf(subtotal));

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName(name);
        payerInfo.setEmail(email);

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

//        SQLiteDataBase.removeAllCartId();
        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }


}


