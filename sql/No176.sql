-- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary）
WITH salarys(id, salary)
AS (SELECT row_number() over (ORDER BY salary DESC) AS id, Salary AS salary FROM employee GROUP BY Salary)

SELECT
case COUNT(1)
	when 0 THEN NULL
	ELSE max(t.salary) END AS SecondHighestSalary
FROM (
	SELECT s.salary FROM salarys s WHERE s.id = 2
)  t