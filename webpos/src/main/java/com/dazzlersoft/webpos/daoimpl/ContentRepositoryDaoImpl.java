package com.dazzlersoft.webpos.daoimpl;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dazzlersoft.webpos.dao.ContentRepositoryDao;
import com.dazzlersoft.webposutil.WebPosGenericException;


@Repository
public class ContentRepositoryDaoImpl implements ContentRepositoryDao {

	private static final Log LOG = LogFactory.getLog(ContentRepositoryDaoImpl.class);

	@Autowired
	private  JackRabbitDao jackRabbitDao;

	public byte[] getImageContent(String imageId) throws WebPosGenericException{
		LOG.debug("Fetching image content with inage key:"+imageId);
		Session session=null;
		byte[] byteContent=null;
		try {
			session = jackRabbitDao.getSession();
			Node folder = session.getRootNode(); 
			Node file=folder.getNode(imageId);
			Node content=file.getNode("jcr:content");
			String path = content.getPath();
	        Binary bin = session.getNode(path).getProperty("jcr:data").getBinary();
	        InputStream stream = bin.getStream();
	        byteContent= IOUtils.toByteArray(stream);
			session.logout();
			return byteContent;
		} catch (Exception err) {
			LOG.error("Error occurred while fetching content with key:"+imageId+",from repository",err);
			throw new WebPosGenericException("Error occurred while fetching content with key:"+imageId+",from repository", err);
		}finally{
			if(session!=null){
				session.logout();
			}
		}
	}

	public void addContent() throws Exception {
		Session session=null;
		try{
			session = jackRabbitDao.getSession();
			InputStream stream = new BufferedInputStream(ContentRepositoryDaoImpl.class.getResourceAsStream("8.jpg"));
			Node folder = session.getRootNode(); 
			Node file = folder.addNode("8","nt:file");
			Node content = file.addNode("jcr:content","nt:resource");
			Binary binary = session.getValueFactory().createBinary(stream);
			content.setProperty("jcr:data",binary);
			content.setProperty("jcr:mimeType","image/gif");
			session.save(); 
		}finally{
			session.logout(); 
		}
		
	}

}
