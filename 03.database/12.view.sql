/* View

   1. View란?
	 
	    a. View란 하나의 가상 Table이다.
			b. View는 실제로 데이터가 저장되지 않고 View통해서만 데이터를 조횔 할 수 있다.
			c. View는 복잡한 query를 통해 조회할 수 있는 결과를 사전에 정의한 View를 통해
			   간단히 조회 할 수 있게 한다.
		  d. 한개의 view로 여러개 Table의 데이터를 검색할 수 있게 한다.
			e. 특정 기준에 따라 사용자별로 다른 조회결과를 얻을 수 있게 한다.
	 
	 2. View제한조건
	 
	    a. 테이블에 not null로 만든 컬럼들이 view에 포함이 되어야 한다.
			b. view를 통해서도 데이터를 insert할 수 있다. 단, rowid, rownum, nextval,
			   curval등과 같은 가상의 컬럼에 대해 참조하고 있을 경우에 가능하다.
			c. with read only옵션으로 설정된 view는 어떠한 데이터도 갱신을 없다.
			d. with check option을 설정한 view는 view의 조건에 해당하는 데이터만 삽입
			   삭제, 수정을 할 수 있다.
			
	 3. View문법
	 
	    create [or replace] [force|noforce] view 뷰이름
			as subquery
			with read only
			with check option
	 
	    -- or replace : 같은 이름의 view가 있을 경우 삭제후 다시 생성
			-- force : 테이블의 존재유무와 상관없이 view를 생성
			-- noforce : 테이블이 존재할 경우에만 view를 생성
			-- with read only : select만 가능한 읽기 전용 view
			-- with check option : 주어진 제약조건에 맞는 데이터만 입력 및 수정, 삭제 가능
	 
	 4. View조회방법
	 
	    select * from dba_views;
			select * from all_views;
			select * from user_views;
	 
	 5. 사용자에게 veiw를 생성할 수 있는 권한 주기
	    1) 사용자권한조회 
			   ... select * from user_role_privs;
				 
			2) 권한부여 (sysdba권한으로 부여가능)
			   
				 ... grant create view to 사용자계정(스키마);

*/

-- 1. data dictionary : 
-- 1) view 목록조회
select * from user_views;

-- 2) 권한조회
select * from user_role_privs;

-- 2. 권한부여(sysdba권한으로 실행)
grant create view to scott;
select * from user_role_privs;

-- 3. 단순 view 생성하기
create or replace view v_emp
as
select empno, ename, job from emp;
select * from v_emp;

create or replace view v_sal
as
select empno, ename, job, sal, nvl(comm, 0) comm from emp;
select * from v_sal;

-- 4. 복합뷰생성하기
-- 실습) emp, dept를 join해서 ename, dname만 조회가능한 v_dname뷰 생성하기
create or replace view v_dname
as
select ename, dname
  from emp, dept
 where emp.deptno = dept.deptno;
 
select * from v_dname;

-- 5. view 삭제
drop view v_dname;

-- 6. inline view
-- a. 통상적인 view
select ename
     , dpt.dname
  from emp
	   , (select deptno, dname from dept) dpt
where emp.deptno = dpt.deptno;

-- b. inline view
select ename
     , (select dname from dept dpt where dpt.deptno = emp.deptno ) dname
  from emp;

-- 실습) emp와 dept를 조회 부서번호와 부서별최대급여 및 부서명을 출력
-- view생성 또는 inlineview를 하던 상관없음
-- deptno dname sal_max
create or replace view v_max_sal
as
select emp.deptno, dname, max(sal) sal_max
  from emp emp, dept dpt
 where emp.deptno = dpt.deptno
 group by emp.deptno, dname;

select * from v_max_sal;

/* Materialized View(MView, 구체화된 View)

	 1. view는 inline view와 create view로 생성되는 view가 있는데 실제 데이터는
	    원본데이터에 존재하고 생성된 view는 질의문만 저장해둔 객체를 의미한다.
		
   2. MView라는 구체화된 View는 view의 질의결과로 만들어진 자료를 실제 데이터를
	    저장하고 있어 테이블처럼 사용할 수 있다. 원본데이터에 insert, delete, update
		  등이 발생되면 새로운 데이터를 MView에 반영되도록 한다.
	 3. MView 집계데이터를 추출할 때 질의속도를 빠르게 해 주기 때문에 그룹함수등의
	    질의 결과를 저장하는데 사용할 수 있다.
		
   4. 문법
	
      create materialized view 뷰이름
		  build [immediate|defferred] [refresh] [fast] [complete] [force] [never]
			
			-- build immediate : MView생성과 동시에 데이터를 생성
			-- build defferred : MView생성후에 데이터는 나중에 생성(조회결과는 없음)
			-- build immediate refresh : MView가 생성되자 마자 바로 실행가능한 형태로 된다.
			   ... refresh절에는 옵션이 있다.
				     --> on commit : 원본 테이블에 commit가 발생될 때 refresh가 발생
						 --> on demmand: 별도로 refresh명령을 실행할 때 refresh가 된다.
						 
	  5. 사용자에게 MVeiw를 생성할 수 있는 권한 주기
		
		   grant query rewrite to 사용자
			 grant create materialized view to 사용자계정
*/

-- 1. MView 권한 주기
grant query rewrite to scott;
grant create materialized view to scott;

select * from user_views;
select * from user_role_privs; 

-- sysdba권한
select * from dba_sys_privs where grantee = 'SCOTT';

-- 2. MView생성
create materialized view mv_prof
build immediate
refresh on demand
complete
as
select profno, name, pay
  from professor;

select * from mv_prof;

/* 연습문제 */
-- ex01) professor, department을 join 교수번호, 교수이름, 소속학과이름 조회 View
-- ex02) inline view를 사용, student, department를 사용 학과별로 
-- 학생들의 최대키, 최대몸무게, 학과명을 출력
-- ex03) inline view를 사용, 학과명, 학과별최대키, 학과별로 가장 키가 큰 학생들으;
-- 이름과 키를 출력
-- ex04) student에서 학생키가 동일학년의 평균키보다 큰 학생들의 학년과 이름과 키
-- 해당 학년의 평균키를 출력 단, inline view로
-- ex05) professor에서 교수들의 급여순위와 이름, 급여출력 단, 급여순위 1~5위까지
-- ex06) 교수번호정렬후 3건씩해서 급여합계와 급여평균을 출력