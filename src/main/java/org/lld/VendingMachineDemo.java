package org.lld;

import org.lld.objects.Coin;
import org.lld.objects.Product;

public class VendingMachineDemo {
    public static void run() {
        //Install Vending Machine
        VendingMachine vendingMachine = VendingMachine.getInstance();


        //Create products
        Product coke = new Product(50, 1, "COKE");
        Product chips = new Product(20, 2, "CHIPS");
        Product dip = new Product(5, 3, "DIP");

        //Add products to the Inventory
        vendingMachine.inventory.addProduct(coke,20);
        vendingMachine.inventory.addProduct(chips,10);
        vendingMachine.inventory.addProduct(dip,5);

        //Select Products
        vendingMachine.selectProduct(coke);
        vendingMachine.selectProduct(chips);
        vendingMachine.selectProduct(chips);
        vendingMachine.selectProduct(dip);
        vendingMachine.selectProduct(dip);
        vendingMachine.selectProduct(dip);

        //Make Payment
        vendingMachine.pressPaymentButton();
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);

        //Get Product & Changes
        vendingMachine.dispense();


    }
}
