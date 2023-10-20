package co.istad;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private static int id;
    private String name;
    private Integer qty;
    private Double price;
    private LocalDate importDate;

    public static int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public Integer getQty() {
        return qty;
    }

    public int setQty(Integer qty) {
        this.qty = qty;
        return  qty;
    }

    public Double getPrice() {
        return price;
    }

    public double setPrice(Double price) {
        this.price = price;
        return  price;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public  Product (){};
    public Product (int id, String name, double unitPrice, int qty, LocalDate date){
      this.id = id;
      this.name = name;
      this.price = unitPrice;
      this.qty = qty;
      this.importDate = date;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", importDate=" + importDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(qty, product.qty) && Objects.equals(price, product.price) && Objects.equals(importDate, product.importDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, qty, price, importDate);
    }
}
