# Write your MySQL query statement below

SELECT c.name Customers from customers c where c.id not in (select customerId id from orders)