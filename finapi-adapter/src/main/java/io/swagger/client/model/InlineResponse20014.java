/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.20.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for list of identifiers of deleted users, and not deleted users (in ascending order)
 */
@ApiModel(description = "Container for list of identifiers of deleted users, and not deleted users (in ascending order)")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse20014 {
  @SerializedName("deletedUsers")
  private List<String> deletedUsers = new ArrayList<String>();

  @SerializedName("nonDeletedUsers")
  private List<String> nonDeletedUsers = new ArrayList<String>();

  public InlineResponse20014 deletedUsers(List<String> deletedUsers) {
    this.deletedUsers = deletedUsers;
    return this;
  }

  public InlineResponse20014 addDeletedUsersItem(String deletedUsersItem) {
    this.deletedUsers.add(deletedUsersItem);
    return this;
  }

   /**
   * List of identifiers of deleted users (in ascending order)
   * @return deletedUsers
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of identifiers of deleted users (in ascending order)")
  public List<String> getDeletedUsers() {
    return deletedUsers;
  }

  public void setDeletedUsers(List<String> deletedUsers) {
    this.deletedUsers = deletedUsers;
  }

  public InlineResponse20014 nonDeletedUsers(List<String> nonDeletedUsers) {
    this.nonDeletedUsers = nonDeletedUsers;
    return this;
  }

  public InlineResponse20014 addNonDeletedUsersItem(String nonDeletedUsersItem) {
    this.nonDeletedUsers.add(nonDeletedUsersItem);
    return this;
  }

   /**
   * List of identifiers of not deleted users (in ascending order)
   * @return nonDeletedUsers
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of identifiers of not deleted users (in ascending order)")
  public List<String> getNonDeletedUsers() {
    return nonDeletedUsers;
  }

  public void setNonDeletedUsers(List<String> nonDeletedUsers) {
    this.nonDeletedUsers = nonDeletedUsers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20014 inlineResponse20014 = (InlineResponse20014) o;
    return Objects.equals(this.deletedUsers, inlineResponse20014.deletedUsers) &&
        Objects.equals(this.nonDeletedUsers, inlineResponse20014.nonDeletedUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deletedUsers, nonDeletedUsers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20014 {\n");
    
    sb.append("    deletedUsers: ").append(toIndentedString(deletedUsers)).append("\n");
    sb.append("    nonDeletedUsers: ").append(toIndentedString(nonDeletedUsers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}
