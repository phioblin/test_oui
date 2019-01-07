package com.oui.sncf.xspeedit.model;

import com.oui.sncf.xspeedit.exceptions.ArticleException;

/**
 * Classe modélisant un article
 */
public class Article {

    private int taille;

    /**
     * Constructeur
     *
     * @param tailleStr taille d'un article (doit être compris entre 1 et 9)
     * @throws ArticleException lancée si le paramètre n'est pas un entier compris entre 1 et 9
     */
    public Article(String tailleStr) throws ArticleException {
        int taille;
        try {
            taille=Integer.parseInt(tailleStr);
        } catch (NumberFormatException e) {
            throw new ArticleException("Taille article incorrecte: '"+tailleStr+"' n'est pas un integer");
        }
        if (taille < 1 || taille > 9) {
            throw new ArticleException("Taille article incorrecte: '"+tailleStr+"' n'est pas compris entre 1 et 9");
        }
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public String toString(){
        return Integer.toString(taille);
    }
}
