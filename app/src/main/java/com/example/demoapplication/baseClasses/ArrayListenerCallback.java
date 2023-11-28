package com.example.demoapplication.baseClasses;

import java.util.ArrayList;
import java.util.List;

public interface ArrayListenerCallback<T> extends ListenerCallback<T> {
    void execute(ArrayList<T> objList);
}
