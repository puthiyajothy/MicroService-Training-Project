package HystrixCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.java.employee.model.Employee;
import com.java.employee.model.ResourceAllocation;

public class ResourceAllocationCommand extends HystrixCommand<ResourceAllocation[]> {

	Employee employee;
	HttpHeaders httpHeaders;
	RestTemplate restTemplate;

	public ResourceAllocationCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.employee = employee;
		this.httpHeaders = httpHeaders;
		this.restTemplate = restTemplate;
	}

	@Override
	protected ResourceAllocation[] run() throws Exception {
		HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
		ResponseEntity<ResourceAllocation[]> responseEntity = restTemplate.exchange(
				"http://localhost:8083/projectservice/employeebyid/" + employee.getId(), HttpMethod.GET, httpEntity,
				ResourceAllocation[].class);
		return responseEntity.getBody();

	}

	@Override
	protected ResourceAllocation[] getFallback() {
		return new ResourceAllocation[1];
	}

}
