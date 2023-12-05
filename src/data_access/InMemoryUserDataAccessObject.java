package data_access;
import use_case.signup.SignupUserDataAccessInterface;

import entity.User
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();


    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getUserName(), user);


    }
}
