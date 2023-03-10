package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.WebSiteInfoBO;
import it.nntdata.corso.springjsp.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // mi occorre perche quando la richiamo dall'update la chiamata è POST
    // metodo 1 -> se non mi trovo nello stesso controller i parametri glieli passo concatenati alla chiamata e  li recupero tramite @RequestParam
    @PostMapping(path = {"/sites"})
    public ModelAndView sites2(@RequestParam String msg){
        List<WebSiteInfo> listSites = webSiteInfoBO.getAllSite();
        ModelAndView _model =new ModelAndView("/jsp/feature.jsp", "sites", listSites);
        _model.addObject("msg_update", msg);
         return _model;
    }

    //metodo 2 -> se mi trovo nello stesso controller non mi occorre recuperare i parametri passati da un altro metodo,
    // in questo caso dell'update, verranno recuperati e concatenati alla richiesta in automatico, li recupero senza problemi nella jsp
    @PostMapping(path = {"/sites3"})
    public ModelAndView sites3(){
        List<WebSiteInfo> listSites = webSiteInfoBO.getAllSite();
        return new ModelAndView("/jsp/feature.jsp", "sites", listSites);
    }

    //la get mi occorre per aprire la pagina del form
    @GetMapping(path = {"/createInfo"})
    public ModelAndView insertInfo() {
        return new ModelAndView("/jsp/createInfo.jsp");
    }

    // la Post crea effettivamente il nuovo oggetto e lo salva,
    // poi richiama la get sopra per visualizzare nuovamente la pagina con il messaggio di successo o errore
    @PostMapping(path = {"/createInfo"})
    public ModelAndView insertInfo(@RequestParam String name, @RequestParam String description) {
        WebSiteInfo site = new WebSiteInfo();
        site.setName(name);
        site.setDescription(description);

        String msg = webSiteInfoBO.createInfo(site);

        return new ModelAndView("/jsp/createInfo.jsp", "msg_insert", msg);
    }

    @GetMapping(path = {"/deleteSite"})
    public ModelAndView deleteSite(@RequestParam Long id) {

        String msg = webSiteInfoBO.deleteInfo(id);
        return new ModelAndView("sites", "msg_delete", msg);
    }

    @GetMapping(path = {"/searchInfo"})
    public ModelAndView searchInfo(@RequestParam Long id) {
        WebSiteInfo _site = webSiteInfoBO.searchSiteByID(id);
        String msg;
        if (_site == null){
            msg = "Utente non trovato!";
            return new ModelAndView("sites", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/edit.jsp", "info", _site);
        }
    }

    @PostMapping(path = {"/updateInfo"})
    public ModelAndView updateInfo(@RequestParam Long id, String name, String description) {
        WebSiteInfo _info = webSiteInfoBO.searchSiteByID(id);
        String msg = null;

        if (_info == null) {
            msg = "Non è stato possibile eliminare l'id selezionato.";
        } else {
            _info.setName(name);
            _info.setDescription(description);

            webSiteInfoBO.saveInfo(_info);
            msg = "Info aggiornate correttamente!";
        }
        // metodo 2 -> chiamando un metodo dello stesso controller passo il parametro come al solito,
        // nel metodo post /site3 non mi occorre recuperarlo perchè verrà concatenato in automatico e
        // posso recuperare msg_update nella jsp.
        return new ModelAndView("sites3", "msg_update", msg);

        // metodo 2 -> richiamo un metodo di un controller diverso e recupera lo stesso i dati
        //return new ModelAndView("sites4", "msg_update", msg);

        // metodo 1 -> se chiamassi un metodo di un controller diverso devo concatenare il msg
        //return new ModelAndView("sites?msg="+msg);

    }

}
