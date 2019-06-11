package com.source.record.ajax.utils;

import org.springframework.web.context.request.WebRequest;

public abstract class AjaxUtils {

	public static boolean isAjaxRequest(WebRequest webRequest) {
		String requestedWith = webRequest.getHeader("X-Requested-With");
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}
}

//public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//
//	@Query("SELECT new com.jeejava.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d INNER JOIN d.employees e")
//	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();
//
//	@Query("SELECT new com.jeejava.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d, Employee e")
//	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
//
//}