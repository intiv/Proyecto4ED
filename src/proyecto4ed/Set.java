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
public class Set {
    boolean onecouple;
    int persons;
    ArrayList<Human> members; 
    
    Set(){
        onecouple=false;
        persons=0;
        members=new ArrayList();
    }
    
    public boolean isEmpty(){
        return members.isEmpty();
    }
    
    public boolean CoupleSlotAvailable(){
        if(members.isEmpty()){
            return true;
        }else{
            int cont=0;
            for (Human member : members) {
                if(member instanceof Couple)
                    cont++;
            }
            return cont==0;
        }
    }
    
    public int size(){
        return members.size();
    }
    
    public int people(){
        return persons;
    }
    
    public boolean contains(Human searched){
        return members.contains(searched);
    }
    
    public boolean add(Human persona){
        if(persons==5)
            return false;
        if(persona instanceof Couple){
            if(persons<=3&&CoupleSlotAvailable()){
                members.add(persona);
                persons++;
            }else{
                return false;
            }
        }else{
            if(persons<=4)
                members.add(persona);
            else
                return false;
        }
        persons++;
        return true;
    }
    
    public Human get(int index){
        return members.get(index);
    }
}
