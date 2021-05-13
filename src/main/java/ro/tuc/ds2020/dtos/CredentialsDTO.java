package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

public class CredentialsDTO extends RepresentationModel<CredentialsDTO> {
    private String username;
    private String password;

    public CredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CredentialsDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
