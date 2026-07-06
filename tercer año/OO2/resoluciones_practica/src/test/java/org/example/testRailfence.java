package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRailfence {
    private RailFence railFence = new RailFence();

    @Test
    public void testEncrypt(){
        assertEquals("WECRLTEERDSOEEFEAOCAIVDEN",railFence.encrypt("WEAREDISCOVEREDFLEEATONCE", 3));
    }

    @Test
    public void testDecrypt(){
        assertEquals("WEAREDISCOVEREDFLEEATONCE", railFence.decrypt("WECRLTEERDSOEEFEAOCAIVDEN",3));
    }
}
