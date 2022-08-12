# Write your MySQL query statement below


select e.name Employee from employee e where e.salary > (select salary from employee where id = e.managerId) 