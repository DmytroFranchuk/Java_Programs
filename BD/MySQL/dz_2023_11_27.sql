-- Вывести клиентов не из Germany, имена которых начинаются на букву A
SELECT 
	*
FROM 
	Customers
WHERE 
	Country != 'Germany' AND CustomerName LIKE 'A%' ; -- 3
    
-- Вывести данные о заказах клиентов 1, 2, 5 
-- (проекция: номерзаказа, названиекомпании_перевозчика)
SELECT 
	Orders.OrderID, 
    Shippers.ShipperName
FROM 
	Orders
JOIN 
	Shippers
ON Orders.ShipperID = Shippers.ShipperID
WHERE CustomerID IN (1, 2, 5); -- 28

-- Вывести данные о заказах клиентов не из France 
-- (проекция: номерзаказа, имяклиента, фамилия_менеджера)
SELECT 
	Orders.OrderID, 
    Customers.CustomerName, 
    Employees.FirstName AS  FirstNameManager 
FROM 
	Customers
JOIN 
	Orders
ON Customers.CustomerID = Orders.CustomerID
JOIN 
	Employees
ON Orders.EmployeeID = Employees.EmployeeID
WHERE Country != 'France' ; -- 754

-- Вывести ср/стоимость товаров от поставщика 4
SELECT 
	AVG(Price) AS AveragePrice
FROM 
	Products
WHERE SupplierID = 4; -- 46.00 у.е

-- Вывести один самый дешевый товар от поставщика 1
SELECT 
	* 
FROM 
	Products
WHERE 
	SupplierID = 1
ORDER BY Price 
LIMIT 1; -- 10 у.е

-- Вопрос: Зачем нужна проекция в БД. Дайте короткий ответ
-- Ответ: Проекция позволяет оптимизировать производительность, уменьшить объем передаваемых данных и 
-- обеспечить более эффективное использование ресурсов при выполнении запросов к базе данных.























    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    