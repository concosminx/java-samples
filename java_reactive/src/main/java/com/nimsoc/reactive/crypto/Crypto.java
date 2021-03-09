package com.nimsoc.reactive.crypto;

import com.google.common.base.Objects;

public class Crypto {

  private final String name;
  private final Float price;

  public Crypto(String name, Float price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Float getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Crypto{"
            + "name='" + name + '\''
            + ", price=" + price
            + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Crypto crypto = (Crypto) o;
    return Objects.equal(name, crypto.name)
            && Objects.equal(price, crypto.price);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name, price);
  }
}
