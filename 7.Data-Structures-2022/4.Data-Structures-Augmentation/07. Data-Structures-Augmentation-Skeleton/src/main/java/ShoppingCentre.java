import java.util.*;

public class ShoppingCentre {
    private Map<String, List<Product>> productsByProducer;
    private Map<String, List<Product>> productsByNameAndProducer;
    private Map<String, List<Product>> productsByName;
    private TreeMap<Double, List<Product>> productsByPrice;

    public ShoppingCentre() {
        this.productsByProducer = new HashMap<>();
        this.productsByNameAndProducer = new HashMap<>();
        this.productsByName = new HashMap<>();
        this.productsByPrice = new TreeMap<>();
    }

    public String addProduct(String name, double price, String producer) {
        Product product = new Product(name, price, producer);
        String nameAndProducer = name + producer;

        productsByProducer.putIfAbsent(producer, new ArrayList<>());
        productsByProducer.get(producer).add(product);

        productsByNameAndProducer.putIfAbsent(nameAndProducer, new ArrayList<>());
        productsByNameAndProducer.get(nameAndProducer).add(product);

        productsByName.putIfAbsent(name, new ArrayList<>());
        productsByName.get(name).add(product);

        productsByPrice.putIfAbsent(price, new ArrayList<>());
        productsByPrice.get(price).add(product);

        return "Product added" + System.lineSeparator();
    }

    public String delete(String producer) {
        if (this.productsByProducer.get(producer) == null || this.productsByProducer.get(producer).isEmpty()) {
            return "No products found"+System.lineSeparator();
        } else {
            List<Product> productsToRemove = this.productsByProducer.get(producer);
            int removedProducts = productsToRemove.size();

            for (Product product : productsToRemove) {
                String nameAndProducer = product.getName() + product.getProducer();
                String productName = product.getName();
                double productPrice = product.getPrice();

                this.productsByNameAndProducer.get(nameAndProducer).remove(product);
                this.productsByName.get(productName).remove(product);
                this.productsByPrice.get(productPrice).remove(product);
            }
            this.productsByProducer.remove(producer);

            return String.format("%d products deleted\n", removedProducts);
        }
    }

    public String delete(String name, String producer) {
        String nameAndProducer = name + producer;

        if (this.productsByNameAndProducer.get(nameAndProducer) == null || this.productsByNameAndProducer.isEmpty()) {
            return "No products found"+System.lineSeparator();
        } else {
            List<Product> productsToRemove = this.productsByNameAndProducer.get(nameAndProducer);
            int removedProducts = productsToRemove.size();


            for (Product product : productsToRemove) {
                double productPrice = product.getPrice();

                this.productsByProducer.get(producer).remove(product);
                this.productsByName.get(name).remove(product);
                this.productsByPrice.get(productPrice).remove(product);
            }
            this.productsByNameAndProducer.remove(nameAndProducer);

            return String.format("%d products deleted\n", removedProducts);
        }
    }

    public String findProductsByName(String name) {
        StringBuilder result = new StringBuilder();
        if (this.productsByName.get(name) == null || this.productsByName.get(name).isEmpty()) {
            result.append("No products found")
                    .append(System.lineSeparator());
        } else {
            List<Product> products = this.productsByName.get(name);
            products.sort(Comparator.naturalOrder());

            for (Product product : products) {
                result.append(String.format("{%s;%s;%.2f}", product.getName(), product.getProducer(), product.getPrice()))
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    public String findProductsByProducer(String producer) {
        StringBuilder result = new StringBuilder();

        if (this.productsByProducer.get(producer) == null || this.productsByProducer.get(producer).isEmpty()) {
            result.append("No products found")
                    .append(System.lineSeparator());
            ;
        } else {
            List<Product> products = this.productsByProducer.get(producer);
            products.sort(Comparator.naturalOrder());

            for (Product product : products) {
                result.append(String.format("{%s;%s;%.2f}", product.getName(), product.getProducer(), product.getPrice()))
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    public String findProductsByPriceRange(double startPrice, double endPrice) {
        List<Product> result = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        this.productsByPrice.forEach((price, products) -> {
            if (price >= startPrice && price <= endPrice) {
                result.addAll(products);
            }
        });

        if (result.isEmpty()) {
            output.append("No products found")
                    .append(System.lineSeparator());
        } else {
            result.sort(Comparator.naturalOrder());
            for (Product product : result) {
                output.append(String.format("{%s;%s;%.2f}", product.getName(), product.getProducer(), product.getPrice()))
                        .append(System.lineSeparator());
            }
        }

        return output.toString();
    }
}
