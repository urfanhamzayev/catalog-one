package com.catalog.one.monitoring;


import com.catalog.one.monitoring.entity.MonitoringTransaction;
import com.catalog.one.monitoring.entity.MonitoringTransactionDetail;
import com.catalog.one.monitoring.service.MonitoringServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MonitoringServiceApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MonitoringServiceImpl monitoringService;

	public MonitoringServiceApplicationTests() {
	}

	@Before
	public void init() {
		MonitoringTransaction monitoringTransaction = new MonitoringTransaction(1L,"BILLING","UP");
		when(monitoringService.getMonitoringTransactionById(1L)).thenReturn(monitoringTransaction);
	}

	@Test
	public void find_monitoring_OK() throws Exception {

		mockMvc.perform(get("/monitoring/get/1"))
				/*.andDo(print())*/
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect( jsonPath("$.id", is(1)))
				.andExpect( jsonPath("$.name", is("BILLING")))
				.andExpect(jsonPath("$.status", is("UP")));


	}
	@Test
	public void find_monitoringAll_OK() throws Exception {
		MonitoringTransactionDetail monitoringTransaction = new MonitoringTransactionDetail(1L,null,null);
		List<MonitoringTransactionDetail> monitoringTransactionsList = new ArrayList<>();
		monitoringTransactionsList.add(monitoringTransaction);
		when(monitoringService.getAllMonitoringDetailsOfTransactionList()).thenReturn(monitoringTransactionsList);

		mockMvc.perform(get("/monitoring/getAll"))
				/*.andDo(print())*/
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				;


	}

}
