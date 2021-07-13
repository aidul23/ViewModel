package com.duodevloopers.viewmodel;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData <Integer> amount;
    private MutableLiveData <Integer> totalCost;

    public MutableLiveData <Integer> getAmount(){
        if(amount == null){
            amount = new MutableLiveData<>();
            amount.setValue(0);
        }
        return amount;
    }

    public MutableLiveData <Integer> getTotalCost(){
        if(totalCost == null){
            totalCost = new MutableLiveData<>();
            totalCost.setValue(0);
        }
        return totalCost;
    }


    public void increaseQuantity() {
        if(amount.getValue() != null){
            amount.setValue(amount.getValue() + 1);
        }
        int currentQuantity = amount.getValue();
        int currentCost = currentQuantity * 5;
        totalCost.setValue(currentCost);
    }

    public void decreaseQuantity() {
        if(amount.getValue() > 0){
            amount.setValue(amount.getValue() - 1);
        }
        int currentQuantity = amount.getValue();
        int currentCost = currentQuantity * 5;
        totalCost.setValue(currentCost);
    }

}
