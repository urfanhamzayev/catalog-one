package com.catalog.one.billling.controller;

import java.util.HashMap;
import java.util.Map;

import com.catalog.one.billling.beans.BillType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingServiceController {
	
	
	private static final Map<Integer, BillType> billTypeData = new HashMap<Integer, BillType>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3970206781360313502L;

		{
			put(111,new BillType(111,"REGULAR"));
			put(222,new BillType(222,"VIP"));
		}
 
    };
 
    @RequestMapping(value = "/findBillDetails/{billId}", method = RequestMethod.GET)
    public BillType getBillDetails(@PathVariable int billId) {
        System.out.println("Getting Billing type details for " + billId);
 
        BillType bill = billTypeData.get(billId);
        if (bill == null) {
            
        	bill = new BillType(0, "N/A");
            
        }
        return bill;
    }

}
