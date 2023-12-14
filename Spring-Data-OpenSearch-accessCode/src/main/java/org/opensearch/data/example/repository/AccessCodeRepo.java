package org.opensearch.data.example.repository;

import java.util.List;

import org.opensearch.data.example.model.AccessCode;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessCodeRepo extends ElasticsearchRepository<AccessCode, String> {
	
	List<AccessCode> findByAccessCode(String accCode);
	
	@Query(" {\r\n"
			+ "     \"bool\": {\r\n"
			+ "       \"filter\": [\r\n"
			+ "         {\"term\": {\r\n"
			+ "           \"accessCode.keyword\": {\"value\":\"?0\",\"case_insensitive\":true}\r\n"
			+ "         }},\r\n"
			+ "         {\"term\": {\r\n"
			+ "           \"cashedIn.keyword\": {\"value\":\"?1\",\"case_insensitive\":true}\r\n"
			+ "         }},\r\n"
			+ "         {\"term\": {\r\n"
			+ "           \"cashedInDate.keyword\": {\"value\":\"?2\",\"case_insensitive\":true}\r\n"
			+ "         }},\r\n"
			+ "         {\"term\": {\r\n"
			+ "           \"ExpirationDate.keyword\": {\"value\":\"?3\",\"case_insensitive\":true}\r\n"
			+ "         }},\r\n"
			+ "         {\"term\": {\r\n"
			+ "           \"creationDate.keyword\": {\"value\":\"?4\",\"case_insensitive\":true}\r\n"
			+ "         }}\r\n"
			+ "       ],\r\n"
			+ "       \"must\": [\r\n"
			+ "         {\"match\": {\r\n"
			+ "           \"accessCodeBatchId\": {\"query\": \"?5\"}\r\n"
			+ "         }}\r\n"
			+ "       ]\r\n"
			+ "     }\r\n"
			+ "   }")
	List<AccessCode> exactSearch(String accessCode,String cashedIn,String cashedInDate,String expirationDate,String creationDate,String accessCodeBatchId);
	
	@Query(" {\"bool\":\r\n"
			+ " {\"filter\": \r\n"
			+ " [],\"must\": [\r\n"
			+ "   {\"match\": {\r\n"
			+ "     \"accessCode\": {\"query\": \"?0\"}\r\n"
			+ "   }}\r\n"
			+ " ]\r\n"
			+ " }}")
	List<AccessCode> containsSearch(String accessCode);
}
