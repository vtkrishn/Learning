SELECT MAX(salary)
FROM EMPLOYEES
WHERE salary <
  (SELECT MAX(salary) FROM EMPLOYEES
  );

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

  --timestamp, date, to_char, interval
  select TIMESTAMP '1997-01-31 09:26:50.124' from dual;
  select DATE '1997-01-31' from dual;
  select sysdate from dual;
  select INTERVAL '-15' MONTH from dual; -- -01-03
  select INTERVAL '15' MONTH from dual; -- +01-03
  select INTERVAL '2' YEAR from dual; --+02-00
  select INTERVAL '2' DAY from dual;
  select INTERVAL '2' HOUR from dual;
  select INTERVAL '65' MINUTE from dual;
  select INTERVAL '65' SECOND from dual; -- +00 00:01:05.000000
  select INTERVAL '4 5:12' DAY TO MINUTE from dual; -- +04 05:12:00.000000
  select TO_CHAR (TO_DATE('0297','MM/YY'), 'MM/YY') from dual;
  select TO_CHAR (sysdate, 'Day') from dual;
  select TO_CHAR (sysdate, 'Year') from dual;
  select TO_CHAR (sysdate, 'Month') from dual;
  select TO_CHAR (123.12, '0999.999') from dual;

  --common numeric functions
  select abs(-45) from dual; -- 45
  select ceil(45.67) from dual; -- 46
  select floor(45.67) from dual; -- 45
  select log(10,2) from dual; -- 0.300
  select mod(24,5) from dual; -- 4
  select remainder(24,5) from dual; -- -1
  select round(24.4545456,4) from dual; -- 24.4545
  select sign(-24) from dual; -- -1
  select trunc(123.454545) from dual; -- 123
  select trunc(0000121) from dual; -- 121

  --common string functions
  select chr(65) from dual; -- A
  select ascii('a') from dual; -- 97
  select concat('->','<-') from dual; -- -><-
  select initcap('vinod') from dual; -- Vinod
  select lpad('vinod',13) from dual; -- '        vinod'
  select rpad('    vinod',9) from dual; -- '    vinod '
  select replace('Vinod','V','S') from dual; -- Sinod
  select rtrim('vinod    ') from dual; -- 'vinod'
  select ltrim('    vinod') from dual; -- 'vinod'
  select upper('vinod') from dual; -- VINOD
  select trim('    vinod    ') from dual; -- 'vinod'
  select SUBSTR('ABCDEFG',3,4) from dual; -- 'CDEF'
  select length('ABCDEFG') from dual; -- 7
  select INSTR('CORPORATE FLOOR','OR', 10, 1) from dual; -- beginning from 10th character 1st occurance

  --comparison function
   select greatest(11,2,3,7,8,45) from dual; -- greatest
  select least(11,2,3,7,8,45) from dual; -- 2

  --null check function
  select nvl(commission_pct,-1) from employees; -- for null records it will be shown as -1

  --environment function
  select user from dual; -- HR
  select uid from dual; -- 43
  select userenv('sessionid') from dual; --
  select userenv('language') from dual; --

  --decoding function
  select decode(first_name, 'Ellen', 'simple',first_name) from employees;

  --Agregate function
  select max(first_name) from EMPLOYEES; --Winston
  select min(first_name) from EMPLOYEES; -- Adam
  select avg(SALARY) from EMPLOYEES; -- 6461.831775700934579439252336448598130841
  select sum(salary) from employees; -- 691416
  select (salary) from employees; -- 691416

  --analytics function
  select DEPARTMENT_ID, count(*) over (PARTITION by DEPARTMENT_ID order by salary desc nulls last) RANK from EMPLOYEES;
  select DEPARTMENT_ID, RANK() over (PARTITION by DEPARTMENT_ID order by salary desc nulls last) RANK from EMPLOYEES;
select * from EMPLOYEES;

  --create a table
  create table my_table(
  id number PRIMARY KEY,
  name varchar2(10)
  );
  --create a view
  create view my_table_view AS
  select id,name from my_table;
  --Insert into the table
  insert into my_table(id,name) values (1,'vinod1');
  insert into my_table(id,name) values (2,'vinod2');
  insert into my_table(id,name) values (3,'vinod3');
  --update into the table
  update my_table set name='sandhya' where name = 'vinod2';

  --Create Function
  CREATE Function new_function return number is
  BEGIN
    return 1;
  END;

  --Create Type
  Create type my_type as object(
    myt VARRAY
  );

   --REGEX
   select regexp_substr(first_name,'Steve') from employees; -- list otherse as null, Steve it will return as steve
   select first_name from employees where regexp_like(first_name,'[S]'); -- Steven
   SELECT
  REGEXP_REPLACE(phone_number,
                 '([[:digit:]]{3})\.([[:digit:]]{3})\.([[:digit:]]{4})',
                 '(\1) \2-\3') "REGEXP_REPLACE"
  FROM employees;

  --EXISTS
  SELECT department_id
  FROM departments d
  WHERE EXISTS
  (SELECT * FROM employees e
    WHERE d.department_id
    = e.department_id);

  --Hierarchical
  SELECT employee_id, last_name, manager_id, level
   FROM employees
   start with employee_id = 101
   CONNECT BY PRIOR employee_id = manager_id;

   SELECT 3 FROM DUAL
   u
SELECT 4 FROM DUAL;

   --All, ANY, SOME for = comparison
  SELECT * FROM employees
  WHERE salary = SOME
  (SELECT salary
   FROM employees
  WHERE department_id = 30);
  SELECT * FROM employees
  WHERE salary = ANY
  (SELECT salary
   FROM employees
  WHERE department_id = 30);
  SELECT * FROM employees
  WHERE salary = ALL
  (SELECT salary
   FROM employees
  WHERE department_id = 30);

select /*+ FIRST_ROWS(10) */ * from my_table_view;

select employees.FIRST_NAME from employees
union
select departments.DEPARTMENT_NAME from departments;

select employees.FIRST_NAME from employees
union all
select departments.DEPARTMENT_NAME from departments;

select employees.FIRST_NAME from employees
minus
select departments.DEPARTMENT_NAME from departments;

select max(id) from (select id from MY_TABLE
union
select id from MY_TABLE);
