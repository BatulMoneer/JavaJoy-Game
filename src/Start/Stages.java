/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
This is a POJO class for the stageinfor relation in the database 
*/

@Entity
@Table(name="stageinfor")
public class Stages implements java.io.Serializable{
    
    @Id
     @Column(name="stagenumber")
     private int stagenumber;
    
     @Column(name="stagetopic")
     private String topic;
     
     @Column(name="numberofpages")
     private int pagesofstage;

    public Stages() {
    }

    public Stages(int stagenumber, String topic, int pagesofstage) {
        this.stagenumber = stagenumber;
        this.topic = topic;
        this.pagesofstage = pagesofstage;
    }

    public int getStagenumber() {
        return stagenumber;
    }

    public String getTopic() {
        return topic;
    }

    public int getPagesofstage() {
        return pagesofstage;
    }

    public void setStagenumber(int stagenumber) {
        this.stagenumber = stagenumber;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setPagesofstage(int pagesofstage) {
        this.pagesofstage = pagesofstage;
    }
     
     @Override 
     public String toString()
     {
         return "Stage "+this.getStagenumber()+": "+this.getTopic()+".";
     }//the end of the method
     
}//the end of the class