package Com.dailycodebuffer.tutorial.Springfullcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.dailycodebuffer.tutorial.Springfullcourse.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	
	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);

	
}
