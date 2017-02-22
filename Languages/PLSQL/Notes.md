* Declaration
* execution
* Exception

>DECLARE
     Variable declaration
BEGIN
     Program Execution
EXCEPTION
     Exception handling
END;


Variables
>salary_increase number (3)
salary_increase := 10;

Constants
>salary_increase CONSTANT number (3) := 10;

IF THEN ELSE
>IF condition
THEN
 statement 1;
ELSE
 statement 2;
END IF;

LOOP
>LOOP
   statements;
   EXIT;
   {or EXIT WHEN condition;}
END LOOP;

WHILE
>WHILE <condition>
 LOOP statements;
END LOOP;

FOR
>FOR counter IN val1..val2
  LOOP statements;
END LOOP;

Cursor
>%FOUND
%NOTFOUND
%ROWCOUNT

>CURSOR cursor_name IS select_statement;
OPEN cursor_name;
FETCH cursor_name INTO record_name;
CLOSE cursor_name;

>1> DECLARE
2>  CURSOR emp_cur IS
3>  SELECT first_name, last_name, salary FROM emp_tbl;
4>  emp_rec emp_cur%rowtype;
5> BEGIN
6>  FOR emp_rec in sales_cur
7>  LOOP  
8>  dbms_output.put_line(emp_cur.first_name || ' ' ||emp_cur.last_name
9>    || ' ' ||emp_cur.salary);  
10> END LOOP;
11>END;
12> /

EXCEPTION
>DECLARE
  Declaration section
BEGIN
  Exception section
EXCEPTION
WHEN ex_name1 THEN
   -Error handling statements
WHEN ex_name2 THEN
   -Error handling statements
WHEN Others THEN
  -Error handling statements
END;
