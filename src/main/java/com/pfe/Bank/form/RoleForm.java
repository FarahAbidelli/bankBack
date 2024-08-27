package com.pfe.Bank.form;

import com.pfe.Bank.model.ERole;
import com.pfe.Bank.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RoleForm {
    private long id;
    private String cdRole;
    private ERole lbRole;
    public RoleForm() {
    }
    public RoleForm (Role role){
        this.id= role.getId();
        this.cdRole=role.getCodrole();
        this.lbRole=role.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCdRole() {
        return cdRole;
    }

    public void setCdRole(String cdRole) {
        this.cdRole = cdRole;
    }

    public ERole getLbRole() {
        return lbRole;
    }

    public void setLbRole(ERole lbRole) {
        this.lbRole = lbRole;
    }
}
