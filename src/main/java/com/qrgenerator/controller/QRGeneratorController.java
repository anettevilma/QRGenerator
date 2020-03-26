
package com.qrgenerator.controller;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrgenerator.bo.QRGeneratorBO;
import com.qrgenerator.dto.InputDTO;
@CrossOrigin
//(origins = "https://localhost:3000", maxAge = 3600,allowedHeaders = "*")
@RestController

public class QRGeneratorController<ProductDetailDTO> {

	@Autowired
	private QRGeneratorBO qrGeneratorBO;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/qrcode", headers = {
			"content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String qrcode(@RequestBody InputDTO inputDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setContentType("application/json");
		JSONObject respjson = new JSONObject();
		byte[] qrresponse = null;
		String resp = null;
		System.out.println("before receiving response");
		qrresponse = qrGeneratorBO.getQRCodeImage(inputDTO);
		String encodstring = encodeFileToBase64Binary(qrresponse);
		System.out.println("Base64 string from fnc.:::"+encodstring);
		encodstring="data:image/png;base64,"+encodstring;
		System.out.println("Base64 string from fnc. after appending:::"+encodstring);
		respjson.put("response", encodstring);
		resp = respjson.toString();
		resp=resp.replaceAll("\\\\", "");
		System.out.println("json response:"+respjson);
		return resp;

	}
	private static String encodeFileToBase64Binary(byte[] qrresponse){
        String encodedfile = null;
        try {
            
            encodedfile =Base64.getEncoder().encodeToString(qrresponse);
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return encodedfile;
    }

}
