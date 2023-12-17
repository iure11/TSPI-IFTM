package br.com.imobiliaria.entities;

import br.com.imobiliaria.model.ModelImovel;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table(value = "tb_imovel")
public class EntitiesImovel implements Serializable {
    @Id
    @PrimaryKey
    private UUID id;

    @Column
    private String endereco;

    @Column
    private ModelImovel tipo_imovel;

    @Column
    private Float area;

    @Column
    private Float preco;

    public EntitiesImovel() {
        this.id = Uuids.timeBased();
    }

    public EntitiesImovel(String endereco, ModelImovel tipo_imovel, Float area, Float preco) {
        this.endereco = endereco;
        this.tipo_imovel = tipo_imovel;
        this.area = area;
        this.preco = preco;
    }

    public EntitiesImovel(UUID id, String endereco, ModelImovel tipo_imovel, Float area, Float preco) {
        this.id = id;
        this.endereco = endereco;
        this.tipo_imovel = tipo_imovel;
        this.area = area;
        this.preco = preco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ModelImovel getTipo_imovel() {
        return tipo_imovel;
    }

    public void setTipo_imovel(ModelImovel tipo_imovel) {
        this.tipo_imovel = tipo_imovel;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
