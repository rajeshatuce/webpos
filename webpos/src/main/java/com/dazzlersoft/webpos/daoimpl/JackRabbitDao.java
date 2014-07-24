package com.dazzlersoft.webpos.daoimpl;

import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jackrabbit.core.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.dazzlersoft.webposutil.WebPosGenericException;

public class JackRabbitDao {
	
	private static final Log LOG = LogFactory.getLog(JackRabbitDao.class);
	
	@Autowired
	private RepositoryImpl repository;

	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	public Session getSession() throws WebPosGenericException{
		try{
			Session session = repository.login( 
					new SimpleCredentials(userId, password.toCharArray()));
			return session;
		}catch(Exception err){
			LOG.error("Error occurred while connecting to content repository",err);
			throw new WebPosGenericException("Error occurred while connecting to content repository", err);
		}
	}
}
