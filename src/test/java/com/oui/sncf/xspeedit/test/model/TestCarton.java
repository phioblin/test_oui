package com.oui.sncf.xspeedit.test.model;

import com.oui.sncf.xspeedit.exceptions.ArticleException;
import com.oui.sncf.xspeedit.model.Article;
import com.oui.sncf.xspeedit.model.Carton;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test unitaire sur les carton
 */
public class TestCarton {

    /**
     * Test d'ajout d'article dans un carton et vérification de la capacité
     * @throws ArticleException exception
     */
    @Test
    public void testCarton() throws ArticleException {
        Carton carton=new Carton();
        assertEquals(carton.getCapacite(), 0);

        carton.add(new Article("3"));
        assertEquals(carton.getCapacite(), 3);

        carton.add(new Article("6"));
        assertEquals(carton.getCapacite(), 9);

        carton.add(new Article("2"));
        assertEquals(carton.getCapacite(), 9);
    }
}
