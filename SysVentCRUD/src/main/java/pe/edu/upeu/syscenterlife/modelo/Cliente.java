package pe.edu.upeu.syscenterlife.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// gracias a data o lombok ya no se usa el geter y seter

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente {
    String dniruc;
    String nombres;
    String documento;

}
