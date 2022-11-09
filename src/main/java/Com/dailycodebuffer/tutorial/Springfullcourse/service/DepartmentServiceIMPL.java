package Com.dailycodebuffer.tutorial.Springfullcourse.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.dailycodebuffer.tutorial.Springfullcourse.Entity.Department;
import Com.dailycodebuffer.tutorial.Springfullcourse.repository.DepartmentRepository;

@Service
public class DepartmentServiceIMPL implements DepartmentService {

	@Autowired
    private DepartmentRepository departmentRepository;
	
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}


	@Override
	public Department fetchDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}


	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
	Department dept=departmentRepository.findById(departmentId).get();
	
	  if(Objects.nonNull(department.getDepartmentName()) &&
	!"".equalsIgnoreCase(department.getDepartmentName())) {
	dept.setDepartmentName(department.getDepartmentName());
	}
	
	  if(Objects.nonNull(department.getDepartmentCode()) &&
	!"".equalsIgnoreCase(department.getDepartmentCode())) {
	dept.setDepartmentCode(department.getDepartmentCode());
	}
	
	  if(Objects.nonNull(department.getDepartmentAddress()) &&
	!"".equalsIgnoreCase(department.getDepartmentAddress())) {
	dept.setDepartmentAddress(department.getDepartmentAddress());

	}
	
	return departmentRepository.save(dept);
	
	}


	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}
}