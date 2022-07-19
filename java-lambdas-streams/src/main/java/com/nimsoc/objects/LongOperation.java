package com.nimsoc.objects;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class LongOperation {

  private AtomicInteger operationId = new AtomicInteger();
  private int id = 0;
  private String name = null;
  private String status = null;
  private int quantity = 0;

  public LongOperation(String name, int quantity, String status) {
    setId(operationId.getAndIncrement());
    setQuantity(quantity);
    setStatus(status);
    setName(name);
  }

  public LongOperation(int id, String instrument, int quantity, String status) {
    setId(id);
    setQuantity(quantity);
    setStatus(status);
    setName(instrument);
  }

  public LongOperation() {
    operationId.getAndIncrement();
  }

  public LongOperation(LongOperation t) {

  }

  public int getOperationId() {
    return operationId.intValue();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setOperationId(AtomicInteger tradeId) {
    this.operationId = tradeId;
  }

  @Override
  public String toString() {
    return "LongOperation{" + "operationId=" + operationId + ", id=" + id + ", name=" + name + ", status=" + status + ", quantity=" + quantity + '}';
  }

  public void setPrice(double price) {

  }

  public boolean isWorking() {
    return true;
  }

  public boolean isLongOperation() {
    return getQuantity() > 1000000;
  }

  public boolean isCancelledOperation() {
    return "CANCEL".equals(getStatus());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.operationId);
    hash = 53 * hash + this.id;
    hash = 53 * hash + Objects.hashCode(this.name);
    hash = 53 * hash + Objects.hashCode(this.status);
    hash = 53 * hash + this.quantity;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LongOperation other = (LongOperation) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.quantity != other.quantity) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.status, other.status)) {
      return false;
    }
    if (!Objects.equals(this.operationId, other.operationId)) {
      return false;
    }
    return true;
  }
  
  
}
