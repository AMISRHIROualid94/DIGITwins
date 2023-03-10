package com.sf.digitwins.services.webClient;

import com.sf.digitwins.dto.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient.Builder webClientBuilder;


    public Employer getEmployer(Long matricule){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employer employer = webClientBuilder.build().get()
                .uri("http://localhost:8080/api/employers/{matricule}",matricule)
                .headers(header -> header.setBearerAuth(jwt.getTokenValue()))
                .retrieve()
                .bodyToMono(Employer.class)
                .block();
        return employer;
    }

    public Boolean isChAffected(Long matricule){
        Employer employer = getEmployer(matricule);
        if (!employer.isAffected()){
            return false;
        }else
        {
            return true;
            //throw new IllegalArgumentException("Chauffeur est déjà affecter!!");
        }

    }


    public void editChauffeurId(Long matricule,Employer employer){
       Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        webClientBuilder.build().put()
                .uri("http://localhost:8080/api/employers/{matricule}",matricule)
                .body(Mono.just(employer),Employer.class)
                .headers(header -> header.setBearerAuth(jwt.getTokenValue()))
                .retrieve()
                .bodyToMono(Employer.class)
                .block();
    }
}
