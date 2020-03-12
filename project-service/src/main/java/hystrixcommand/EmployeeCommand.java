package hystrixcommand;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.java.project.model.Employee;
import com.java.project.model.ResourceAllocation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class EmployeeCommand extends HystrixCommand<Employee[]> {
	ResourceAllocation allocation;
	HttpHeaders httpHeaders;
	RestTemplate restTemplate;

	public EmployeeCommand(ResourceAllocation allocation, HttpHeaders httpHeaders, RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.allocation = allocation;
		this.httpHeaders = httpHeaders;
		this.restTemplate = restTemplate;
	}

	@Override
	protected Employee[] run() throws Exception {
		HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(
				"http://EMPLOYEE/employeeservice/employeebyid/" + allocation.getId(), HttpMethod.GET, httpEntity,
				Employee[].class);
		return responseEntity.getBody();

	}

	@Override
	protected Employee[] getFallback() {
		return new Employee[1];
	}

}
