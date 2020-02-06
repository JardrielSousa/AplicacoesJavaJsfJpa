package com.br.socialapi.socialapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.socialapi.socialapi.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
