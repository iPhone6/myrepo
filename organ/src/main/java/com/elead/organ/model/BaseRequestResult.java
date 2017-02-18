package com.elead.organ.model;

import com.elead.organ.model.RequestResult;


/**
 * @author  ex_wencz 
 * E-mail: chuanzhi.wen@partner.midea.com
 * @date 创建时间：2017年2月16日 上午11:59:48 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return
 */
public class BaseRequestResult extends RequestResult
{
	public RequestResult resultInfo(String code,String message,Object object)
    {
		RequestResult requestResult = new RequestResult();
		requestResult.setCode(code);
		requestResult.setMessage(message);
		requestResult.setObject(object);
		return requestResult;
    }
	
}
