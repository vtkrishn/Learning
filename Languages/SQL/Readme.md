Common functions

ABS(value)
TO_DATE(String,Format)
TO_TIMESTAMP(String,Format)
TO_CHAR(String)
TRUNC(Number or Date or String as Number, format)
ASCII(character)/asciistr(character)
ADD_MONTHS(Date1,Number)
MONTHS_BETWEEN(Date1, Date2)
LENGTH(String)
ROUND(number)

Date timestamp literals
sysdate
systimestamp
DATE <date>
TIMESTAMP <date with timestamp>

Query Hints
/*+ ALL_ROWS */
/*+ FIRST_ROWS */
/*+ FULL(table) */
/*+ INDEX(table index) */
/*+ NO_INDEX(table index) */

V$SYSSTATS

Syntax

create view v as select * from dual;
INSERT INTO departments   VALUES (280, 'ENTERTAINMENT_CLERK', 206, 1700);
DROP TABLE hr.employees;
UPDATE customers c SET c.cust_address.postal_code = '14621-2604' WHERE c.cust_address.city = 'Rochester' AND c.cust_address.state_province = 'NY'

CREATE TYPE cust_address_typ
  OID '82A4AF6A4CD1656DE034080020E0EE3D'
  AS OBJECT
    (street_address    VARCHAR2(40),
     postal_code       VARCHAR2(10),
     city              VARCHAR2(30),
     state_province    VARCHAR2(10),
     country_id        CHAR(2));

CREATE TABLE customers
  (customer_id        NUMBER(6),
   cust_first_name    VARCHAR2(20) CONSTRAINT cust_fname_nn NOT NULL,
   cust_last_name     VARCHAR2(20) CONSTRAINT cust_lname_nn NOT NULL,
   cust_address       cust_address_typ);

Psuedo columns
CONNECT_BY_ISCYCLE
CONNECT_BY_ISLEAF
LEVEL
SELECT FIRST_NAME "Employee", CONNECT_BY_ISLEAF "IsLeaf"   FROM employees CONNECT BY PRIOR employee_id = manager_id;

sequence.CURRVAL
sequence.NEXTVAL

SELECT COLUMN_VALUE FROM XMLTABLE('<a>123</a>');

CREATE TYPE phone AS TABLE OF NUMBER;   
/
CREATE TYPE phone_list AS TABLE OF phone;
/

SELECT t.COLUMN_VALUE   FROM TABLE(phone_list(phone(1,2,3))) p, TABLE(p.COLUMN_VALUE) t;

OBJECT_ID

SELECT ROWID, last_name   FROM employees   WHERE department_id = 20;
SELECT *   FROM employees   WHERE ROWNUM < 11

Operators

CONNECT BY [PRIOR]
CONNECT_BY_ROOT  

UNION
UNION ALL
INTERSECT
MINUS

CASE WHEN THEN END
select first_name,
case when employee_id>100  then
'low'
end as simple
from employees;

SELECT department_name, CURSOR(SELECT salary, commission_pct
   FROM employees e
   WHERE e.department_id = d.department_id)
   FROM departments d
   ORDER BY department_name;

LIKE
REGEXP_LIKE

select * from employees where exists (select 1 from departments where department_id=101);
functions
http://docs.oracle.com/database/121/SQLRF/functions002.htm#SQLRF30049

SELECT AVG(salary),DEPARTMENT_ID
FROM employees
GROUP BY DEPARTMENT_ID;
  
