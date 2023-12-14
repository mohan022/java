package org.opensearch.data.example.controller;

import java.util.List;

import org.opensearch.data.example.model.AccessCode;
import org.opensearch.data.example.service.AccessCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accesscode/")
public class AccessCodeController {
	
	private final AccessCodeService accessCodeService;

//	@Autowired
//	AccessCodeService accessCodeService ;
	public AccessCodeController(AccessCodeService service) {
		this.accessCodeService=service;
	}
	
	@RequestMapping("/create")
	@PostMapping
	public AccessCode createAccessCode(@RequestBody AccessCode accessCode) {
		return accessCodeService.create(accessCode);
	}
	
	@RequestMapping("/get/{accessCode}")
	public List<AccessCode> findByAccCode(@PathVariable(value="accessCode") String accCode){
		return accessCodeService.findByAccessCode(accCode);
	}
	
	@RequestMapping("/exact")
	public List<AccessCode> exactSearch(@RequestBody AccessCode acccode ){
		return accessCodeService.exactSearch(acccode.getAccessCode(),acccode.getCashedIn(),acccode.getCashedInDate(),acccode.getExpirationDate(),acccode.getCreationDate(),acccode.getAccessCodeBatchId());
	}
	
	@RequestMapping("/contains")
	public List<AccessCode> containsSearch(@RequestParam(value="accessCode") String accCode){
		return accessCodeService.containsSearch(accCode);
	}
	
	public static class AccessCodeDto{
		private String accessCode;
		private String password;
		private String batchId;
		private String accessCodeTypeId;
		private String cashedIn;
		private String cashedInDate;
		private String accessCodeBatchId;
		private String ExpirationDate;
		private String creationDate;
		private String caseSensitive;
		private String accessCodeSeachType;
		public String getAccessCode() {
			return accessCode;
		}
		public void setAccessCode(String accessCode) {
			this.accessCode = accessCode;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getBatchId() {
			return batchId;
		}
		public void setBatchId(String batchId) {
			this.batchId = batchId;
		}
		public String getAccessCodeTypeId() {
			return accessCodeTypeId;
		}
		public void setAccessCodeTypeId(String accessCodeTypeId) {
			this.accessCodeTypeId = accessCodeTypeId;
		}
		public String getCashedIn() {
			return cashedIn;
		}
		public void setCashedIn(String cashedIn) {
			this.cashedIn = cashedIn;
		}
		public String getCashedInDate() {
			return cashedInDate;
		}
		public void setCashedInDate(String cashedInDate) {
			this.cashedInDate = cashedInDate;
		}
		public String getAccessCodeBatchId() {
			return accessCodeBatchId;
		}
		public void setAccessCodeBatchId(String accessCodeBatchId) {
			this.accessCodeBatchId = accessCodeBatchId;
		}
		public String getExpirationDate() {
			return ExpirationDate;
		}
		public void setExpirationDate(String expirationDate) {
			ExpirationDate = expirationDate;
		}
		public String getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(String creationDate) {
			this.creationDate = creationDate;
		}
		public String getCaseSensitive() {
			return caseSensitive;
		}
		public void setCaseSensitive(String caseSensitive) {
			this.caseSensitive = caseSensitive;
		}
		public String getAccessCodeSeachType() {
			return accessCodeSeachType;
		}
		public void setAccessCodeSeachType(String accessCodeSeachType) {
			this.accessCodeSeachType = accessCodeSeachType;
		}
		
	}
}


