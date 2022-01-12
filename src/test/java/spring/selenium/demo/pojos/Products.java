package spring.selenium.demo.pojos;

public class Products {
   public String name;
   public String quantity;
   public String price;
   public String total;

    public Products(String name, String quantity, String price, String total) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
