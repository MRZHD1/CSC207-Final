package use_case.login;

import entity.User;

// one usage in Main.java
public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    // usages in test files
    void save(User user);

    User get(String username);
}
