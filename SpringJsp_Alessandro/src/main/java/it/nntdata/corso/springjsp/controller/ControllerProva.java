package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.WebSiteInfoBO;
import it.nntdata.corso.springjsp.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerProva {

    @Autowired
    WebSiteInfoBO webSiteInfoBO;

    // prova per recupero parametri passati da un altro controller, updateInfo() nel controler WebSiteInfoController
    @PostMapping(path = {"/sites4"})
    public ModelAndView sites4(){
        List<WebSiteInfo> listSites = webSiteInfoBO.getAllSite();
        return new ModelAndView("/jsp/feature.jsp", "sites", listSites);
    }

}
