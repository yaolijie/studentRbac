package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.model.Organ;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.model.Role;
import com.sun.org.apache.xpath.internal.operations.Or;

public class QueryObjectHeadle {

    public static Power queryPower(String id){

        Power power=new Power();

        return power;
    }

    public static Person queryPerson(String id){
        Person person=new Person();

        return person;
    }

    public static Organ queryOrgan(String id){
        Organ organ=new Organ();

        return organ;
    }

    public static Role queryRole(String id){
        Role role=new Role();

        return role;
    }
}
