package com.oui.sncf.xspeedit.exceptions;

/**
 * Exception lancée dans le cas où un article ne peut pas être créé
 */
public class ArticleException extends Exception {

    public ArticleException(String message){
        super(message);
    }
}
