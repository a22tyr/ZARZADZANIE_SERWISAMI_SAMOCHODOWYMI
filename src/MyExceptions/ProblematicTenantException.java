package MyExceptions;

import Person.Person;

public class ProblematicTenantException extends Exception{


    public ProblematicTenantException(String message) {
        super(message);
    }
}
