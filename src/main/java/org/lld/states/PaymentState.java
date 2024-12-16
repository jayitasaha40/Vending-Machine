package org.lld.states;

import org.lld.VendingMachine;
import org.lld.objects.Coin;
import org.lld.objects.Product;

public class PaymentState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public PaymentState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected");
    }

    @Override
    public void pressPaymentButton() {
        System.out.println("Button already pressed!");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println(coin.name()+" Added. Payment made till now: "+vendingMachine.getTotalPayment());
        checkPaymentStatus();
    }

    @Override
    public void cancel() {
    //hj
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }



    private void checkPaymentStatus(){
       if( vendingMachine.getTotal()<=vendingMachine.getTotalPayment()){
           vendingMachine.setCurrentState(vendingMachine.getDispenseState());
       }
    }
}
