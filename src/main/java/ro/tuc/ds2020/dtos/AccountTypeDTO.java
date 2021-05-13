package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

public class AccountTypeDTO extends RepresentationModel<AccountTypeDTO> {
    private UUID uuid;


    public AccountTypeDTO(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
