package mylab.customer.service;

import java.util.List;
import mylab.customer.vo.CustomerVO;

public interface CustomerService {
    CustomerVO getCustomerInfo(int id);
    List<CustomerVO> getAllCustomerList();
    void insertCustomer(CustomerVO customer);
}