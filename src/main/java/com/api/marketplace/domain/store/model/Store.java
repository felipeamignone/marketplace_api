package com.api.marketplace.domain.store.model;

import java.util.UUID;

public class Store {
    private final Integer id;
    private String name;
    private final String cnpj;

    public Store(Integer id, String cnpj, String name) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setName(String name) {
        this.name = name;
    }
}
