package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String password;
    private String email;
    @Column(name = "dateOfRegistration")
    private Date dateOfRegistration;
    @ManyToMany(mappedBy = "followedByUsers")
    private Set<AppUser> followers = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "follower_followed ",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "followed_id")})

    private Set<AppUser> followedByUsers = new HashSet<>();

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Set<AppUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<AppUser> followers) {
        this.followers = followers;
    }

    public Set<AppUser> getFollowedByUsers() {
        return followedByUsers;
    }

    public void setFollowedByUsers(Set<AppUser> followedByUsers) {
        this.followedByUsers = followedByUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return getId().equals(appUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                '}';
    }
    public static class UserBuiler {
        private String name;
        private String lastName;
        private String login;
        private String password;
        private String email;
        private Date dateOfRegistration;

        public static UserBuiler getBuilder() {
            return new UserBuiler();
        }
        public UserBuiler login(String login){
            this.login= login;
            return this;
        }

        public UserBuiler name(String name){
            this.name= name;
            return this;
        }

        public UserBuiler lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public UserBuiler password(String password){
            this.password = password;
            return this;
        }
        public UserBuiler email(String email){
            this.email = email;
            return this;
        }

        public UserBuiler dateOfRegistration(Date dateOfRegistration){
            this.dateOfRegistration = dateOfRegistration;
            return this;
        }

        public AppUser build(){
            AppUser user = new AppUser();
            user.setLogin(this.login);
            user.setName(this.name);
            user.setLastName(this.lastName);
            user.setPassword(this.password);
            user.setEmail(this.email);
            user.setDateOfRegistration(this.dateOfRegistration);
            return user;
        }
    }
}
