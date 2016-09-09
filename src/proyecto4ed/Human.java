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
    protected String name;
    protected int breaks;
    protected ArrayList<Human> conocidos;
    protected boolean added;
    
    Human(){
        breaks=0;
        conocidos=null;
        added=false;
    }
    
    Human(String name, int breaks){
        this.name=name;
        this.breaks=breaks;
        conocidos=new ArrayList();
    }

    public String getName(){
        return this.name;
    }
    
    public int getBreaks() {
        return breaks;
    }
    
    public void SetAdded(boolean added){
        this.added=added;
    }

    public boolean isAdded(){
        return this.added;
    }
    
    public boolean knows(Human asked){
        return conocidos.contains(asked);
    }
    
    public void meet(Human asked){
        if(!conocidos.contains(asked))
            conocidos.add(asked);
    }
    
    public void setBreaks(int breaks){
        this.breaks=breaks;
    }
    
    public void reduce(){
        if(breaks>0)
            breaks--;
    }
    @Override
    public String toString(){
        return name;
    }
}
