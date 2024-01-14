
@Service
public class JpaCustomerService implements CustomerService {

    @Autowired
    private JpaCustomerRepository repository;

    @Autowired
    private JpaCartRepository cartRepository;

    @Autowired
    private JpaProductRepository productRepository;

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Customer getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void add(Customer customer) {
        JpaCustomer savedCustomer = repository.save(new JpaCustomer(0, customer.getName()));
        cartRepository.save(new JpaCart(savedCustomer));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

    @Override
    public int getCount() {
        return (int) repository.count();
    }

    @Override
    public double getTotalPriceById(int id) {
        return getById(id).getCart().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        Cart cart = getById(id).getCart();
        return cart.getTotalPrice() / cart.getProducts().size();
    }

    @Transactional
    @Override
    public void addToCartById(int customerId, int productId) {
        Customer customer = repository.findById(customerId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        Cart cart = customer.getCart();
        cart.addProduct(product);
    }

    @Transactional
    @Override
    public void deleteFromCart(int customerId, int productId) {
        ((JpaCart) getById(customerId).getCart()).removeProduct(productRepository.findById(productId).orElse(null));
    }

    @Transactional
    @Override
    public void clearCart(int customerId) {
        ((JpaCart) getById(customerId).getCart()).clear();
    }
}