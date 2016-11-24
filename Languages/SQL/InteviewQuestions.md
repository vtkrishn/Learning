https://www.google.com/#q=sql+interview+questions
https://en.wikibooks.org/wiki/SQL_Exercises

* SELECT count(emp.EMPLOYEE_ID) cnt,
* mgr.EMPLOYEE_ID,
* mgr.FIRST_NAME
* FROM employees emp,
* employees mgr
* WHERE emp.MANAGER_ID = mgr.employee_id
* group by mgr.EMPLOYEE_ID,
* mgr.FIRST_NAME
* order by cnt;
