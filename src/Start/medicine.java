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
@Table(name="medicine")
public class medicine implements java.io.Serializable{
    
    @Id
     @Column(name="medicineid")
     private int medicineid;
    
     @Column(name="medicinename")
     private String medicinename;
     
     @Column(name="startdate")
     private String startdate;
     
     @Column(name="enddate")
     private String enddate;
     
     @Column(name="description")
     private String description;
     
     @Column(name="formula")
     private String formula;
     
     @Column(name="doseno")
     private String doseno;
     
     @Column(name="dosetime")
     private String dosetime;
     
     @Column(name="image")
     private String image;

    public medicine() {
        this.medicineid = 0;
        this.medicinename = null;
        this.startdate = null;
        this.enddate = null;
        this.description = null;
        this.formula = null;
        this.doseno = null;
        this.dosetime = null;
    }

    public medicine(int medicineid, String medicinename, String startdate, String enddate, String description, String formula, String doseno, String dosetime, String image) {
        this.medicineid = medicineid;
        this.medicinename = medicinename;
        this.startdate = startdate;
        this.enddate = enddate;
        this.description = description;
        this.formula = formula;
        this.doseno = doseno;
        this.dosetime = dosetime;
        this.image = image;
    }

    public int getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(int medicineid) {
        this.medicineid = medicineid;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getDoseno() {
        return doseno;
    }

    public void setDoseno(String doseno) {
        this.doseno = doseno;
    }

    public String getDosetime() {
        return dosetime;
    }

    public void setDosetime(String dosetime) {
        this.dosetime = dosetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

     
     
}//the end of the class