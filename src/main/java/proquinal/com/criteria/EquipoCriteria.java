package proquinal.com.criteria;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.StringFilter;
import proquinal.com.domain.enumeration.Tipo;

public class EquipoCriteria {
    public static class TipoFilter extends Filter<Tipo>{}
    private StringFilter activoFijo;
    private TipoFilter tipo;

    public StringFilter getActivoFijo() {
        return activoFijo;
    }

    public void setActivoFijo(StringFilter activoFijo) {
        this.activoFijo = activoFijo;
    }

    public TipoFilter getTipo() {
        return tipo;
    }

    public void setTipo(TipoFilter tipo) {
        this.tipo = tipo;
    }
}
