package dao;

import model.AppUser;

import java.util.HashSet;

public interface UserDao {
    HashSet<AppUser> getAll();

    void saveUser(AppUser user);

    void deleteUser(long id);

    AppUser getUserByEmail(String email);

    AppUser getUserByLogin(String login);

    HashSet<AppUser> getUserByName(String name);



    HashSet<AppUser> getFollowedUsers(String login);

    HashSet<AppUser> getNotFollowedUsers(String login);

    HashSet<AppUser> getFollowers(String login);

    void follow(String currentUserLogin, String userLoginToFollow);

    void stopFollowing(String currentUserLogin, String userLoginToStopFollow);
}
