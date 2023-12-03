package com.example.demoapplication.presenters.listeners;

import java.util.ArrayList;

public interface ArrayListenerCallback<T> extends ListenerCallback<T> {
    void execute(ArrayList<T> objList);
}
