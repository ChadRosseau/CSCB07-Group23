package com.example.demoapplication.presenters.listeners;

public interface ItemListenerCallback<T> extends ListenerCallback<T> {
    void execute(T obj);
}
