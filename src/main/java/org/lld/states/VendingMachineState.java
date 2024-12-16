package org.lld.states;

import org.lld.objects.Coin;
import org.lld.objects.Product;

public interface VendingMachineState
{
    void selectProduct(Product product);
    void pressPaymentButton();
    void insertCoin(Coin coin);
    void cancel();
    void dispenseProduct();
}
