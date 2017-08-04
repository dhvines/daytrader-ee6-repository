/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.ibm.websphere.samples.daytrader.rest.quotes;

import java.math.BigDecimal;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ibm.websphere.samples.daytrader.QuoteDataBean;
import com.ibm.websphere.samples.daytrader.TradeServices;
import com.ibm.websphere.samples.daytrader.direct.TradeDirect;

@Path(value = "/quotes")
public class Quotes {


    public Quotes() {}
   
    private static TradeDirect impl = new TradeDirect();
    
	/**
     * @see TradeServices#createQuote(String, String, BigDecimal)
     */
    @POST
    @Path("/{symbol}/{companyName}/{price}")
    @Produces({"application/json"})
    @Consumes({"application/json"})	
    public QuoteDataBean createQuote(@PathParam(value = "symbol") String symbol, 
    		@PathParam(value = "companyName") String companyName, @PathParam(value = "price") BigDecimal price) throws Exception {
		return impl.createQuote(symbol, companyName, price);
	}
    
	/**
     * @see TradeServices#getQuote(String)
     */
    @GET
    @Path("/{symbol}")
    @Produces({"application/json"})
    @Consumes({"application/json"})
	public QuoteDataBean getQuote(@PathParam(value = "symbol") String symbol) throws Exception {
		return impl.getQuote(symbol);
	}
    
	/**
     * @see TradeServices#getAllQuotes(String)
     */
    @GET
    @Produces({"application/json"})
	public Collection<QuoteDataBean> getAllQuotes() throws Exception {
		return impl.getAllQuotes();
	}
    
	/**
     * @see TradeServices#updateQuotePriceVolume(String, BigDecimal, double)
     */
    @PUT
    @Path("/{symbol}/{changeFactor}/{sharesTraded}")
    @Produces({"application/json"})
    @Consumes({"application/json"})
	public QuoteDataBean updateQuotePriceVolume(@PathParam(value = "symbol") String symbol, 
			@PathParam(value = "changeFactor") BigDecimal changeFactor, 
			@PathParam(value = "sharesTraded") double sharesTraded) throws Exception {
		return impl.updateQuotePriceVolume(symbol, changeFactor, sharesTraded);
	}
	
}
