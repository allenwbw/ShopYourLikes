package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.model.MerchantHost;
import com.ucla.shopyourlikes.repository.MerchantRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


// TODO: will add more testcase
public class testMerchantService {

    @Mock
    private MerchantRepository merchantRepository;

    @Mock
    private  ConnexityService connexityService;

    private MerchantService merchantService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        merchantService = new MerchantService();
        merchantService.connexityService = connexityService;
        merchantService.merchantRepository = merchantRepository;
    }

    @Test
    public void testMockCreation() {
        assertNotNull(connexityService);
        assertNotNull(merchantRepository);
    }

    @Test
    public void testGetMerchantById_randomId() {
        Merchant merchant =  merchantRepository.getByMerchantId(199);
        assertNull(merchant);
    }

    @Test
    public void testGetMerchantById_goodcase() {
        //set up
        Merchant fake =  new Merchant();
        MerchantHost merchantHost = new MerchantHost();
        merchantHost.setMerchantDomain("www");
        merchantHost.setMerchantTld("cs130");
        fake.setMerchantId(222);
        fake.setMerchantName("ucla");
        fake.setMerchantHost(merchantHost);

        // return the desired object
        when(merchantService.getMerchantById(anyInt())).thenReturn(fake);
        Merchant merchant =  merchantService.getMerchantById(anyInt());

        // assert the expected and actual results
        Integer i =  new Integer(222);
        assertEquals(i,merchant.getMerchantId());
        assertEquals("ucla",merchant.getMerchantName());
        assertEquals(merchantHost.getMerchantDomain(),merchant.getMerchantHost().getMerchantDomain());
        assertEquals(merchantHost.getMerchantTld(),merchant.getMerchantHost().getMerchantTld());
    }

    @Test
    public void testGetMerchantById_nullInput() {
        Merchant merchant = merchantService.getMerchantById(null);
        assertEquals(null,merchant);
    }
}
