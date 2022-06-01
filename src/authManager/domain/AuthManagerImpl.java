package authManager.domain;

import authManager.datamodel.AuthUser;
import inputManager.InputManager;
import util.RandomManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static authManager.AuthDataSetKt.authDataSet;

public class AuthManagerImpl implements AuthManager {
    private final RandomManager randomManager;


    private int currentUserId = 0;
    private final ArrayList<AuthUser> userList = authDataSet;


    public AuthManagerImpl(RandomManager randomManager) {
        this.randomManager = randomManager;
    }


    @Override
    public Boolean getIsAuthenticated() {
        return currentUserId != 0;
    }

    @Override
    public AuthUser getUser() {
        return userList.stream().filter(it -> it.id() == currentUserId).toList().get(0);
        /*
        it in lambda kullaniminin acilimi
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).id == currentUserId) {
                return userList.get(i);
            }
        }
        return null;
        */
    }

    @Override
    public boolean login(String name, String password) {
        List<AuthUser> filterResult = userList.stream().filter(it -> Objects.equals(it.name(), name) && Objects.equals(it.password(), password)).toList();

        if (!filterResult.isEmpty()) {
            AuthUser loggedInUser = filterResult.get(0);
            currentUserId = loggedInUser.id();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void register(String name, String password) {
        int id = randomManager.generateId();
        AuthUser newUser = new AuthUser(id, name, password);
        userList.add(newUser);
        currentUserId = newUser.id();
    }

    @Override
    public void logout() {
        currentUserId = 0;
    }
}
