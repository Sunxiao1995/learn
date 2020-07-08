JAvaWeb 开发入门

加驱动和时区 否则会报错

blob:https://www.aikanbt.com/85b7f2e5-58a9-41c1-a204-21e59b5dbbeb

'18', 'shangzezhong', '尚泽忠', '', '1', '140225198810013745', '1044888844@qq.com', '13366528458', '0'







4297f44b13955235245b2497399d7a93



登陆 cooki





select a.ename,b.dname,c.ename mgr_name,d.grade
from emp a,dept b,emp c,salgrade d
where a.deptno=b.deptno and
a.mgr=c.empno and
a.sal between d.losal and d.hisal
and a.sal>(select avg(sal) from emp)







select e.*,d.dname
from emp e,dept d
where e.deptno=d.deptno
and e.job=(select job from emp where ename='SCOTT')
and e.ename <> 'SCOTT';

