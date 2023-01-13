package it.nntdata.corso.springjsp.business.interfaces;

import it.nntdata.corso.springjsp.model.WebSiteInfo;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WebSiteInfoBO {

    public WebSiteInfo getWebSiteInfo() throws DataAccessException;

    public List<WebSiteInfo> getAllSite() throws DataAccessException;

    public String createInfo(WebSiteInfo site) throws DataAccessException;

    public String deleteInfo(long id) throws DataAccessException;

    public WebSiteInfo searchSiteByID(long id) throws DataAccessException;

    public void saveInfo(WebSiteInfo site) throws DataAccessException;
}
