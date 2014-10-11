package br.com.formento.garagem.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Zoo {
	private WildAnimal wild;

	@Autowired
	public void setWild(WildAnimal wild) {
		this.wild = wild;
	}

	public void testSound() {
		System.out.println(wild.sound());
	}

}