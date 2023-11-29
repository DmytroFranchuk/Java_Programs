public class MySqlCustomerRepository implements CustomerRepository {

    @Override
    public ListCustomer getAll() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM customer AS c LEFT JOIN customer_product AS cp ON c.id = cp.customer_id LEFT JOIN product AS p ON cp.product_id = p.id;";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            Map<String, Customer> map = new HashMap<>();

            while (resultSet.next()) {
                int customerId = resultSet.getInt("c.id");
                String customerName = resultSet.getString("c.name");
                int productId = resultSet.getInt("p.id");
                String productName = resultSet.getString("p.name");
                double productPrice = resultSet.getDouble("p.price");

                if (!map.containsKey(customerName)) {
                    Customer customer = new CommonCustomer(customerId, customerName, new CommonCart());
                    map.put(customerName, customer);
                }

                if (productId > 0) {
                    Product product = new CommonProduct(productId, productName, productPrice);
                    map.get(customerName).getCart().addProduct(product);
                }
            }
            return new ArrayList<>(map.values());
        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching customers from database", e);
        }
    }

    @Override
    public Customer getById(int id) {
       try (Connection connection = getConnection()) {
        String query = "SELECT c.id, c.name, p.id AS product_id, p.name AS product_name, p.price FROM customer AS c LEFT JOIN customer_product AS cp ON c.id = cp.customer_id LEFT JOIN product AS p ON cp.product_id = p.id WHERE c.id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        Customer customer = null;

        while (resultSet.next()) {
            if (customer == null) {
                int customerId = resultSet.getInt("c.id");
                String customerName = resultSet.getString("c.name");
                customer = new CommonCustomer(customerId, customerName, new CommonCart());
            }

            int productId = resultSet.getInt("product_id");
            String productName = resultSet.getString("product_name");
            double productPrice = resultSet.getDouble("price");

            if (productId > 0) {
                Product product = new CommonProduct(productId, productName, productPrice);
                customer.getCart().addProduct(product);
            }
        }

        return customer;
    } catch (SQLException e) {
        throw new RuntimeException("Error while fetching customer by ID from database", e);
    }
}

   @Override
    public void add(String name) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO customer (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while adding a new customer to the database", e);
        }
    }

    @Override
    public void delete(int id) {
     try (Connection connection = getConnection()) {
        String query = "DELETE FROM customer WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Error while deleting customer from the database", e);
    }
}

    @Override
    public void addToCartById(int customerId, int productId) {
     try (Connection connection = getConnection()) {
        String query = "INSERT INTO customer_product (customer_id, product_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, customerId);
        statement.setInt(2, productId);
        statement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Error while adding product to customer's cart", e);
    }
}

    @Override
    public void deleteFromCart(int customerId, int productId) {
  try (Connection connection = getConnection()) {
        String query = "DELETE FROM customer_product WHERE customer_id = ? AND product_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, customerId);
        statement.setInt(2, productId);
        statement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Error while deleting product from customer's cart", e);
    }
}

    @Override
    public void clearCart(int customerId) {
   try (Connection connection = getConnection()) {
        String query = "DELETE FROM customer_product WHERE customer_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, customerId);
        statement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Error while clearing customer's cart", e);
    }
}
}