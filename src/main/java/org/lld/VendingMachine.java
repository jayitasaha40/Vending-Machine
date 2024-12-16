package org.lld;

import org.lld.objects.Coin;
import org.lld.objects.Inventory;
import org.lld.objects.Product;
import org.lld.states.DispenseState;
import org.lld.states.IdleState;
import org.lld.states.PaymentState;
import org.lld.states.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine
{
    private static VendingMachine instance;
    public Inventory inventory;
    private List<Product> selectedProducts;
    private int totalPayment;
    private VendingMachineState currentState;
    private VendingMachineState idleState;
    private VendingMachineState paymentState;
    private VendingMachineState dispenseState;

    private VendingMachine(){
        inventory = new Inventory();
        idleState = new IdleState(this);
        paymentState = new PaymentState(this);
        dispenseState = new DispenseState(this);
        selectedProducts = new ArrayList<>();
        totalPayment = 0;
        currentState = idleState;

    }
    public static VendingMachine getInstance(){
        if(instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setSelectedProducts(Product product){
        selectedProducts.add(product);
    }

    public int getTotal(){
        int total = 0;
        for(Product product: selectedProducts){
            total+= product.getPrice();
        }
        return total;
    }

    public void addCoin(Coin coin){
        totalPayment += coin.getValue();
    }
    public void resetPayment(){
        this.totalPayment = 0;
    }

    public void resetSelectedList(){
        selectedProducts.clear();
    }

    public void setCurrentState(VendingMachineState state){
        this.currentState = state;
    }

    public VendingMachineState getPaymentState() {
        return paymentState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public int getTotalPayment(){
        return  totalPayment;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    //Main functions
    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }

    public void pressPaymentButton(){
        currentState.pressPaymentButton();
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public void dispense(){
        currentState.dispenseProduct();
    }
}
