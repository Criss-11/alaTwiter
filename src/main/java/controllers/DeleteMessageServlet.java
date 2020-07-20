package controllers;



import dao.TweetManagementService;
import dao.impl.TweetManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.ServletsUtils.TWEET_ID_PARAM;

@WebServlet(name = "DeleteMessageServlet", value = "/deleteTweet")
public class DeleteMessageServlet extends HttpServlet {

  private TweetManagementService service;

  @Override
  public void init() throws ServletException {
    service = new TweetManagementServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String tweetId = req.getParameter(TWEET_ID_PARAM);
    service.deleteTweet(Long.parseLong(tweetId));
    req.getRequestDispatcher("messages").forward(req, resp);
  }
}
