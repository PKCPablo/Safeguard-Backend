package com.safeguard.safeguardbackend.rest.dto;

import com.safeguard.safeguardbackend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveProductResponse implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 9178661439383356177L;

    private Integer id;

    private String nombre;

    private String precio;

    public RetrieveProductResponse(Product product) {

        this.id = product.getId();
        this.nombre = product.getNombre();
        this.precio = product.getPrecio();
    }

}
