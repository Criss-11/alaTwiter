package dao.impl;

import dao.TweetDAO;
import dao.TweetManagementService;
import model.AppUser;
import model.Tweet;

import java.util.HashSet;
import java.util.Set;

public class TweetManagementServiceImpl implements TweetManagementService {
    private AppUserDao userDAO;
    private TweetDAO tweetDAO;

    public TweetManagementServiceImpl() {
        this.userDAO = new AppUserDao();
        this.tweetDAO = new TweetDAOImpl();
    }

    @Override
    public void addTweet(String userLogin, String message) {
        AppUser user = userDAO.getUserByLogin(userLogin);
        tweetDAO.addTweet(user, message);
    }

    @Override
    public void updateTweet(Long tweetId, String message) {
        tweetDAO.updateTweet(tweetId, message);
    }

    @Override
    public void deleteTweet(Long id) {
        tweetDAO.deleteTweet(id);
    }

    @Override
    public Set<Tweet> getFollowedTweets(String userLogin) {
        Set<Tweet> followedTweets = new HashSet<>();
        Set<AppUser> follows = userDAO.getFollowedUsers(userLogin);
        followedTweets.addAll(tweetDAO.getUserTweets(userLogin));
        follows.stream().forEach(p -> followedTweets.addAll(tweetDAO.getUserTweets(p.getLogin())));
        return followedTweets;
    }
}
