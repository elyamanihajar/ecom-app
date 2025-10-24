package ma.emsi.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @Data @Builder @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
