package club.banyuan.entity;

public class User {
    private Integer id;
    private String login_name;
    private String userName;
    private String password;
    private Integer sex;
    private String email;
    private String mobile;

    public User() {
    }

    public User(Integer id, String loginName, String userName, String password, Integer sex, String email, String mobile) {
        this.id = id;
        this.login_name = loginName;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.mobile = mobile;
    }
    
    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; } 

    public String getPassword() { return password; } 

    public void setPassword(String password) { this.password = password; } 

    public Integer getSex() { return sex; } 

    public void setSex(Integer sex) { this.sex = sex; } 

    public String getEmail() { return email; } 

    public void setEmail(String email) { this.email = email; } 

    public String getMobile() { return mobile; } 

    public void setMobile(String mobile) { this.mobile = mobile; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + login_name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
