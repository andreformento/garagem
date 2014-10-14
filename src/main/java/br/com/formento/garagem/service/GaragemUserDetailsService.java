/**
 * http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/
 */
package br.com.formento.garagem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.garagem.dao.UsuarioDao;
import br.com.formento.garagem.model.Usuario;
import br.com.formento.garagem.model.UsuarioPermissao;

@Service("userDetailsService")
//@ComponentScan//(basePackages = "br.com.formento.garagem.dao")
// @Service
public class GaragemUserDetailsService implements UserDetailsService {
	

	// get user from the database, via Hibernate
//	@Autowired
	// @Qualifier("jpaUsuarioDao")
//	UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		// Usuario usuario = usuarioDao.getByLogin(username);

		Usuario usuario = new Usuario();
		usuario.setEmail(username);
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setSenha(encoder.encode(username).toString());
		List<UsuarioPermissao> usuarioPermissaos = new ArrayList<UsuarioPermissao>();
		usuario.setUsuarioPermissaos(usuarioPermissaos);

		List<GrantedAuthority> authorities = buildUserAuthority(usuario.getUsuarioPermissaos());

		return buildUserForAuthentication(usuario, authorities);

	}

	// Converts Usuario user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Usuario usuario, List<GrantedAuthority> authorities) {
		User user = new User(usuario.getEmail(), usuario.getSenha(), true, true, true, true, authorities);
		return user;
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
