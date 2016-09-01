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

    boolean onecouple, hasForced;
    int persons;
    ArrayList<Human> members;

    Set() {
        onecouple = false;
        hasForced=false;
        persons = 0;
        members = new ArrayList();
    }

    public boolean isEmpty() {
        return members.isEmpty();
    }

    public boolean CoupleSlotAvailable() {
        if (members.isEmpty()) {
            return true;
        } else {
            int cont = 0;
            for (Human member : members) {
                if (member instanceof Couple) {
                    cont++;
                }
            }
            return cont == 0;
        }
    }

    public int size() {
        return members.size();
    }

    public int people() {
        return persons;
    }

    public boolean contains(Human searched) {
        return members.contains(searched);
    }

    public boolean add(Human persona, boolean forced) {
        if (!forced) {
            if (persons == 5) {
                return false;
            }
            if (persona instanceof Couple) {
                if (persons <= 3 && CoupleSlotAvailable()) {
                    members.add(persona);
                    persons++;
                } else {
                    return false;
                }
            } else if (persons <= 4) {
                members.add(persona);
            } else {
                return false;
            }
        }else{
            members.add(persona);
            if(!hasForced)
                hasForced=true;
            if(persona instanceof Couple)
                persons++;
        }
        persons++;
        return true;
    }
    
    public Human remove(int index){
        if(index<0||index>members.size())
            return null;
        Human temp=members.get(index);
        members.remove(index);
        return temp;
    }

    public boolean Forced(){
        return hasForced;
    }
    
    public boolean hasPeople(){
        return members.size()>0;
    }
    
    public Human get(int index) {
        if(index<0||index>=members.size())
          return null;
        return members.get(index);
    }
}
