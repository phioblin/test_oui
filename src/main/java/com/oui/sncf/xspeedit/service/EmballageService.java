package com.oui.sncf.xspeedit.service;

import com.oui.sncf.xspeedit.model.Article;
import com.oui.sncf.xspeedit.model.Carton;

import java.util.List;

public interface EmballageService {

    /**
     * Emballe une liste d'article de manière optimisée
     * @param articles liste d'articles
     * @return liste de carton remplie de manière optimisée
     */
    List<Carton> emballer(List<Article> articles);
}
