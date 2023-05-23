package com.benchmark.licensing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benchmark.licensing.entity.UserForm;

public interface LicensingRepository extends JpaRepository<UserForm, Integer>{

}
