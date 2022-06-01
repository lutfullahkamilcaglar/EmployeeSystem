package authManager.domain;


import authManager.datamodel.AuthUser;

public interface AuthManager {
    boolean login(String name, String password);

    void register(String name, String password);

    void logout();

    Boolean getIsAuthenticated();

    AuthUser getUser();
}
