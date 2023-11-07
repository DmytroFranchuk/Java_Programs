package de.telran.bankapp.repository.bank;

import de.telran.bankapp.entity.bank.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

//    @Query(value = "select c from Client c join Account a on c.id = a.client.id where " +
//            "a.agreement.product.status = :status and " +
//            "a.agreement.product.type = :productType and " +
//            "a.agreement.product.currencyCode = :currencyCode")
//    List<Client> findClients(
//            @Param("status") Status status,
//            @Param("productType") ProductType productType,
//            @Param("currencyCode") CurrencyCode currencyCode)
//    ;
}
