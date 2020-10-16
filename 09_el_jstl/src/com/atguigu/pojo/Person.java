package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {
//    i.需求——输出Person类中普通属性，数组属性。list集合属性和map集合属性。
    private Integer id;
    private String[] cities;
    private List<String> phones;
    private Map<String,Object> map;

    public Integer getAge(){
        return 18;
    }

    public Person(Integer id, String[] cities, List<String> phones, Map<String, Object> map) {
        this.id = id;
        this.cities = cities;
        this.phones = phones;
        this.map = map;
    }

    public Person() {
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

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", cities=" + Arrays.toString(cities) +
                ", phones=" + phones +
                ", map=" + map +
                '}';
    }
}
