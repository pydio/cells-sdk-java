/*
 * Pydio Cells Rest API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.pydio.sdk.core.api.cells.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * IdmACLSingleQuery
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-30T14:51:15.861Z")
public class IdmACLSingleQuery {
    @SerializedName("Actions")
    private List<IdmACLAction> actions = null;

    @SerializedName("RoleIDs")
    private List<String> roleIDs = null;

    @SerializedName("WorkspaceIDs")
    private List<String> workspaceIDs = null;

    @SerializedName("NodeIDs")
    private List<String> nodeIDs = null;

    @SerializedName("not")
    private Boolean not = null;

    public IdmACLSingleQuery actions(List<IdmACLAction> actions) {
        this.actions = actions;
        return this;
    }

    public IdmACLSingleQuery addActionsItem(IdmACLAction actionsItem) {
        if (this.actions == null) {
            this.actions = new ArrayList<IdmACLAction>();
        }
        this.actions.add(actionsItem);
        return this;
    }

    /**
     * Get actions
     *
     * @return actions
     **/
    @ApiModelProperty(value = "")
    public List<IdmACLAction> getActions() {
        return actions;
    }

    public void setActions(List<IdmACLAction> actions) {
        this.actions = actions;
    }

    public IdmACLSingleQuery roleIDs(List<String> roleIDs) {
        this.roleIDs = roleIDs;
        return this;
    }

    public IdmACLSingleQuery addRoleIDsItem(String roleIDsItem) {
        if (this.roleIDs == null) {
            this.roleIDs = new ArrayList<String>();
        }
        this.roleIDs.add(roleIDsItem);
        return this;
    }

    /**
     * Get roleIDs
     *
     * @return roleIDs
     **/
    @ApiModelProperty(value = "")
    public List<String> getRoleIDs() {
        return roleIDs;
    }

    public void setRoleIDs(List<String> roleIDs) {
        this.roleIDs = roleIDs;
    }

    public IdmACLSingleQuery workspaceIDs(List<String> workspaceIDs) {
        this.workspaceIDs = workspaceIDs;
        return this;
    }

    public IdmACLSingleQuery addWorkspaceIDsItem(String workspaceIDsItem) {
        if (this.workspaceIDs == null) {
            this.workspaceIDs = new ArrayList<String>();
        }
        this.workspaceIDs.add(workspaceIDsItem);
        return this;
    }

    /**
     * Get workspaceIDs
     *
     * @return workspaceIDs
     **/
    @ApiModelProperty(value = "")
    public List<String> getWorkspaceIDs() {
        return workspaceIDs;
    }

    public void setWorkspaceIDs(List<String> workspaceIDs) {
        this.workspaceIDs = workspaceIDs;
    }

    public IdmACLSingleQuery nodeIDs(List<String> nodeIDs) {
        this.nodeIDs = nodeIDs;
        return this;
    }

    public IdmACLSingleQuery addNodeIDsItem(String nodeIDsItem) {
        if (this.nodeIDs == null) {
            this.nodeIDs = new ArrayList<String>();
        }
        this.nodeIDs.add(nodeIDsItem);
        return this;
    }

    /**
     * Get nodeIDs
     *
     * @return nodeIDs
     **/
    @ApiModelProperty(value = "")
    public List<String> getNodeIDs() {
        return nodeIDs;
    }

    public void setNodeIDs(List<String> nodeIDs) {
        this.nodeIDs = nodeIDs;
    }

    public IdmACLSingleQuery not(Boolean not) {
        this.not = not;
        return this;
    }

    /**
     * Get not
     *
     * @return not
     **/
    @ApiModelProperty(value = "")
    public Boolean isNot() {
        return not;
    }

    public void setNot(Boolean not) {
        this.not = not;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdmACLSingleQuery idmACLSingleQuery = (IdmACLSingleQuery) o;
        return Objects.equals(this.actions, idmACLSingleQuery.actions) &&
                Objects.equals(this.roleIDs, idmACLSingleQuery.roleIDs) &&
                Objects.equals(this.workspaceIDs, idmACLSingleQuery.workspaceIDs) &&
                Objects.equals(this.nodeIDs, idmACLSingleQuery.nodeIDs) &&
                Objects.equals(this.not, idmACLSingleQuery.not);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions, roleIDs, workspaceIDs, nodeIDs, not);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdmACLSingleQuery {\n");

        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
        sb.append("    roleIDs: ").append(toIndentedString(roleIDs)).append("\n");
        sb.append("    workspaceIDs: ").append(toIndentedString(workspaceIDs)).append("\n");
        sb.append("    nodeIDs: ").append(toIndentedString(nodeIDs)).append("\n");
        sb.append("    not: ").append(toIndentedString(not)).append("\n");
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

