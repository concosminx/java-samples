package com.nimsoc.reactive.transformer;

import com.nimsoc.reactive.crypto.Crypto;

import java.util.function.Function;

public class ConvertingToStringCryptoTransformProcessor extends CryptoTransformProcessor<String> {

  public static ConvertingToStringCryptoTransformProcessor create() {
    return new ConvertingToStringCryptoTransformProcessor(
            Crypto::getName);
  }

  private ConvertingToStringCryptoTransformProcessor(
          Function<Crypto, String> function) {
    super(function);
  }
}
