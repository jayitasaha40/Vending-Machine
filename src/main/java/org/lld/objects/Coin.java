package org.lld.objects;

public enum Coin
{
    FIVE(5),
    TEN(10);

    private int value;
     Coin(int value){
         this.value = value;
     }

     public int getValue(){
         return value;
     }
}
