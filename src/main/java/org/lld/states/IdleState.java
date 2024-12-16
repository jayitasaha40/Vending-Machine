package org.lld.states;

import org.lld.VendingMachine;
import org.lld.objects.Coin;
import org.lld.objects.Product;

public class IdleState implements VendingMachineState
{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.inventory.available(product)){
            vendingMachine.setSelectedProducts(product);

            System.out.println("Product: "+ product.getName()+" Added to the cart!");
        }
        else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void pressPaymentButton() {
        if(vendingMachine.getTotal() == 0) {
            System.out.println("Please select a product first.");
        }
        else {
            System.out.println("Total:: "+vendingMachine.getTotal()+". Please insert coins...");
            vendingMachine.setCurrentState(vendingMachine.getPaymentState());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void cancel() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first.");
    }


}
