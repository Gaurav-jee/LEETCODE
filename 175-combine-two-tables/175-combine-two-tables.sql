/* Write your T-SQL query statement below */

SELECT P.firstName,P.lastName,A.city,A.State
FROM Person P
LEFT OUTER JOIN Address A
ON
P.PersonId = A.PersonId;