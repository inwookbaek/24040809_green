/* Function

	 1. Function?
	 
	    보통의 경우 값을 계산하고 그 결과값을 반환하기 위해서 function을 사용한다.
			대부분 프로시저와 유사하지만 
			1) "in 파리미터"만 사용할 수 있다.
			2) 반드시 반환될 값의 데이타입을 return문에 선언해야 한다.
			
	 2. 문법
	 
	    1) pl/sql block에는 적어도 한개의 return문이 있어야 한다.
			2) pl/sql block은 함수가 수행할 내용을 정의한 본문(body)부분이다.
			3) 선언방법
			
			   create or replace function 평션이름
				    (매개변수 in 데이터타입) 
						return 데이터타입 -> return될 값의 데이터타입을 선언 
			   is[as]
						변수선언
				 begin
				 
				 
						return 변수명 --> 리턴문이 반드시 존재해야 한다.
				 end;
*/

-- 실습1. 사원번호를 입력받아서 사원급여를 10% 인상하는 함수
-- 오라클 함수(function)는 기본적으로 update/insert/delete를
-- 수행할 수 없다. 하지만 수행하려면 begin문 바로 위에 
-- 'pragma automous_transaction'을 선언
create or replace function fn_01(p_empno in number) return number
is
	v_sal   number;
	
pragma autonomous_transaction;
begin

	select sal 
		into v_sal
	  from emp
	 where empno = p_empno;
	
	dbms_output.put_line('인상전 급여 = ' || v_sal);	
	
			
	update emp
	   set sal = sal * 1.1
	 where empno = p_empno;
	 
	 commit;
	 -- rollback;
	 
	 select sal 
		 into v_sal
	   from emp
	  where empno = p_empno;	
			
	dbms_output.put_line('인상후 급여 = ' || v_sal);

	return v_sal;
end fn_01;

-- 인상전급여 = 880, 인상후 급여 = 968		
select fn_01(7369) from dual;

select empno, ename, sal, fn_01(empno) 
  from emp
 where empno = 7369;


-- 실습2. 부피를 계산하는 함수(fn_02)
-- 매개변수, length, width, height
-- result = length * width * height
create or replace function fn_02
 (length in number, width  in number, height in number) 
	return number
is
  result number;
begin

	result := length * width * height;
	return result;

end fn_02;

select fn_02(10,20,20) 부피 from dual; -- 4000
select 10*20*20 from dual;        -- 4000

-- 실습3. 현재일을 입력받아서 해당월의 마지막일자를 구하기
create or replace function fn_03
	(p_date in date)
	return date
is
	v_lastdate   date;
begin
	v_lastdate := (add_months(p_date, 1) - to_char(p_date, 'DD'));
	return v_lastdate;
end fn_03;

select (add_months(sysdate, 1) - to_char(sysdate, 'DD')) from dual;
select fn_03(sysdate) from dual;
select fn_03('20240201') from dual;


-- 실습4. '홍길동'문자를 받아서 '길동'값을 리턴하는 함수
create or replace function fn_04
  (p_name  in varchar2)
  return varchar2
is
	result varchar2(10);
begin
	-- result := substr(p_name, 2);
	return substr(p_name, 2);
end fn_04;

select fn_04('홍길동') from dual;
select fn_04('남궁성') from dual;

-- 실습5. 현재일을 입력받아서 '2024년 09월 06일'형태로 리턴하는 함수
create or replace function fn_05(p_date in date) return varchar2
is
begin
	return to_char(p_date, 'YYYY"년" MM"월" DD"일"');
end fn_05;
select fn_05(sysdate) from dual;
select empno, ename, hiredate, fn_05(hiredate) from emp;


-- 실습6. 주민번호를 전달받아서 남자 or 여자를 리턴하는 함수
-- 9911181234567 
create or replace function fn_06(p_ssn in varchar2) return varchar2
is
	v_gender varchar2(10);
begin
	
	v_gender := substr(p_ssn, 7, 1);
	if v_gender in ('1', '3')
		then v_gender := '남자';
		else v_gender := '여자';
	end if;
	
	return v_gender;
end fn_06;
select name, tel, fn_06(jumin) from student;

-- 실습7. emp에서 전사원의 hiredate를 현재일 기준으로 근속년월을 계산하는 함수를
-- 작성한 후에 전사원의 근속년월을 출력
create or replace function fn_07(p_hiredate in date) return varchar2
is
	v_workdays  varchar2(20);
begin
	v_workdays := floor(months_between(sysdate, p_hiredate)/12) || '년 ' ||
									floor(mod(months_between(sysdate, p_hiredate), 12)) ||'개월';
	return v_workdays;			
end fn_07;

select * from hr.employees; 
select first_name || '.' || last_name
     , fn_07(hire_date)
  from hr.employees;

select ename
     , fn_07(hiredate)
  from emp;


/* 실습문제 */
-- ex01) 부서의 총 급여를 반환하는 함수
-- get_dept_total_salary

-- ex02) 직원 번호가 주어졌을 때 직원의 관리자 이름을 반환하는 함수
-- get_manager_name

-- ex03) 급여와 커미션을 기준으로 직원의 커미션 비율을 계산하는 함수
-- get_commission_pct

-- ex04) 부서의 직원 수를 반환하는 함수
-- count_employees_in_dept

-- ex05) 부서에서 가장 높은 급여를 받는 직원의 이름을 반환하는 함수
-- get_highest_paid_emp

-- ex06) 직원이 관리자인지 확인하는 함수
-- is_manager

-- ex07) 특정 관리자에게 보고하는 직원의 평균 급여를 구하는 함수
-- get_avg_salary_by_mgr

-- ex08) 직원의 근속 기간을 계산하는 함수
-- get_years_of_service

-- ex09) 직원이 속한 부서의 이름을 반환하는 함수
-- get_dept_name_by_emp

-- ex10) 직원과 관리자 간의 급여 차이를 계산하는 함수
-- get_salary_difference_with_mgr








