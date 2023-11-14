package com.example.demoapplication.presenters.contracts;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListenerTracker {
    List<ListenerContract> listenerContracts;

    public ListenerTracker() {
        this.listenerContracts = new ArrayList<ListenerContract>();
    }

    public void addListener(DatabaseReference target, ValueEventListener listener) {
        target.addValueEventListener(listener);
        listenerContracts.add(new ValueListenerContract(target, listener));
    }

    public void addListener(DatabaseReference target, ChildEventListener listener) {
        target.addChildEventListener(listener);
        listenerContracts.add(new ChildListenerContract(target, listener));
    }

    public void killListeners() {
        for (ListenerContract contract : listenerContracts) {
            if (contract.listener instanceof ValueEventListener) contract.target.removeEventListener((ValueEventListener)contract.listener);
            if (contract.listener instanceof ChildEventListener) contract.target.removeEventListener((ChildEventListener)contract.listener);
        }
    }

}
