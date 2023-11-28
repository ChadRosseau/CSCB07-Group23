package com.example.demoapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Mock
    MainActivityModel model;

    @Mock
    MainActivityView view;

    @Mock
    EditText editText;

    @Mock
    Editable edit;

    @Mock
    View baseView;

//    @Test
//    public void checkEmptyUsername(){
//        MainActivityPresenter presenter = new MainActivityPresenter(view, model);
//        presenter.checkDB("");
//        verify(view).setOutputText("String cannot be empty!");
//    }
//
//    @Test
//    public void checkDBClick(){
//        when(editText.getText()).thenReturn(edit);
//        when(edit.toString()).thenReturn("Test");
//    }
}