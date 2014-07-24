package com.dazzlersoft.webpos.dao;

import com.dazzlersoft.webposutil.WebPosGenericException;

public interface ContentRepositoryDao {

	public byte[] getImageContent(String imageId) throws WebPosGenericException;
	
	public void addContent() throws Exception;
}
