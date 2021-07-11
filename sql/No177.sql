-- 第 n 高的薪水
--CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
--BEGIN
--  RETURN (
--      # Write your MySQL query statement below.
--  );
--END

-- 解答
DELIMITER $$
CREATE FUNCTION getNthHighestSalary(N INT)
RETURNS INT
BEGIN
  RETURN (
	    with nth(id, salary)
	    as (select row_number() over (order by salary desc) as id,
	    salary as salary from employee
	    where id = id group by salary)

		select
            case count(1)
            when 0 then null
            else max(t.salary)
            end
		FROM nth t where t.id = n
  );
END $$
DELIMITER ;