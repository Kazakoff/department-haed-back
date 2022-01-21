package com.vstu.department.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "faculties")
@AttributeOverride(name = "id", column = @Column(name = "f_id"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Faculty extends PersistentEntity {

    @NotNull
    @Column(name = "f_name")
    String name;

    @NotNull
    @Column(name = "f_display_name")
    String displayName;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Department> departments;
}
