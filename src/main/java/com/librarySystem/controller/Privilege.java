package com.librarySystem.controller;

import java.util.HashMap;
import java.util.Map;

public enum Privilege {
	ADMIN(1),
	LIBRARIAN(2), 
	BOTH(3);
	
	private int value;
    private static Map<Integer, Privilege> map = new HashMap<>();

    private Privilege(int value) {
        this.value = value;
    }

    static {
        for (Privilege privilege : Privilege.values()) {
            map.put(privilege.value, privilege);
        }
    }

    public static Privilege valueOf(int privilege) {
        return (Privilege) map.get(privilege);
    }

    public int getValue() {
        return value;
    }
}
