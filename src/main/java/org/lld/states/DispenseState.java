package org.lld.states;

import org.lld.VendingMachine;
import org.lld.objects.Coin;
import org.lld.objects.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DispenseState implements VendingMachineState {

    private VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void pressPaymentButton() {
        System.out.println("Payment already done. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already done. Please collect the dispensed product.");
    }

    @Override
    public void cancel() {
//
    }

    @Override
    public void dispenseProduct() {
        List<Product> products = vendingMachine.getSelectedProducts();
        Set<String> set = new HashSet<>();
        for(Product product: products){
            vendingMachine.inventory.updateQuantity(product,vendingMachine.inventory.getQuantity(product)-1);
            set.add(product.getName());
        }
        for(String item: set){
            System.out.println("Dispensed:: "+item);
        }
        System.out.println("Change Returned:: "+returnChange());
        vendingMachine.resetPayment();
        vendingMachine.resetSelectedList();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());

    }


    private int returnChange() {
        return vendingMachine.getTotalPayment() - vendingMachine.getTotal();
    }
}
