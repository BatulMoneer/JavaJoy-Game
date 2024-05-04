/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author albat
 */
@Entity
@Table(name="user")
public class user implements java.io.Serializable{
    
    @Id
    @Column(name="id_user")
    private int number;
    
    @Column(name="user_name" ) 
    private String userName;
    
    @Column(name="name")
    private String name;
    
    @Column(name="level")
    private int level;

    public user() {
    }
    
    public user(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }
    public user(int num, String userName, String name, int lev) {
        number = num;
        this.userName = userName;
        this.name = name;
        level = lev;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}

