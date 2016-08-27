/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto4ed;

/**
 *
 * @author USUARIO-PC
 */
public abstract class Human {
    protected int breaks;
    
    Human(){
        breaks=0;
    }
    
    Human(int breaks){
        this.breaks=breaks;
    }

    public int getBreaks() {
        return breaks;
    }

    public void setBreaks(int breaks) {
        this.breaks = breaks;
    }
    
    
}
