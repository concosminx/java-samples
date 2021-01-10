/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark_ws;

/**
 *
 * @author Cosminx
 */
public enum StatusResponse {
  SUCCESS("Success"), ERROR("Error");

  final private String status;

  StatusResponse(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
