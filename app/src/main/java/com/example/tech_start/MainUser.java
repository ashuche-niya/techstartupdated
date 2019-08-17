package com.example.tech_start;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainUser {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("joined")
    @Expose
    private String joined;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public MainUser(String password, String email) {
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email=" + email +
                ", id=" + id +
                '}';
    }

}
