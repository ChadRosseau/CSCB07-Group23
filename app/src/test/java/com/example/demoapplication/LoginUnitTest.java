package com.example.demoapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.example.demoapplication.login.LoginActivityModel;
import com.example.demoapplication.login.LoginActivityPresenter;
import com.example.demoapplication.login.LoginActivityView;
import com.example.demoapplication.login.LoginType;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {
    LoginActivityPresenter presenter;

    @Mock
    LoginActivityModel model;

    @Mock
    LoginActivityView view;

    @Mock
    EditText editText;

    @Mock
    Editable edit;

    @Mock
    View baseView;

    @Before
    public void createPresenter() {
        presenter = new LoginActivityPresenter(view, model);
    }

    @Test
    public void checkEmptyEmailSignUp() {
        presenter.signUp("", "password", true);
        verify(view).displayMessage("Email and Password must be non-empty");
    }

    @Test
    public void checkEmptyPasswordSignUp(){
        presenter.signUp("test@gmail.com", "", true);
        verify(view).displayMessage("Email and Password must be non-empty");
    }

    public void checkShortPasswordSignUp(){
        presenter.signUp("test@gmail.com", "short", true);
        verify(view).displayMessage("Password must be at least 6 characters long");
    }

    @Test
    public void checkEmptyEmailSignIn(){
        presenter.signIn("", "password");
        verify(view).displayMessage("Email and Password must be non-empty");
    }

    @Test
    public void checkEmptyPasswordSignIn(){
        presenter.signIn("test@gmail.com", "");
        verify(view).displayMessage("Email and Password must be non-empty");
    }

    @Test
    public void checkSuccessfulSignUp(){
        presenter.handleLogin(true, LoginType.SignUp);
        verify(view).displayMessage("String cannot be empty!");
    }

    @Test
    public void checkSuccessfulSignIn(){
        presenter.handleLogin(true, LoginType.SignIn);
        verify(view).goToMain();
    }

    @Test
    public void checkFailedSignUp(){
        presenter.handleLogin(false, LoginType.SignUp);
        verify(view).goToMain();
    }

    @Test
    public void checkFailedSignIn(){
        presenter.handleLogin(false, LoginType.SignIn);
        verify(view).displayMessage("No matching email/password found");
    }

    @Test
    public void checkDBClick(){
        when(editText.getText()).thenReturn(edit);
        when(edit.toString()).thenReturn("Test");
    }
}