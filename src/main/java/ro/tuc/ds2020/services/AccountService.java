package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Account;
import ro.tuc.ds2020.repositories.AccountRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account find(String username) {
        Optional<Account> account = accountRepository.findById(username);
        if (account.isPresent()) {
            return account.get();
        }

        return null;
    }

    public Boolean insert(String username, String password, UUID personId, String type) {
        if (find(username) != null)
            return false;

        Account account = new Account(username, password, personId);

        account = accountRepository.save(account);

        return true;
    }

    public void delete(String username) {
        accountRepository.deleteById(username);
    }

    public void deleteByUUID(UUID id) {
        Account account = accountRepository.findAccountsByPersonId(id);
        if (account != null)
            accountRepository.delete(account);
    }

//    public Boolean update(UUID caregiverUuid, CaregiverDTO caregiverDTO) {
//        Optional<Caregiver> optionalCaregiver = accountRepository.findById(caregiverUuid);
//
//        optionalCaregiver.ifPresent(caregiver -> {
//            retractCaregiverFromPerson(caregiver);
//
//            caregiverDTO.updateCaregiver(caregiver);
//            accountRepository.save(caregiver);
//
//            assignCaregiverToPatients(caregiverDTO, caregiver);
//        });
//
//        return optionalCaregiver.isPresent();
//    }
}
