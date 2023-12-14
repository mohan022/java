package org.opensearch.data.example.model;

public class AccessCodeSearchResponse {
    private String accessCode;
    private Integer accessCodeTypeId;
    private String cashedIn;
    private String cashedInDate;
    private Integer accessCodeBatchId;
    private String expirationDate;
    private String creationDate;
    private String password;
    
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public Integer getAccessCodeTypeId() {
		return accessCodeTypeId;
	}
	public void setAccessCodeTypeId(Integer accessCodeTypeId) {
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
	public Integer getAccessCodeBatchId() {
		return accessCodeBatchId;
	}
	public void setAccessCodeBatchId(Integer accessCodeBatchId) {
		this.accessCodeBatchId = accessCodeBatchId;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    

}
