package kz.bekzat.springbootsoapservice.repository;

import kz.bekzat.springbootsoapservice.user.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<Integer, User> users = new HashMap<>();

    @PostConstruct
    public void initData() {
        User user = new User();
        user.setId(1);
        user.setName("Bekzat");
        user.setSurname("Minazhatov");
        user.setGender("male");
        user.setAge(26);
        users.put(user.getId(), user);

        user = new User();
        user.setId(2);
        user.setName("Azamat");
        user.setSurname("Aitken");
        user.setGender("male");
        user.setAge(26);
        users.put(user.getId(), user);

        user = new User();
        user.setId(3);
        user.setName("Zharkyn");
        user.setSurname("Karakozhin");
        user.setGender("male");
        user.setAge(27);
        users.put(user.getId(), user);
    }

    public User findUser(Integer id) {
        Assert.notNull(id, "The user's id must not be null");
        return users.get(id);
    }
}
