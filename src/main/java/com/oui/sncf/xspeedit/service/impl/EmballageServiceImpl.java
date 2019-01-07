package com.oui.sncf.xspeedit.service.impl;

import com.oui.sncf.xspeedit.model.Article;
import com.oui.sncf.xspeedit.model.Carton;
import com.oui.sncf.xspeedit.service.EmballageService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe d'implémentation du service {@link EmballageService}
 */
public class EmballageServiceImpl implements EmballageService {

    private Comparator<Article> ascendingComparator = new Comparator<Article>() {
        @Override
        public int compare(Article a1, Article a2) {
            return a1.getTaille() - a2.getTaille();
        }
    };

    /**
     * Méthode implémentant le coeur de l'algorithme d'emballage optimisé
     * @param articles liste d'articles
     * @return une liste de cartons remplie
     */
    @Override
    public List<Carton> emballer(List<Article> articles) {
        List<Carton> output=new ArrayList<>();
        if(articles==null) return output;

        //on trie la liste d'article du plus petit au plus grand
        articles.sort(ascendingComparator);

        //tout pendant qu'il y a des articles à emballer, on prend l'article le plus grand de la liste, on le met dans
        //un carton et on complète par des articles plus petits (ceux en début de liste) jusqu'à ce qu'on ne
        //puisse plus remplir le carton. Puis on passe à un autre carton.
        while(!articles.isEmpty()){
            Carton c=new Carton();
            output.add(c);
            c.add(articles.remove(articles.size()-1));
            while(!articles.isEmpty() && c.canAdd(articles.get(0))){
                c.add(articles.remove(0));
            }
        }
        return output;
    }
}
