package entity;

import src.entity.CommonUser;
import src.entity.UserFactory;

public class CommonUserFactory implements UserFactory {


    @Override
    public entity.User create(String name, String password) {
        return new CommonUser(name, password);
    }
}

