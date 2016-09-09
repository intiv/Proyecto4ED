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
public class Person extends Human{
    
    
    
    Person(){
        super();
    }
    
    Person(String name, int breaks){
        super(name,breaks);
    }

    @Override
    public String toString() {
        return "Person: "+super.toString();
    }
    
}
