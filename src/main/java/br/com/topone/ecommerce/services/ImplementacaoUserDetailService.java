package br.com.topone.ecommerce.services;

import br.com.topone.ecommerce.model.Usuario;
import br.com.topone.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementacaoUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepository.findUserByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException("Usuario não localizado");
        }


        return new User(user.getLogin(), user.getPassword(), user.getAuthorities());
    }
}
