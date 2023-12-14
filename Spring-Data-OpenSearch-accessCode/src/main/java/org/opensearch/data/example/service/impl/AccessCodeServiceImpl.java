package org.opensearch.data.example.service.impl;

import java.util.List;

import org.opensearch.data.example.model.AccessCode;
import org.opensearch.data.example.repository.AccessCodeRepo;
import org.opensearch.data.example.service.AccessCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessCodeServiceImpl implements AccessCodeService {
	
	@Autowired
	AccessCodeRepo accessCodeRepo;

	@Override
	public List<AccessCode> findByAccessCode(String accCode) {
		return accessCodeRepo.findByAccessCode(accCode);
	}

	@Override
	public AccessCode create(AccessCode accessCode) {
		return accessCodeRepo.save(accessCode);
	}

	@Override
	public List<AccessCode> exactSearch(String acc,String cashIn,String cashInDate,String expDate,String CrtDate,String batchId) {
		return accessCodeRepo.exactSearch( acc, cashIn, cashInDate, expDate, CrtDate, batchId);
	}

	@Override
	public List<AccessCode> containsSearch(String accCode) {
		return accessCodeRepo.containsSearch(accCode);
	}
}
