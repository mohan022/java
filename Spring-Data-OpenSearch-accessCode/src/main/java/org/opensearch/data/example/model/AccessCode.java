package org.opensearch.data.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(indexName = "accesscodetesting")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessCode {
	
	@Id
	private int id;
	private String accessCode;
	private String cashedIn;
	private String cashedInDate;
	private String ExpirationDate;
	private String creationDate;
	private String accessCodeBatchId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
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

	
}
