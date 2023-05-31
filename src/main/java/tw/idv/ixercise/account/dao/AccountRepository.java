package tw.idv.ixercise.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.ixercise.account.entity.Account;



public interface AccountRepository extends JpaRepository<Account,Integer>{

//    可以在這裡寫"特定命名規則方法" JPA講義P80
//    也可以在這裡寫"自訂Query方法" JPA P80
    Account findByAccountId(Integer accountId);
    Account findByAccountPhone(String accountPhone);

    @Query(
            value = "select * from ACCOUNT where accountPhone = :accountPhone AND accountPassword = :accountPassword",
            nativeQuery = true
    )
    Account findForLogin(String accountPhone, String accountPassword);

}