package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.WebSiteInfoBO;
import it.nntdata.corso.springjsp.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebSiteInfoController {
    @Autowired
    WebSiteInfoBO webSiteInfoBO;

    @GetMapping(path = {"/","/index"})
    public ModelAndView home(){
        WebSiteInfo webSiteInfo = webSiteInfoBO.getWebSiteInfo();

        return new ModelAndView("/jsp/index.jsp","Info",webSiteInfo);
    }

    @GetMapping(path = {"/sites"})
    public ModelAndView sites(){
        List<WebSiteInfo> listSites = webSiteInfoBO.getAllSite();

        return new ModelAndView("/jsp/feature.jsp", "sites", listSites);
    }

}
