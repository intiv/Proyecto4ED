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
public class Couple extends Human{
    Person person1,person2;
    
    Couple(){
        super();
        person1=person2=null;
    }
    
    Couple(String name1, String name2, int breaks){
        super(name1+" y "+name2,breaks);
        person1=new Person(name1,0);
        person2=new Person(name2,0);
    }

    @Override
    public String toString() {
        return "Pareja: " +  person1.getName() + " y " + person2.getName();
    }
    
    
}
