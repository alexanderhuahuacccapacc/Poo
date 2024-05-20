package pe.edu.upeu.syscenterlife.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @Basic(optional = false)
    @Column(name = "dniruc")
    private String dniruc;
    @Basic(optional = false)
    @Column(name = "nombrers")
    private String nombrers;
    @Column(name = "documento")
    private String documento;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dniruc", referencedColumnName = "dniruc")
    @JsonIgnoreProperties({"dniruc"})
    public List<Venta> ventas;

}
