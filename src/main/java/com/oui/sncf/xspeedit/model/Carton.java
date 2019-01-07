package com.oui.sncf.xspeedit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe modélisant un carton
 */
public class Carton {

    public static int CAPACITE_MAX=10;

    private List<Article> articles=new ArrayList<>();

    /**
     * Pour ajouter un article au carton
     * @param article article à ajouter
     */
    public void add(Article article){
        if(canAdd(article)){
            this.articles.add(article);
        }
    }

    /**
     * Test si le l'article passé en paramètre peut rentrer dans le carton
     * @param article article à tester
     * @return true si et seulement l'article rentre dans le carton
     */
    public boolean canAdd(Article article) {
        return (article != null) && ((getCapacite() + article.getTaille()) <= CAPACITE_MAX);
    }

    /**
     * Fournit la capacité courante du carton
     * @return capacite
     */
    public int getCapacite(){
        int capacite=0;
        for(Article a:articles){
            capacite=capacite+a.getTaille();
        }
        return capacite;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        articles.forEach(sb::append);
        return sb.toString();
    }
}
