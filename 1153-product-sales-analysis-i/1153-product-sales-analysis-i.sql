# Write your MySQL query statement below
SELECT product_name, year, price
FROM Product 
INNER JOIN Sales 
ON Sales.product_id = Product.product_id