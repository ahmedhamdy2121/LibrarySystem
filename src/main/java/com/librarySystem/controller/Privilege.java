package com.librarySystem.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Getting Enum from Integer:
 * 
 * PageType pageType = PageType.valueOf(2); // pageType = PageType.CODING
 * 
 * Getting Integer from Enum:
 * 
 * ProductType productType = ProductType.DATABASES;
 * int productTypeId = productType.getValue(); // productTypeId = 3
 * 
 * @author ahmed hamdy
 *
 */
public enum Privilege {
	NONE(0),
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

    /**
     * Getting Enum from Integer
     * 
     * @param privilege
     * @return
     */
    public static Privilege valueOf(int privilege) {
        return (Privilege) map.get(privilege);
    }

    /**
     * Getting Integer from Enum
     * 
     * @return
     */
    public int getValue() {
        return value;
    }
}
