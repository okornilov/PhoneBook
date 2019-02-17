package ru.company.services.web;

import lombok.Data;
import ru.company.services.personws.TUser;

@Data
public class UserAction {
    private Action action;
    private TUser user;

    public UserAction(Action action, TUser user) {
        this.action = action;
        this.user = user;
    }
}
