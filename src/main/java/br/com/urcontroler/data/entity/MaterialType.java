package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Matérias primas
 *
 * @author kaciano
 */
public class MaterialType extends Type {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de PrimeMaterial
     */
    public MaterialType() {
    }

    /**
     * Cria nova instancia de PrimeMaterial
     *
     * @param id {@code Long} Código do material
     * @param name {@code String} Nome do material
     */
    public MaterialType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retorna o Código do material
     *
     * @return {@code Long} Código do material
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do material
     *
     * @param id {@code Long} Código do material
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do material
     *
     * @return {@code String} Nome do material
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do material
     *
     * @param name {@code String} Nome do material
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MaterialType other = (MaterialType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
