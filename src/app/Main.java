package app;

import java.io.IOException;
import java.net.*;
import data_access.FileUserDataAccessObject;
import interface_adapter.login.LoginViewModel;




public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=eb46926a4e98e257c2c14f2b9fcd1899");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();


        int code = connection.getResponseCode();
        System.out.println(code); // Returns status code if request went through.
    }

//    LoginViewModel loginViewModel = new LoginViewModel();
//    LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
//    SignupViewModel signupViewModel = new SignupViewModel();
//
//    FileUserDataAccessObject userDataAccessObject;
//        try {
//        userDataAccessObject = new FileUserDataAccessObject("./users.csv", new entity.CommonUserFactory());
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//
//    SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
//        views.add(signupView, signupView.viewName);
//
//    LoginView loginView = app.LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//        views.add(loginView, loginView.viewName);
//
//    LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
//        views.add(loggedInView, loggedInView.viewName);
//
//        viewManagerModel.setActiveView(signupView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        application.pack();
//        application.setVisible(true);

}