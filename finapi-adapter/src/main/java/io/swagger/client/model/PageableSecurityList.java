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
import io.swagger.client.model.InlineResponse20017Securities;
import io.swagger.client.model.InlineResponse2002Paging;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for page of securities
 */
@ApiModel(description = "Container for page of securities")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class PageableSecurityList {
  @SerializedName("securities")
  private List<InlineResponse20017Securities> securities = new ArrayList<InlineResponse20017Securities>();

  @SerializedName("paging")
  private InlineResponse2002Paging paging = null;

  public PageableSecurityList securities(List<InlineResponse20017Securities> securities) {
    this.securities = securities;
    return this;
  }

  public PageableSecurityList addSecuritiesItem(InlineResponse20017Securities securitiesItem) {
    this.securities.add(securitiesItem);
    return this;
  }

   /**
   * List of securities
   * @return securities
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of securities")
  public List<InlineResponse20017Securities> getSecurities() {
    return securities;
  }

  public void setSecurities(List<InlineResponse20017Securities> securities) {
    this.securities = securities;
  }

  public PageableSecurityList paging(InlineResponse2002Paging paging) {
    this.paging = paging;
    return this;
  }

   /**
   * Get paging
   * @return paging
  **/
  @ApiModelProperty(example = "null", value = "")
  public InlineResponse2002Paging getPaging() {
    return paging;
  }

  public void setPaging(InlineResponse2002Paging paging) {
    this.paging = paging;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageableSecurityList pageableSecurityList = (PageableSecurityList) o;
    return Objects.equals(this.securities, pageableSecurityList.securities) &&
        Objects.equals(this.paging, pageableSecurityList.paging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(securities, paging);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageableSecurityList {\n");
    
    sb.append("    securities: ").append(toIndentedString(securities)).append("\n");
    sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
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
