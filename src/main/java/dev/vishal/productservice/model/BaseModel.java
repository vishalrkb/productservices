package dev.vishal.productservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
   @Id
   @GeneratedValue(generator = "uuidgenrator")
   @GenericGenerator(name = "uuidgenrator", strategy = "uuid2")
   @Column(columnDefinition = "binary(16)", nullable = false, updatable = false)
   private UUID id;
}
