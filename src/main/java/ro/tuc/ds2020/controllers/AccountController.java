package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.AccountTypeDTO;
import ro.tuc.ds2020.dtos.CredentialsDTO;
import ro.tuc.ds2020.entities.Account;
import ro.tuc.ds2020.services.AccountService;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<AccountTypeDTO> checkUser(@Valid @RequestBody CredentialsDTO credentialsDTO) {
        Account account = accountService.find(credentialsDTO.getUsername());

        if (account != null && credentialsDTO.getPassword().equals(account.getPassword())) {
            return new ResponseEntity<>(new AccountTypeDTO(account.getPersonId()), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}