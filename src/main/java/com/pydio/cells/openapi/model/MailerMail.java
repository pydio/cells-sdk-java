/*
 * Pydio Cells Rest API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.pydio.cells.openapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.model.MailerUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MailerMail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class MailerMail {
  public static final String SERIALIZED_NAME_ATTACHMENTS = "Attachments";
  @SerializedName(SERIALIZED_NAME_ATTACHMENTS)
  private List<String> attachments = null;

  public static final String SERIALIZED_NAME_CC = "Cc";
  @SerializedName(SERIALIZED_NAME_CC)
  private List<MailerUser> cc = null;

  public static final String SERIALIZED_NAME_CONTENT_HTML = "ContentHtml";
  @SerializedName(SERIALIZED_NAME_CONTENT_HTML)
  private String contentHtml;

  public static final String SERIALIZED_NAME_CONTENT_MARKDOWN = "ContentMarkdown";
  @SerializedName(SERIALIZED_NAME_CONTENT_MARKDOWN)
  private String contentMarkdown;

  public static final String SERIALIZED_NAME_CONTENT_PLAIN = "ContentPlain";
  @SerializedName(SERIALIZED_NAME_CONTENT_PLAIN)
  private String contentPlain;

  public static final String SERIALIZED_NAME_DATE_SENT = "DateSent";
  @SerializedName(SERIALIZED_NAME_DATE_SENT)
  private String dateSent;

  public static final String SERIALIZED_NAME_FROM = "From";
  @SerializedName(SERIALIZED_NAME_FROM)
  private MailerUser from;

  public static final String SERIALIZED_NAME_RETRIES = "Retries";
  @SerializedName(SERIALIZED_NAME_RETRIES)
  private Integer retries;

  public static final String SERIALIZED_NAME_SENDER = "Sender";
  @SerializedName(SERIALIZED_NAME_SENDER)
  private MailerUser sender;

  public static final String SERIALIZED_NAME_SUBJECT = "Subject";
  @SerializedName(SERIALIZED_NAME_SUBJECT)
  private String subject;

  public static final String SERIALIZED_NAME_TEMPLATE_DATA = "TemplateData";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_DATA)
  private Map<String, String> templateData = null;

  public static final String SERIALIZED_NAME_TEMPLATE_ID = "TemplateId";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_ID)
  private String templateId;

  public static final String SERIALIZED_NAME_THREAD_INDEX = "ThreadIndex";
  @SerializedName(SERIALIZED_NAME_THREAD_INDEX)
  private String threadIndex;

  public static final String SERIALIZED_NAME_THREAD_UUID = "ThreadUuid";
  @SerializedName(SERIALIZED_NAME_THREAD_UUID)
  private String threadUuid;

  public static final String SERIALIZED_NAME_TO = "To";
  @SerializedName(SERIALIZED_NAME_TO)
  private List<MailerUser> to = null;

  public static final String SERIALIZED_NAME_SEND_ERRORS = "sendErrors";
  @SerializedName(SERIALIZED_NAME_SEND_ERRORS)
  private List<String> sendErrors = null;

  public MailerMail() { 
  }

  public MailerMail attachments(List<String> attachments) {
    
    this.attachments = attachments;
    return this;
  }

  public MailerMail addAttachmentsItem(String attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<String>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

   /**
   * Get attachments
   * @return attachments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getAttachments() {
    return attachments;
  }


  public void setAttachments(List<String> attachments) {
    this.attachments = attachments;
  }


  public MailerMail cc(List<MailerUser> cc) {
    
    this.cc = cc;
    return this;
  }

  public MailerMail addCcItem(MailerUser ccItem) {
    if (this.cc == null) {
      this.cc = new ArrayList<MailerUser>();
    }
    this.cc.add(ccItem);
    return this;
  }

   /**
   * Get cc
   * @return cc
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<MailerUser> getCc() {
    return cc;
  }


  public void setCc(List<MailerUser> cc) {
    this.cc = cc;
  }


  public MailerMail contentHtml(String contentHtml) {
    
    this.contentHtml = contentHtml;
    return this;
  }

   /**
   * Get contentHtml
   * @return contentHtml
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getContentHtml() {
    return contentHtml;
  }


  public void setContentHtml(String contentHtml) {
    this.contentHtml = contentHtml;
  }


  public MailerMail contentMarkdown(String contentMarkdown) {
    
    this.contentMarkdown = contentMarkdown;
    return this;
  }

   /**
   * Get contentMarkdown
   * @return contentMarkdown
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getContentMarkdown() {
    return contentMarkdown;
  }


  public void setContentMarkdown(String contentMarkdown) {
    this.contentMarkdown = contentMarkdown;
  }


  public MailerMail contentPlain(String contentPlain) {
    
    this.contentPlain = contentPlain;
    return this;
  }

   /**
   * Get contentPlain
   * @return contentPlain
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getContentPlain() {
    return contentPlain;
  }


  public void setContentPlain(String contentPlain) {
    this.contentPlain = contentPlain;
  }


  public MailerMail dateSent(String dateSent) {
    
    this.dateSent = dateSent;
    return this;
  }

   /**
   * Get dateSent
   * @return dateSent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDateSent() {
    return dateSent;
  }


  public void setDateSent(String dateSent) {
    this.dateSent = dateSent;
  }


  public MailerMail from(MailerUser from) {
    
    this.from = from;
    return this;
  }

   /**
   * Get from
   * @return from
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public MailerUser getFrom() {
    return from;
  }


  public void setFrom(MailerUser from) {
    this.from = from;
  }


  public MailerMail retries(Integer retries) {
    
    this.retries = retries;
    return this;
  }

   /**
   * Get retries
   * @return retries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getRetries() {
    return retries;
  }


  public void setRetries(Integer retries) {
    this.retries = retries;
  }


  public MailerMail sender(MailerUser sender) {
    
    this.sender = sender;
    return this;
  }

   /**
   * Get sender
   * @return sender
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public MailerUser getSender() {
    return sender;
  }


  public void setSender(MailerUser sender) {
    this.sender = sender;
  }


  public MailerMail subject(String subject) {
    
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSubject() {
    return subject;
  }


  public void setSubject(String subject) {
    this.subject = subject;
  }


  public MailerMail templateData(Map<String, String> templateData) {
    
    this.templateData = templateData;
    return this;
  }

  public MailerMail putTemplateDataItem(String key, String templateDataItem) {
    if (this.templateData == null) {
      this.templateData = new HashMap<String, String>();
    }
    this.templateData.put(key, templateDataItem);
    return this;
  }

   /**
   * Get templateData
   * @return templateData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, String> getTemplateData() {
    return templateData;
  }


  public void setTemplateData(Map<String, String> templateData) {
    this.templateData = templateData;
  }


  public MailerMail templateId(String templateId) {
    
    this.templateId = templateId;
    return this;
  }

   /**
   * Get templateId
   * @return templateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTemplateId() {
    return templateId;
  }


  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }


  public MailerMail threadIndex(String threadIndex) {
    
    this.threadIndex = threadIndex;
    return this;
  }

   /**
   * Get threadIndex
   * @return threadIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getThreadIndex() {
    return threadIndex;
  }


  public void setThreadIndex(String threadIndex) {
    this.threadIndex = threadIndex;
  }


  public MailerMail threadUuid(String threadUuid) {
    
    this.threadUuid = threadUuid;
    return this;
  }

   /**
   * Get threadUuid
   * @return threadUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getThreadUuid() {
    return threadUuid;
  }


  public void setThreadUuid(String threadUuid) {
    this.threadUuid = threadUuid;
  }


  public MailerMail to(List<MailerUser> to) {
    
    this.to = to;
    return this;
  }

  public MailerMail addToItem(MailerUser toItem) {
    if (this.to == null) {
      this.to = new ArrayList<MailerUser>();
    }
    this.to.add(toItem);
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<MailerUser> getTo() {
    return to;
  }


  public void setTo(List<MailerUser> to) {
    this.to = to;
  }


  public MailerMail sendErrors(List<String> sendErrors) {
    
    this.sendErrors = sendErrors;
    return this;
  }

  public MailerMail addSendErrorsItem(String sendErrorsItem) {
    if (this.sendErrors == null) {
      this.sendErrors = new ArrayList<String>();
    }
    this.sendErrors.add(sendErrorsItem);
    return this;
  }

   /**
   * Get sendErrors
   * @return sendErrors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getSendErrors() {
    return sendErrors;
  }


  public void setSendErrors(List<String> sendErrors) {
    this.sendErrors = sendErrors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailerMail mailerMail = (MailerMail) o;
    return Objects.equals(this.attachments, mailerMail.attachments) &&
        Objects.equals(this.cc, mailerMail.cc) &&
        Objects.equals(this.contentHtml, mailerMail.contentHtml) &&
        Objects.equals(this.contentMarkdown, mailerMail.contentMarkdown) &&
        Objects.equals(this.contentPlain, mailerMail.contentPlain) &&
        Objects.equals(this.dateSent, mailerMail.dateSent) &&
        Objects.equals(this.from, mailerMail.from) &&
        Objects.equals(this.retries, mailerMail.retries) &&
        Objects.equals(this.sender, mailerMail.sender) &&
        Objects.equals(this.subject, mailerMail.subject) &&
        Objects.equals(this.templateData, mailerMail.templateData) &&
        Objects.equals(this.templateId, mailerMail.templateId) &&
        Objects.equals(this.threadIndex, mailerMail.threadIndex) &&
        Objects.equals(this.threadUuid, mailerMail.threadUuid) &&
        Objects.equals(this.to, mailerMail.to) &&
        Objects.equals(this.sendErrors, mailerMail.sendErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachments, cc, contentHtml, contentMarkdown, contentPlain, dateSent, from, retries, sender, subject, templateData, templateId, threadIndex, threadUuid, to, sendErrors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailerMail {\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    contentHtml: ").append(toIndentedString(contentHtml)).append("\n");
    sb.append("    contentMarkdown: ").append(toIndentedString(contentMarkdown)).append("\n");
    sb.append("    contentPlain: ").append(toIndentedString(contentPlain)).append("\n");
    sb.append("    dateSent: ").append(toIndentedString(dateSent)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    retries: ").append(toIndentedString(retries)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    templateData: ").append(toIndentedString(templateData)).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    threadIndex: ").append(toIndentedString(threadIndex)).append("\n");
    sb.append("    threadUuid: ").append(toIndentedString(threadUuid)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    sendErrors: ").append(toIndentedString(sendErrors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

