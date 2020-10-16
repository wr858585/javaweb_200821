package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author oono
 * @date 2020 10 16
 */
public class User {

    private Integer id;
    private String[] cities;
    private List<String> friends;
    private Map<String,String> girls;
    private boolean ok;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cities=" + Arrays.toString(cities) +
                ", friends=" + friends +
                ", girls=" + girls +
                ", ok=" + ok +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Map<String, String> getGirls() {
        return girls;
    }

    public void setGirls(Map<String, String> girls) {
        this.girls = girls;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public User(Integer id, String[] cities, List<String> friends, Map<String, String> girls, boolean ok) {
        this.id = id;
        this.cities = cities;
        this.friends = friends;
        this.girls = girls;
        this.ok = ok;
    }

    public User() {
    }
}
