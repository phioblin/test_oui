package com.oui.sncf.xspeedit.test.service;

import com.oui.sncf.xspeedit.Util;
import com.oui.sncf.xspeedit.model.Carton;
import com.oui.sncf.xspeedit.service.EmballageService;
import com.oui.sncf.xspeedit.service.impl.EmballageServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitaire du service d'emballage optimisé
 */
public class TestEmballageService {

    private EmballageService service=new EmballageServiceImpl();

    @Test
    public void test1(){
        String res=Util.listCartonToString(service.emballer(Util.genererListeArticlesFromString("67298721129")));
        Assert.assertEquals(res, "91/91/82/72/72/6");
    }

    @Test
    public void test2(){
        String res=Util.listCartonToString(service.emballer(Util.genererListeArticlesFromString("549111234567111133")));
        Assert.assertEquals(res, "91/7111/6111/523/53/43/4");
    }

    @Test
    public void test3(){
        String res=Util.listCartonToString(service.emballer(Util.genererListeArticlesFromString("1111111111111111")));
        Assert.assertEquals(res, "1111111111/111111");
    }

    /**
     * Test si la capacité max du carton n'a pas été dépassé
     */
    @Test
    public void testCapaciteCarton(){
        boolean isOk=true;
        String res=Util.listCartonToString(service.emballer(Util.genererListeArticlesFromString("4872356419211")));
        String[] cartons=res.split("/");
        for(String c:cartons){
            int sum=0;
            for(char a:c.toCharArray()){
                sum += Character.getNumericValue(a);
            }
            if(sum > Carton.CAPACITE_MAX){
                isOk=false;
                break;
            }
        }
        Assert.assertTrue(isOk);
    }
}
