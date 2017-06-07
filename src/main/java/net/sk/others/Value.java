package net.sk.others;

public class Value< T > {

    public static< T > T defaultValue() { 
        return null; 
    }
    
    public T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}