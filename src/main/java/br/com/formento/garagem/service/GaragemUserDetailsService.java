/**
 * http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/
 */
package br.com.formento.garagem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.garagem.dao.UsuarioDao;
import br.com.formento.garagem.model.UsuarioPermissao;

@Service("userDetailsService")
public class GaragemUserDetailsService implements UserDetailsService {

	// get user from the database, via Hibernate
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		br.com.formento.garagem.model.Usuario user = usuarioDao.getByLogin(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUsuarioPermissaos());

		return buildUserForAuthentication(user, authorities);

	}

	// Converts br.com.formento.garagem.model.Usuario user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(br.com.formento.garagem.model.Usuario user, List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getSenha(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UsuarioPermissao> usuarioPermissaos) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UsuarioPermissao usuarioPermissao : usuarioPermissaos)
			setAuths.add(new SimpleGrantedAuthority(usuarioPermissao.getPermissao().getIdentificador()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
