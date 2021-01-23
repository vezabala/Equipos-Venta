package proquinal.com.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link proquinal.com.domain.Equipo} entity.
 */
public class EquipoDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(max = 70)
    private String activoFijo;

    @NotNull
    @Size(max = 70)
    private String marca;

    @NotNull
    @Size(max = 200)
    private String procesador;

    @NotNull
    @Size(max = 70)
    private String office;

    @NotNull
    @Size(max = 70)
    private String sistemaOperativo;

    @NotNull
    @Size(max = 70)
    private String discoDuro;

    @NotNull
    @Size(max = 70)
    private String ram;

    @Size(max = 200)
    private String observaciones;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivoFijo() {
        return activoFijo;
    }

    public void setActivoFijo(String activoFijo) {
        this.activoFijo = activoFijo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EquipoDTO equipoDTO = (EquipoDTO) o;
        if (equipoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), equipoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EquipoDTO{" +
            "id=" + getId() +
            ", activoFijo='" + getActivoFijo() + "'" +
            ", marca='" + getMarca() + "'" +
            ", procesador='" + getProcesador() + "'" +
            ", office='" + getOffice() + "'" +
            ", sistemaOperativo='" + getSistemaOperativo() + "'" +
            ", discoDuro='" + getDiscoDuro() + "'" +
            ", ram='" + getRam() + "'" +
            ", observaciones='" + getObservaciones() + "'" +
            "}";
    }
}
