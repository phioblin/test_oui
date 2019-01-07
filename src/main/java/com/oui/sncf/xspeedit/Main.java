package com.oui.sncf.xspeedit;

import com.oui.sncf.xspeedit.model.Carton;
import com.oui.sncf.xspeedit.service.EmballageService;
import com.oui.sncf.xspeedit.service.impl.EmballageServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * Main de l'application à lancer sans paramètre
 * @author P.OBLIN
 */
public class Main {

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir une chaîne d'articles en entrée :");
        String articles = sc.nextLine();
        EmballageService service=new EmballageServiceImpl();
        List<Carton> cartons= service.emballer(Util.genererListeArticlesFromString(articles));
        System.out.println("Chaîne d'articles emballés  :"+Util.listCartonToString(cartons));
    }
}
