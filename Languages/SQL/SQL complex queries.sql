--get all the managers of each of the employee
 -- order based on the manager id
 -- within the employees inside the manager order by max salary employee
 --filter the salary more than 10000
 --if the name starts with S then display with 'VP' suffixed
 select
 case
 when mgr.FIRST_NAME like 'S%' then mgr.FIRST_NAME || '(VP)'
 else
 mgr.FIRST_NAME
 end
 , emp.MANAGER_ID, count(emp.EMPLOYEE_ID),emp.FIRST_NAME ,emp.SALARY
 from employees emp, employees mgr
 where emp.MANAGER_ID = mgr.EMPLOYEE_ID
 group by emp.MANAGER_ID,mgr.FIRST_NAME,emp.FIRST_NAME,emp.SALARY
 having emp.SALARY > 10000
 order by emp.MANAGER_ID,max(emp.SALARY) desc;
