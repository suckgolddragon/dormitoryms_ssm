package com.southwind.service;

import com.southwind.dto.AccountDto;
import com.southwind.form.AccountForm;

public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}
