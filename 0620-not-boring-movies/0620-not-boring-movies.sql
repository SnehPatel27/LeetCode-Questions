# Write your MySQL query statement below
select * 
from cinema 
where 
    MOD(id, 2) = 1
    AND
    description <> "boring"
order by rating DESC