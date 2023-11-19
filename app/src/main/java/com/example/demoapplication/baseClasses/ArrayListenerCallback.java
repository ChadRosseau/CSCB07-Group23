package com.example.demoapplication.baseClasses;

import java.util.List;

public interface ArrayListenerCallback<T> extends ListenerCallback<T> {
    void execute(List<T> objList);
}
