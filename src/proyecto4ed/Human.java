/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto4ed;

import java.util.ArrayList;

/**
 *
 * @author USUARIO-PC
 */
public abstract class Human {
    protected int breaks;
    ArrayList<Human> conocidos;
    Human(){
        breaks=0;
        conocidos=null;
    }
    
    Human(int breaks){
        this.breaks=breaks;
        conocidos=new ArrayList();
    }

    public int getBreaks() {
        return breaks;
    }

    public boolean knows(Human asked){
        return conocidos.contains(asked);
    }
    
    public void meet(Human asked){
        if(!conocidos.contains(asked))
            conocidos.add(asked);
    }
    
    public void setBreaks(int breaks) {
        this.breaks = breaks;
    }
    
    public void reduce(){
        if(breaks>0)
            breaks--;
    }
    
}
