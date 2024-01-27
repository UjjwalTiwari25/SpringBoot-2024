package com.productapp.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "product_table")
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;


	     @NotNull(message = "{product.name.absent}")
		private String name;

		@NotNull(message = "{product.price.absent}")
		@Range(min = 100, max = 100000, message = "{product.price.invalid}")
		private BigDecimal price;


}
		