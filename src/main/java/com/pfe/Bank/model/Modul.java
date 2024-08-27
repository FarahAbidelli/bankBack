package com.pfe.Bank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import javax.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="hab_module")
public class Modul {
    @Id
    @Column(name = "cod_module")
    private String codmodule;


    @Column(name = "lib_module")
    private String libmodule;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Menu> menus;

    public String getCodmodule() {
        return codmodule;
    }

    public void setCodmodule(String codmodule) {
        this.codmodule = codmodule;
    }

    public String getLibmodule() {
        return libmodule;
    }

    public void setLibmodule(String libmodule) {
        this.libmodule = libmodule;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
