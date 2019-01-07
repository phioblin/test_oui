package com.oui.sncf.xspeedit;

import com.oui.sncf.xspeedit.exceptions.ArticleException;
import com.oui.sncf.xspeedit.model.Article;
import com.oui.sncf.xspeedit.model.Carton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Classe utilitaire
 */
public class Util {

    private static final Logger LOG = LoggerFactory.getLogger(Util.class);

    /**
     * Méthode utilitaire pour les tests transformant une chaine d'entier 65391326 en liste d'article
     * @param str chaine d'entiers représentant une liste d'article
     */
    public static List<Article> genererListeArticlesFromString(String str) {
        List<Article> output = new ArrayList<>();
        if(str!=null) {
            for (String c : str.split("")) {
                try {
                    output.add(new Article(c));
                } catch (ArticleException e) {
                    LOG.warn("le caractère " + c + " ne peut pas être transformé en article");
                }
            }
        }
        return output;
    }

    /**
     * Méthode utilitaire pour les tests transformant une liste de carton en chaine 163/8/41/6/8/9/52/5/7/73
     * @param cartons liste de carton
     * @return chaine représentant la liste de carton passée en paramètre
     */
    public static String listCartonToString(List<Carton> cartons){
        if(cartons==null) return "";
        StringJoiner joiner = new StringJoiner("/");
        cartons.forEach(carton -> joiner.add(carton.toString()));
        return joiner.toString();
    }

}
