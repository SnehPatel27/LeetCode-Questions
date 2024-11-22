# Write your MySQL query statement below
select a.id 
from weather as a
inner join weather as b 
on a.recordDate = DATE_ADD(b.recordDate, INTERVAL 1 DAY)
where a.temperature > b.temperature