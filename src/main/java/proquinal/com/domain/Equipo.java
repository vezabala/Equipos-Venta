package proquinal.com.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Equipo.
 */
@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceEquipo")
    @SequenceGenerator(name="sequenceEquipo", sequenceName = "app_equipo_id_seq")
    private Long id;

    @NotNull
    @Size(max = 70)
    @Column(name = "activo_fijo", length = 70, nullable = false, unique = true)
    private String activoFijo;

    @NotNull
    @Size(max = 70)
    @Column(name = "marca", length = 70, nullable = false)
    private String marca;

    @NotNull
    @Size(max = 200)
    @Column(name = "procesador", length = 200, nullable = false)
    private String procesador;

    @NotNull
    @Size(max = 70)
    @Column(name = "office", length = 70, nullable = false)
    private String office;

    @NotNull
    @Size(max = 70)
    @Column(name = "sistema_operativo", length = 70, nullable = false)
    private String sistemaOperativo;

    @NotNull
    @Size(max = 70)
    @Column(name = "disco_duro", length = 70, nullable = false)
    private String discoDuro;

    @NotNull
    @Size(max = 70)
    @Column(name = "ram", length = 70, nullable = false)
    private String ram;

    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "imagen_content_type")
    private String imagenContentType;

    @OneToMany(mappedBy = "equipo")
    private Set<Usuario> usuarios = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivoFijo() {
        return activoFijo;
    }

    public Equipo activoFijo(String activoFijo) {
        this.activoFijo = activoFijo;
        return this;
    }

    public void setActivoFijo(String activoFijo) {
        this.activoFijo = activoFijo;
    }

    public String getMarca() {
        return marca;
    }

    public Equipo marca(String marca) {
        this.marca = marca;
        return this;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public Equipo procesador(String procesador) {
        this.procesador = procesador;
        return this;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getOffice() {
        return office;
    }

    public Equipo office(String office) {
        this.office = office;
        return this;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public Equipo sistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
        return this;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public Equipo discoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
        return this;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getRam() {
        return ram;
    }

    public Equipo ram(String ram) {
        this.ram = ram;
        return this;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Equipo observaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public Equipo imagen(byte[] imagen) {
        this.imagen = imagen;
        return this;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getImagenContentType() {
        return imagenContentType;
    }

    public Equipo imagenContentType(String imagenContentType) {
        this.imagenContentType = imagenContentType;
        return this;
    }

    public void setImagenContentType(String imagenContentType) {
        this.imagenContentType = imagenContentType;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public Equipo usuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
        return this;
    }

    public Equipo addUsuarios(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.setEquipo(this);
        return this;
    }

    public Equipo removeUsuarios(Usuario usuario) {
        this.usuarios.remove(usuario);
        usuario.setEquipo(null);
        return this;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Equipo)) {
            return false;
        }
        return id != null && id.equals(((Equipo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Equipo{" +
            "id=" + getId() +
            ", activoFijo='" + getActivoFijo() + "'" +
            ", marca='" + getMarca() + "'" +
            ", procesador='" + getProcesador() + "'" +
            ", office='" + getOffice() + "'" +
            ", sistemaOperativo='" + getSistemaOperativo() + "'" +
            ", discoDuro='" + getDiscoDuro() + "'" +
            ", ram='" + getRam() + "'" +
            ", observaciones='" + getObservaciones() + "'" +
            ", imagen='" + getImagen() + "'" +
            ", imagenContentType='" + getImagenContentType() + "'" +
            "}";
    }
}
