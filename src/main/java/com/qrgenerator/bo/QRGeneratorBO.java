package com.qrgenerator.bo;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrgenerator.dto.InputDTO;

@Service
public class QRGeneratorBO {
	

	//private static final String filePath = "C://AZ-POC//QR_code//MyQRCode1.png";
	

	static byte[] response;
	static String productdetail="";
	static int width;
	static int height;
	static String productencoded;

	public static byte[] getQRCodeImage(InputDTO inputDTO)
			throws NoSuchAlgorithmException, IOException {
		productdetail=inputDTO.getData().toString();
		System.out.println("Before encoding::"+productdetail);
		productencoded= Base64.getEncoder().encodeToString(productdetail.getBytes());
		System.out.println("After encoding::"+productencoded);
		width=inputDTO.getWidth();
		height=inputDTO.getHeight();
				
		
	
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(productencoded, BarcodeFormat.QR_CODE, width, height);
			//Path path = FileSystems.getDefault().getPath(filePath);
	        //MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}


	}

	}
