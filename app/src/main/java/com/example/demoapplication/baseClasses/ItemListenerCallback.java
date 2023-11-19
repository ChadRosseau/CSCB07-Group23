package com.example.demoapplication.baseClasses;

public interface ItemListenerCallback<T> extends ListenerCallback<T> {
    void execute(T obj);
}
