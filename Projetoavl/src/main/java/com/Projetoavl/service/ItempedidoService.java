package com.Projetoavl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetoavl.entities.Itempedido;
import com.Projetoavl.repository.ItempedidoRepository;

@Service
public class ItempedidoService {

	@Autowired
	private final ItempedidoRepository itempedidoRepository;
	
	@Autowired
    public ItempedidoService(ItempedidoRepository itempedidoRepository) {
        this.itempedidoRepository = itempedidoRepository;
    }

	
	
	 public List<Itempedido> getAllItempedido() {
	        return itempedidoRepository.findAll();
	    }

	    public Itempedido getItempedidoById(Long id) {
	        Optional<Itempedido> Itempedido = itempedidoRepository.findById(id);
	        return Itempedido.orElse(null);
	    }

	    public Itempedido salvarItempedido(Itempedido itempedido) {
	        return itempedidoRepository.save(itempedido);
	    }

	    public Itempedido updateItempedido(Long id, Itempedido updatedItempedido) {
	        Optional<Itempedido> existingItempedido = itempedidoRepository.findById(id);
	        if (existingItempedido.isPresent()) {
	            updatedItempedido.setId(id);
	            return itempedidoRepository.save(updatedItempedido);
	        }
	        return null;
	    }

	    public boolean deleteItempedido(Long id) {
	        Optional<Itempedido> existingItempedido = itempedidoRepository.findById(id);
	        if (existingItempedido.isPresent()) {
	        	itempedidoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
