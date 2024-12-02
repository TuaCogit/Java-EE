package pege2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ang
 */
public class Student {

    protected int id;
    protected String name;
    protected int groups_id;
    protected String groups_name;
    protected String email;
    protected String city;

    public Student() {
    }

    public Student(String name, int groups_id, String email, String city) {
        super();
        this.name = name;
        this.groups_id = groups_id;
        this.email = email;
        this.city = city;
    }


    public Student(int id, String name, String groups_name, String email, String city) {
        super();
        this.id = id;
        this.name = name;
        this.groups_name = groups_name;
        this.email = email;
        this.city = city;
    }
    public Student(int id, String name, int groups_id, String email, String city) {
        super();
        this.id = id;
        this.name = name;
        this.groups_id = groups_id;
        this.email = email;
        this.city = city;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
     public void setEmail(String email) {
        this.email = email;
    }
      public String getGroups_name() {
        return groups_name;
    }
    public int getGroups_id() {
        return groups_id;
    }
    public void setGroups_id(int groups_id) {
        this.groups_id = groups_id;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
