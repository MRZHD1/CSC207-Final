package entity;

import java.time.LocalDateTime;

public class CommonUserFactory implements entity.UserFactory {

    @Override
    public entity.User create(String name, String password, LocalDateTime ltd) {
        return new CommonUser(name, password, ltd);
    }

}

