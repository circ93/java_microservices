package it.nntdata.corso.springjsp.business.impl;

import it.nntdata.corso.springjsp.business.interfaces.WebSiteInfoBO;
import it.nntdata.corso.springjsp.model.WebSiteInfo;
import it.nntdata.corso.springjsp.repository.WebSiteInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteInfoBOImpl implements WebSiteInfoBO {
    @Autowired
    WebSiteInfoRepository webSiteInfoRepository;

    public WebSiteInfo getWebSiteInfo() throws DataAccessException{
        return webSiteInfoRepository.findFirstByOrderByIdDesc();
    }

    public List<WebSiteInfo> getAllSite() throws DataAccessException{
        return webSiteInfoRepository.findAll();
    }

    @Override
    public String createInfo(WebSiteInfo site) throws DataAccessException {

        String msg = null;

        if (site == null) {
            msg = "I dati ineriti non sono validi";
        } else {
            webSiteInfoRepository.save(site);
            msg = "Info inserite correttamente!";
        }

        return msg;
    }

    @Override
    public String deleteInfo(long id) throws DataAccessException {
        WebSiteInfo _site = webSiteInfoRepository.getReferenceById(id);
        String msg = null;

        if (_site == null){
            msg = "Id non trovato";
        } else {
            webSiteInfoRepository.deleteById(id);
            msg = "Info eliminata!";
        }
        return msg;
    }

    @Override
    public WebSiteInfo searchSiteByID(long id) throws DataAccessException {
        WebSiteInfo _info = webSiteInfoRepository.getReferenceById(id);

        if (_info == null){
            return null;
        } else {
            return _info;
        }
    }

    @Override
    public void saveInfo(WebSiteInfo site) throws DataAccessException {
        webSiteInfoRepository.save(site);
    }
}
