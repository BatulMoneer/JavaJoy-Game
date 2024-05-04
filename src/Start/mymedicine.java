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
@Table(name="mymedicine")
public class mymedicine implements java.io.Serializable{
    
    @Id
     @Column(name="myid")
     private String myid;
    @Id
     @Column(name="medicinename")
     private String medicinename;
    
    public mymedicine() {
       this.myid = null;
        this.medicinename = null;
    }
    
    public mymedicine(String medicineid, String medicinename) {
        this.myid = medicineid;
        this.medicinename = medicinename;
    }

    public String getMyid() {
        return myid;
    }

    public void setMyid(String medicineid) {
        this.myid = medicineid;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }
    
    
}
