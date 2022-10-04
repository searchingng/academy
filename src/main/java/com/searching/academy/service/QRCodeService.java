package com.searching.academy.service;

public interface QRCodeService {

    byte[] getQRCodeImage(String text);

    String generateQRCode(String code);
}
