package com.librarySystem.controller;

import java.util.HashMap;

public final class ControllerFactory {
    
    private ControllerFactory() {}
    
    private static HashMap<Controller, System> map = 
            new HashMap<>();
    
    static {
        map.put(Controller.Credential, new CredentialControllerImpl());
        map.put(Controller.Book, new BookControllerImpl());
        map.put(Controller.Member, new MemberControllerImpl());
    }
    
    @SuppressWarnings("unchecked")
    public static<T extends System> T getController(Controller c) {
        if (! map.containsKey(c))
            throw new IllegalArgumentException("No controller found!");
        return (T) map.get(c);
    }
}
