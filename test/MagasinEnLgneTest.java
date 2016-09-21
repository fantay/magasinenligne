/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent-LIM
 */
public class MagasinEnLgneTest {
    
    @Test
    public void test(){
        Persistence.createEntityManagerFactory("PU");
    }
    
}
