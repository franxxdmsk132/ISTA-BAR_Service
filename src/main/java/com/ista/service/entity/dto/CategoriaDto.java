package com.ista.service.entity.dto;

import com.ista.service.entity.Categoria;

public class CategoriaDto {
    private Iterable<Categoria> categorias;
    private Categoria categoria;
    private int id;
    private String nombre;
    private boolean vigencia;
    private DocumentoAlmacenadoDto foto;

    public CategoriaDto(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public DocumentoAlmacenadoDto getFoto() {
        return foto;
    }

    public void setFoto(DocumentoAlmacenadoDto foto) {
        this.foto = foto;
    }
}
