package pe.edu.upeu.syscenterlife.modelo;

import lombok.Data;
// gracias a data o lombok ya no se usa el geter y seter

@Data
public class Cliente {
    String dniruc;
    String nombres;
    String documento;

}
