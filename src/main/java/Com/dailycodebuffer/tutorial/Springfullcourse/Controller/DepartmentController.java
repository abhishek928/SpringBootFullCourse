package Com.dailycodebuffer.tutorial.Springfullcourse.Controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Com.dailycodebuffer.tutorial.Springfullcourse.Entity.Department;
import Com.dailycodebuffer.tutorial.Springfullcourse.service.DepartmentService;
import ch.qos.logback.classic.Logger;

@RestController
public class DepartmentController {
     
	@Autowired
	private DepartmentService departmentService;
		
			
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/department")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/update/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}
	
	
	 @GetMapping("/department/name/{name}")
	    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	
	   }

	
}
