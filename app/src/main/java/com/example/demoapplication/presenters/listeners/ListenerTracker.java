package com.example.demoapplication.presenters.listeners;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListenerTracker {
    List<ListenerContract> listenerContracts;

    public ListenerTracker() {
        this.listenerContracts = new ArrayList<>();
    }

    public void addListener(Query target, ValueEventListener listener) {
        target.addValueEventListener(listener);
        listenerContracts.add(new ListenerContract(target, listener));
    }

    public void killListeners() {
        for (ListenerContract contract : listenerContracts) {
            if (contract.target == null || contract.listener == null) continue;
            contract.target.removeEventListener(contract.listener);
        }
    }

}
