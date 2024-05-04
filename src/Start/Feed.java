/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

/**
 *
 * @author albat
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feed implements java.io.Serializable{
     @Id
     @Column(name="id")
     private int id;
     @Column(name="comment")
     private String comment;
     @Column(name="views")
     private int viewsNum;

    public Feed() {
    }

    public Feed(int id, String comment, int viewsNum) {
        this.id = id;
        this.comment = comment;
        this.viewsNum = viewsNum;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public int getViewsNum() {
        return viewsNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setViewsNum(int viewsNum) {
        this.viewsNum = viewsNum;
    }
     /*
     public Feed(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.comment = rs.getString("comment");
        this.viewsNum = rs.getInt("views");
    }*/
}//the end of the class