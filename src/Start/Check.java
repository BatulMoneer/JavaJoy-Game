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
public class Check {
    
    static int stage=1;

    public static int getStage() {
        return stage;
    }

    public static void setStage(int s) {
        if(s>=Check.stage){
            Check.stage = s;
        }
    }
     
    static int done=1;
    
    static user u = new user();
    
    static int id=0;
    
    static int level=1;
    
    static int very =0 ;
     static int ok =0 ;
      static int bad =0 ;

    public static int getVery() {
        return very;
    }

    public static void setVery(int very) {
        Check.very = very;
    }

    public static int getOk() {
        return ok;
    }

    public static void setOk(int ok) {
        Check.ok = ok;
    }

    public static int getBad() {
        return bad;
    }

    public static void setBad(int bad) {
        Check.bad = bad;
    }
    

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Check.level = level;
    }
       
    
     public static int isDone(){
        return done;
    }
    
    public static void Done(){
        done = done+1;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Check.id = id;
    }
    
    
}
