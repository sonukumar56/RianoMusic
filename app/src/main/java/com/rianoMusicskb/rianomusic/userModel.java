package com.rianoMusicskb.rianomusic;

public class userModel {
    String uid;
    String email;
    String username;
    String dob;
    String name;
    String password;

    public userModel() {

    }

    public userModel(String uid,String email, String username, String dob, String name, String password) {
        this.uid=uid;
        this.email = email;
        this.username = username;
        this.dob = dob;
        this.name = name;
        this.password = password;

    }

//    public userModel(String name, String password) {
//           this.name = name;
//        this.password = password;
//    }
public String getuid() {
    return uid;
}

    public void setuid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
