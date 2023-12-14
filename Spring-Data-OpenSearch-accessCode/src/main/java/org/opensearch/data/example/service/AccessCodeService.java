package org.opensearch.data.example.service;

import java.util.List;

import org.opensearch.data.example.model.AccessCode;
import org.springframework.stereotype.Service;

public interface AccessCodeService {
	AccessCode create(AccessCode accessCode);
	List<AccessCode> findByAccessCode(String accCode);
	List<AccessCode> exactSearch(String acc,String cashIn,String cashInDate,String expDate,String CrtDate,String batchId);
	List<AccessCode> containsSearch(String accCode);
	
	
}
