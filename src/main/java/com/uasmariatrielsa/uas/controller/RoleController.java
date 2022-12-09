/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uasmariatrielsa.uas.controller;
import com.uasmariatrielsa.uas.model.Role;
import com.uasmariatrielsa.uas.repository.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
    
    private RoleService roleService;
    
    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Long id) {
      return roleService.getById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
       return roleService.update(id, role);
    }

    @DeleteMapping("/{id}")
    public Role delete(@PathVariable Long id) {
      return roleService.delete(id);
    }
    
}

