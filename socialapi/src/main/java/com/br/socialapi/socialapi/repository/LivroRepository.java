package com.br.socialapi.socialapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.br.socialapi.socialapi.domain.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long>{

}
