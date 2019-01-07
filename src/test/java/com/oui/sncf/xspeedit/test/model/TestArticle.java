package com.oui.sncf.xspeedit.test.model;

import com.oui.sncf.xspeedit.exceptions.ArticleException;
import com.oui.sncf.xspeedit.model.Article;
import com.oui.sncf.xspeedit.model.Carton;
import org.junit.Test;

/**
 * Test unitaire sur les articles
 */
public class TestArticle {

    @Test(expected = ArticleException.class)
    public void testArticleExceptionChaine() throws ArticleException {
        new Article("on attend un entier compris entre 1 et 9");
    }

    @Test(expected = ArticleException.class)
    public void testArticleExceptionCapacite() throws ArticleException {
        new Article(String.valueOf(Carton.CAPACITE_MAX + 1));
    }
}
